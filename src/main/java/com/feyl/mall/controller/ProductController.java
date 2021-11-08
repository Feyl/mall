package com.feyl.mall.controller;


import com.feyl.mall.common.result.R;
import com.feyl.mall.entity.Accessory;
import com.feyl.mall.entity.Product;
import com.feyl.mall.entity.dto.ProductQueryDto;
import com.feyl.mall.entity.vo.ProductAccessory;
import com.feyl.mall.entity.vo.ProductVO;
import com.feyl.mall.service.AccessoryService;
import com.feyl.mall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 水果商品表 前端控制器
 * </p>
 *
 * @author feyl
 * @since 2021-11-01
 */
@RestController
@RequestMapping("/product")
@Api(tags = "ProductController")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    AccessoryService accessoryService;

    @PostMapping("/add")
    @ApiOperation("添加商品信息")
    public R add(@RequestBody ProductAccessory productAccessory){
        Product product = productAccessory.getProduct();
        boolean isAdd = productService.save(product);
        List<Accessory> accessories = productAccessory.getAccessories();
        for (Accessory accessory : accessories) {
            accessory.setProductId(product.getId());
            accessoryService.save(accessory);
        }
        if(isAdd) return R.success("添加商品信息成功");
        else return R.failed("添加商品信息失败");
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除商品信息")
    public R delete(@PathVariable("id") Long id){
        boolean isDelete= productService.removeById(id);
        if(isDelete) return R.success("删除商品信息成功");
        else return R.failed("删除商品信息失败");
    }


    @PutMapping("/update")
    @ApiOperation("更新商品信息")
    public R update(@RequestBody Product product){
        boolean isUpdate = productService.updateById(product);
        if(isUpdate) return R.success("更新商品信息成功");
        else return R.failed("更新商品信息失败");
    }

    @GetMapping("/getAllInfo")
    @ApiOperation("获取所有商品信息")
    public R<List<ProductVO>>  getAllVOInfo(){
        List<ProductVO> productVOs = productService.VOlist();
        if(productVOs.isEmpty()) return R.failed("数据库中商品信息为空");
        return R.success("所有商品信息",productVOs);
    }


    @PostMapping("/getInfoByCondition")
    @ApiOperation("根据条件获取商品信息")
    public R<List<ProductVO>> getVOsByCondition(@RequestBody ProductQueryDto productQueryDto){
        List<ProductVO> productVOs = productService.getVOsByCondition(productQueryDto);
        if(productVOs.isEmpty()) return R.failed("查询的商品信息不存在");
        else return R.success("条件查询的商品信息",productVOs);
    }

}

