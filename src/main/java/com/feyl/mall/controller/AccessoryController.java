package com.feyl.mall.controller;


import com.feyl.mall.common.result.R;
import com.feyl.mall.entity.vo.AccessoryVO;
import com.feyl.mall.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 附加商品表 前端控制器
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@RestController
@RequestMapping("/accessory")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

    @GetMapping("/getAccessoriesByProductId/{productId}")
    public R<List<AccessoryVO>> getAccessoriesByProductId(@PathVariable("productId") Long productId){
        List<AccessoryVO> accessoryVOs = accessoryService.selectAccessoriesByProductId(productId);
        if(accessoryVOs.isEmpty()) R.failed("查询的附属商品为空");
        return R.success("附属商品",accessoryVOs);
    }
}

