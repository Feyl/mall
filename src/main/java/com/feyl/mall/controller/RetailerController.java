package com.feyl.mall.controller;


import com.feyl.mall.common.result.R;
import com.feyl.mall.entity.Retailer;
import com.feyl.mall.entity.dto.RetailerQueryDto;
import com.feyl.mall.entity.vo.RetailerVO;
import com.feyl.mall.service.RetailerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    @ApiOperation("添加零售商信息")
    public R add(@RequestBody Retailer retailer){
        boolean isAdd = retailService.save(retailer);
        if(isAdd) return R.success("添加零售商信息成功");
        else return R.failed("添加零售商信息失败");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除零售商信息")
    public R delete(@PathVariable("id")Long id){
        boolean isDelete = retailService.removeById(id);
        if(isDelete) return R.success("删除零售商信息成功");
        else return R.failed("删除零售商信息失败");
    }

    @PutMapping("/update")
    @ApiOperation("修改零售商信息")
    public R update(@RequestBody Retailer retailer){
        boolean isUpdate = retailService.updateById(retailer);
        if(isUpdate) return R.success("修改零售商信息成功");
        else return R.failed("修改零售商信息失败");
    }

    @GetMapping("/getAllInfo")
    @ApiOperation("获取所有零售商信息")
    public R<List<RetailerVO>> getAllVOInfo(){
        List<RetailerVO> retailerVOs = retailService.VOlist();
        if(retailerVOs.isEmpty()) return R.failed("数据库中零售商信息为空");
        return R.success("所有零售商信息",retailerVOs);
    }

    @PostMapping("/getInfoByCondition")
    @ApiOperation("根据条件获取零售商信息")
    public R<List<RetailerVO>> getVOsByCondition(@RequestBody RetailerQueryDto retailerQueryDto){
        List<RetailerVO> retailerVOs = retailService.getVOsByCondition(retailerQueryDto);
        if(retailerVOs.isEmpty()) return R.failed("查询的零售商信息不存在");
        else return R.success("条件查询的零售商信息",retailerVOs);
    }
}

