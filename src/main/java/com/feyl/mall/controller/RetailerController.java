package com.feyl.mall.controller;


import com.feyl.mall.common.result.R;
import com.feyl.mall.entity.vo.RetailerVO;
import com.feyl.mall.service.RetailerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 零售商表 前端控制器
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@RestController
@RequestMapping("/retailer")
public class RetailerController {

    @Autowired
    private RetailerService retailService;

    @GetMapping("/getAllInfo")
    @ApiOperation("获取所有零售商信息")
    public R<List<RetailerVO>> getAllVOInfo(){
        List<RetailerVO> retailerVOs = retailService.VOlist();
        if(retailerVOs.isEmpty()) return R.failed("数据库中零售商信息为空");
        return R.success("所有零售商信息",retailerVOs);
    }
}

