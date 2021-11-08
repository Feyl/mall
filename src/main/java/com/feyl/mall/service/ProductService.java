package com.feyl.mall.service;

import com.feyl.mall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feyl.mall.entity.dto.ProductQueryDto;
import com.feyl.mall.entity.vo.ProductVO;

import java.util.List;

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
}
