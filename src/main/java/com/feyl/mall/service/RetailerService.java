package com.feyl.mall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feyl.mall.entity.Retailer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feyl.mall.entity.dto.RetailerQueryDto;
import com.feyl.mall.entity.vo.RetailerVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 零售商表 服务类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
public interface RetailerService extends IService<Retailer> {

    List<RetailerVO> VOlist();

    List<RetailerVO> getVOsByCondition(RetailerQueryDto retailerQueryDto);

    Map<String, Object> getPageOfVOsInfoByCondition(Page<Retailer> page, RetailerQueryDto retailerQueryDto);
}
