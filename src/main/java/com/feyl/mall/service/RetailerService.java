package com.feyl.mall.service;

import com.feyl.mall.entity.Retailer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feyl.mall.entity.dto.RetailerQueryDto;
import com.feyl.mall.entity.vo.RetailerVO;

import java.util.List;

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
}
