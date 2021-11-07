package com.feyl.mall.mapper;

import com.feyl.mall.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author feyl
 * @since 2021-10-26
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<String> selectRolesByUsername(String username);

}
