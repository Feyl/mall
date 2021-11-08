package com.feyl.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feyl.mall.entity.Product;
import com.feyl.mall.entity.dto.ProductQueryDto;
import com.feyl.mall.entity.vo.ProductVO;
import com.feyl.mall.mapper.ProductMapper;
import com.feyl.mall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author feyl
 * @since 2021-11-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public List<ProductVO> VOlist() {
        List<Product> products = baseMapper.selectList(new QueryWrapper<>());
        List<ProductVO> productVOs = new ArrayList<>();
        for (Product product : products) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product,productVO);
            productVOs.add(productVO);
        }
        return productVOs;
    }

    @Override
    public List<ProductVO> getVOsByCondition(ProductQueryDto productQueryDto) {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        if(productQueryDto.getName()!=null) qw.like("name",productQueryDto.getName());
        if(productQueryDto.getLocality()!=null) qw.like("locality",productQueryDto.getLocality());
        if(productQueryDto.getStatus()!=null) qw.eq("status",productQueryDto.getStatus());
        if(productQueryDto.getLowerPrice()!=null) qw.ge("price",productQueryDto.getLowerPrice());
        if(productQueryDto.getUpperPrice()!=null) qw.le("price",productQueryDto.getUpperPrice());
        if(productQueryDto.getStartTime()!=null) qw.ge("create_time",productQueryDto.getStartTime());
        if(productQueryDto.getEndTime()!=null) qw.le("create_time",productQueryDto.getEndTime());
        List<Product> products = baseMapper.selectList(qw);
        List<ProductVO> productVOs = new ArrayList<>();
        for (Product product : products) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product,productVO);
            productVOs.add(productVO);
        }
        return productVOs;
    }
}
