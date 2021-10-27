package com.feyl.mall.service.impl;

import com.feyl.mall.entity.SysUser;
import com.feyl.mall.mapper.SysUserMapper;
import com.feyl.mall.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser selectUserByUsername(String s) {
        return null;
    }
}
