package com.feyl.mall.service.impl;

import com.feyl.mall.entity.Product;
import com.feyl.mall.mapper.ProductMapper;
import com.feyl.mall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 水果商品表 服务实现类
 * </p>
 *
 * @author feyl
 * @since 2021-11-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
