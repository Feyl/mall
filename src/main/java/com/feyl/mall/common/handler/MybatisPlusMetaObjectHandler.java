package com.feyl.mall.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Feyl
 * @date 2021/11/6 21:20
 */

@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        /**
         * mybatisplus自定义填充公共字段 ,即没有传的字段自动填充
         * 第一个参数是数据库逻辑删除字段名称，第二个参数是你默认添加的逻辑删除字段数据
         */
        setFieldValByName("createTime", new Date(), metaObject);
        setFieldValByName("isDeleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
    }
}