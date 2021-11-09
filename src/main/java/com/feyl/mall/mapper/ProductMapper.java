package com.feyl.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feyl.mall.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 水果商品表 Mapper 接口
 * </p>
 *
 * @author feyl
 * @since 2021-11-01
 */
public interface ProductMapper extends BaseMapper<Product> {

    @Select("SELECT * FROM product ${ew.customSqlSegment}")
    IPage<Product> selectPageOfInfoByCondition(Page<Product> page, @Param(Constants.WRAPPER) Wrapper<Product> queryWrapper);
}
