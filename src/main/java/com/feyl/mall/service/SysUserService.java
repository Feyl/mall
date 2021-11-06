package com.feyl.mall.service;

import com.feyl.mall.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
public interface SysUserService extends IService<SysUser> {

    SysUser selectUserByUsername(String username);
}
