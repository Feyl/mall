package com.feyl.mall.security.config;
/*

import com.feyl.mall.security.filter.TokenAuthenticationFilter;
import com.feyl.mall.security.filter.UsernamePasswordAuthenticationFilterImpl;
import com.feyl.mall.security.handler.AccessDeniedHandlerImpl;
import com.feyl.mall.security.handler.LogoutHandlerImpl;
import com.feyl.mall.security.handler.UnauthorizedEntryPoint;
import com.feyl.mall.security.intercepter.AccessDecisionManagerImpl;
import com.feyl.mall.security.intercepter.FilterInvocationSecurityMetadataSourceImpl;
import com.feyl.mall.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
*/

/**
 * @author Feyl
 * @date 2021/10/27 0:16
 */

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private UserDetailsService userDetailsService;
//    private RedisTemplate redisTemplate;
//    private FilterInvocationSecurityMetadataSourceImpl filterInvocationSecurityMetadataSourceImpl;
//    private AccessDecisionManagerImpl accessDecisionManagerImpl;
//    private AccessDeniedHandlerImpl accessDeniedHandler;
//    private SysRoleService sysRoleService;
//
//    @Autowired
//    public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder,UserDetailsService userDetailsService, RedisTemplate redisTemplate, FilterInvocationSecurityMetadataSourceImpl filterInvocationSecurityMetadataSourceImpl, AccessDecisionManagerImpl accessDecisionManager, AccessDeniedHandlerImpl accessDeniedHandler, SysRoleService sysRoleService) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.userDetailsService = userDetailsService;
//        this.redisTemplate = redisTemplate;
//        this.filterInvocationSecurityMetadataSourceImpl = filterInvocationSecurityMetadataSourceImpl;
//        this.accessDecisionManagerImpl = accessDecisionManager;
//        this.accessDeniedHandler = accessDeniedHandler;
//        this.sysRoleService = sysRoleService;
//    }
//
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler)
//                .authenticationEntryPoint(new UnauthorizedEntryPoint())
//                .and().csrf().disable().cors().and()
//                .formLogin().and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                        o.setSecurityMetadataSource(filterInvocationSecurityMetadataSourceImpl); //动态获取url权限配置
//                        o.setAccessDecisionManager(accessDecisionManagerImpl); //权限判断
//                        return o;
//                    }
//                })
//                .and().logout().logoutUrl("/user/logout")
//                .addLogoutHandler(new LogoutHandlerImpl(redisTemplate))
//                .and()
//                .addFilter(new UsernamePasswordAuthenticationFilterImpl(authenticationManager(),redisTemplate))
//                .addFilter(new TokenAuthenticationFilter(authenticationManager(),redisTemplate,sysRoleService)).httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/error","/favicon.ico","/**/store/**","/admin/**",
//                "/file/**","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
//    }
//
//
///*    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }*/
//
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return userDetailsService;
//    }
//
//}
