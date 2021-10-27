package com.feyl.mall.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Feyl
 * @date 2021/10/27 0:06
 */
@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {


    /* springfox为我们提供了一个Docket（摘要的意思）类，我们需要把它做成一个Bean注入到spring中，
       显然，我们需要一个配置文件，并通过一种方式（显然它会是一个注解）告诉程序，这是一个Swagger配置文件。*/
    /**
     * 配置了Swagger的Docket的bean实例
     */
    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//集成必要的 API 信息
                .select()
                /*
                 * RequestHandlerSelectors，配置扫描接口的方式
                 * basePackage：指定要扫描的包
                 * any()：扫描全部
                 * none()：不扫描
                 * withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                 * withMethodAnnotation：扫描方法上的注解
                 * */

                /*
                 * 描述我们的目标包，
                 * 我们项目中接口所在包的完整目录名称，这样 Swagger 就可以扫描到了，
                 * 如果不配置此项，Swagger 是扫描不到我们项目中的接口的。
                 * */
                .apis(RequestHandlerSelectors.basePackage("com.feyl.mall"))
                //规定将我们项目中所有接口的请求路径都暴露给 Swagger 来生成 Swagger-UI 界面
                .paths(PathSelectors.any())
                //将我们设置的上述参数都放到返回的 Docket 实例中
                .build();
    }

    /**
     * 配置Swagger信息
     * 匿名内部类的方式返回一个 ApiInfo 实例
     */
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("Feyl/Mall", "https://www.cqut.edu.cn/", "邮箱待填写");
        return new ApiInfo(
                "水果销售项目 API 文档",     //规定我们的 Swagger-UI 界面的大标题
                "Rest api 文档构建利器",        //规定对 Swagger-UI 界面的一些简单描述信息
                "1.0",          //就是来规定 Swagger-UI 界面上所有接口的版本
                "https://www.cqut.edu.cn/",
                contact,            //规定创建 Swagger-UI 的作者的名称，目前已被废弃
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
