package com.feyl.mall.service.impl;

import com.feyl.mall.entity.SysUser;
import com.feyl.mall.security.entity.SecurityUser;
import com.feyl.mall.service.SysRoleService;
import com.feyl.mall.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Feyl
 * @date 2021/10/27 10:30
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.selectUserByUsername(s);
        SecurityUser user = new SecurityUser();
        BeanUtils.copyProperties(sysUser,user);
        user.setAuths(sysRoleService.selectRolesByUsername(s));
        return user;
    }
}