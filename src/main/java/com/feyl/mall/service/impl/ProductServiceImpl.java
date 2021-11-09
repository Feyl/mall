package com.feyl.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feyl.mall.entity.Product;
import com.feyl.mall.entity.dto.ProductQueryDto;
import com.feyl.mall.entity.vo.ProductVO;
import com.feyl.mall.mapper.ProductMapper;
import com.feyl.mall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return packageDaoToVo(products);
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
        return packageDaoToVo(products);
    }



    @Override
    public Map<String, Object> getPageOfVOsInfoByCondition(Page<Product> page, ProductQueryDto productQueryDto) {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        if(productQueryDto.getName()!=null) qw.like("name",productQueryDto.getName());
        if(productQueryDto.getLocality()!=null) qw.like("locality",productQueryDto.getLocality());
        if(productQueryDto.getStatus()!=null) qw.eq("status",productQueryDto.getStatus());
        if(productQueryDto.getLowerPrice()!=null) qw.ge("price",productQueryDto.getLowerPrice());
        if(productQueryDto.getUpperPrice()!=null) qw.le("price",productQueryDto.getUpperPrice());
        if(productQueryDto.getStartTime()!=null) qw.ge("create_time",productQueryDto.getStartTime());
        if(productQueryDto.getEndTime()!=null) qw.le("create_time",productQueryDto.getEndTime());
        IPage<Product> productIPage = baseMapper.selectPageOfInfoByCondition(page,qw);
        Long productTotalNumber = productIPage.getTotal();
        List<Product> products = productIPage.getRecords();
        List<ProductVO> productVOs = packageDaoToVo(products);
        Map<String, Object> pageOfVOsInfo = new HashMap<>();
        pageOfVOsInfo.put("productTotalNumber",productTotalNumber);
        pageOfVOsInfo.put("productsInfo",productVOs);
        return pageOfVOsInfo;
    }


    private  List<ProductVO> packageDaoToVo(List<Product> products){
        List<ProductVO> productVOs = new ArrayList<>();
        for (Product product : products) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product,productVO);
            productVOs.add(productVO);
        }
        return productVOs;
    }
}
