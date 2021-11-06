package com.feyl.mall.security.intercepter;

import com.feyl.mall.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @author Feyl
 * @date 2021/10/27 0:20
 */
@Component
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    SysRolePermissionService sysRolePermissionService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        Set<ConfigAttribute> attributes = new HashSet<>();
        Map<String, List<String>> permissionRoles = sysRolePermissionService.selectPermissionRoles();
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        if(antPathMatcher.match("/admin/user/**",requestUrl)){
            attributes.add(new SecurityConfig("MerchandiseManager"));
            attributes.add(new SecurityConfig("Retailer"));
            attributes.add(new SecurityConfig("Administrator"));
        }else{
            Set<String> urls = permissionRoles.keySet();
            for (String url:urls){
                if (antPathMatcher.match(url,requestUrl)){
                    List<String> roles = permissionRoles.get(url);
                    for (String role : roles) {
                        attributes.add(new SecurityConfig(role));
                    }
                }
            }
        }
        //如果不加这个，没有权限的会直接执行
        if (ObjectUtils.isEmpty(attributes)){
            return SecurityConfig.createList("ROLE_NO_AUTHORITY");
        }
        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
