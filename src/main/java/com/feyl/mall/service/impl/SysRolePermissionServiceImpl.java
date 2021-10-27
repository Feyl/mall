package com.feyl.mall.service.impl;

import com.feyl.mall.entity.SysRolePermission;
import com.feyl.mall.mapper.SysRolePermissionMapper;
import com.feyl.mall.service.SysRolePermissionService;
//import com.feyl.mall.service.SysRolePermissonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Override
    public Map<String, List<String>> selectPermissionRoles() {
        return null;
    }
}
