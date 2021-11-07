package com.feyl.mall.service;

import com.feyl.mall.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
public interface SysRoleService extends IService<SysRole> {

    List<String> selectRolesByUsername(String username);
}
