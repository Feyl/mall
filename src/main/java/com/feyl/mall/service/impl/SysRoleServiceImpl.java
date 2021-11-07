package com.feyl.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feyl.mall.entity.SysRole;
import com.feyl.mall.mapper.SysRoleMapper;
import com.feyl.mall.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<String> selectRolesByUsername(String username) {
        return baseMapper.selectRolesByUsername(username);
    }
}
