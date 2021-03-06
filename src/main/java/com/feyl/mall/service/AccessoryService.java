package com.feyl.mall.service;

import com.feyl.mall.entity.Accessory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feyl.mall.entity.vo.AccessoryVO;

import java.util.List;

/**
 * <p>
 * 附加商品表 服务类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
public interface AccessoryService extends IService<Accessory> {

    List<AccessoryVO> selectAccessoriesByProductId(Long productId);
}
