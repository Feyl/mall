package com.feyl.mall.controller;


import com.feyl.mall.common.result.R;
import com.feyl.mall.entity.SysUser;
import com.feyl.mall.entity.SysUserRole;
import com.feyl.mall.service.SysUserRoleService;
import com.feyl.mall.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@RestController
@RequestMapping("/admin/user")
@Api(tags = "SysUserController")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserRoleService sysUserRoleService;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register/{type}")

    @ApiOperation("用户注册")
    public R register(@RequestBody SysUser sysUser, @PathVariable("type") Long type){
        if(sysUserService.selectUserByUsername(sysUser.getUsername())!=null){
            return R.failed("用户名已存在，注册失败");
        }
        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
        sysUserService.save(sysUser);
        Long userId = sysUserService.selectUserByUsername(sysUser.getUsername()).getId();
        SysUserRole sysUserRole = new SysUserRole(userId, type);
        sysUserRoleService.save(sysUserRole);
        return R.success("注册成功"); //是否返回用户信息待定
    }
}

