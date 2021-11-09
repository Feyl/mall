package com.feyl.mall.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feyl.mall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feyl.mall.entity.dto.ProductQueryDto;
import com.feyl.mall.entity.vo.ProductVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 水果商品表 服务类
 * </p>
 *
 * @author feyl
 * @since 2021-11-01
 */
public interface ProductService extends IService<Product> {

    List<ProductVO> VOlist();

    List<ProductVO> getVOsByCondition(ProductQueryDto productQueryDto);

    Map<String,Object> getPageOfVOsInfoByCondition(Page<Product> page, ProductQueryDto productQueryDto);
}
