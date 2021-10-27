package com.feyl.mall.service;

import com.feyl.mall.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色权限关联表 服务类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {
    Map<String, List<String>> selectPermissionRoles();
}
