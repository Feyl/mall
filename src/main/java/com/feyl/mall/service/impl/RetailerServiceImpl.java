package com.feyl.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feyl.mall.entity.Retailer;
import com.feyl.mall.entity.vo.RetailerVO;
import com.feyl.mall.mapper.RetailerMapper;
import com.feyl.mall.service.RetailerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 零售商表 服务实现类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@Service
public class RetailerServiceImpl extends ServiceImpl<RetailerMapper, Retailer> implements RetailerService {

    @Override
    public List<RetailerVO> VOlist() {
        List<Retailer> retailers = baseMapper.selectList(new QueryWrapper<>());
        List<RetailerVO> retailerVOs = new ArrayList<>();
        for (Retailer retailer : retailers) {
            RetailerVO retailerVO = new RetailerVO();
            BeanUtils.copyProperties(retailer,retailerVO);
            retailerVOs.add(retailerVO);
        }
        return retailerVOs;
    }
}
