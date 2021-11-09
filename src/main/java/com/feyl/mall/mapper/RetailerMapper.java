package com.feyl.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feyl.mall.entity.Product;
import com.feyl.mall.entity.Retailer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 零售商表 Mapper 接口
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
public interface RetailerMapper extends BaseMapper<Retailer> {

    @Select("SELECT * FROM retailer ${ew.customSqlSegment}")
    IPage<Retailer> selectPageOfInfoByCondition(Page<Retailer> page, @Param(Constants.WRAPPER) Wrapper<Retailer> queryWrapper);

}
