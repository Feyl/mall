package com.feyl.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feyl.mall.entity.Accessory;
import com.feyl.mall.entity.vo.AccessoryVO;
import com.feyl.mall.mapper.AccessoryMapper;
import com.feyl.mall.service.AccessoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 附加商品表 服务实现类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@Service
public class AccessoryServiceImpl extends ServiceImpl<AccessoryMapper, Accessory> implements AccessoryService {

    @Override
    public List<AccessoryVO> selectAccessoriesByProductId(Long productId) {
        QueryWrapper<Accessory> qw = new QueryWrapper<>();
        qw.eq("product_id",productId);
        List<Accessory> accessories = baseMapper.selectList(qw);
        List<AccessoryVO> accessoryVOs = new ArrayList<>();
        for (Accessory accessory : accessories) {
            AccessoryVO accessoryVO = new AccessoryVO();
            BeanUtils.copyProperties(accessory,accessoryVO);
            accessoryVOs.add(accessoryVO);
        }
        return accessoryVOs;
    }
}
