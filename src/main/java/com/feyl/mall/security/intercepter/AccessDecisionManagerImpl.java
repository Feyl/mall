package com.feyl.mall.security.intercepter;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Feyl
 * @date 2021/10/27 0:20
 */
@Component
public class AccessDecisionManagerImpl implements AccessDecisionManager {

    /**
     *
     * @param authentication 获取当前用户具有的权限
     * @param collection 当前请求需要的权限
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (ConfigAttribute configAttribute : collection) {
            String needAuth= configAttribute.getAttribute();
            for (GrantedAuthority authority : authorities) {
                if ("admin".equals(authority.getAuthority())){
                    return;
                }
                if(needAuth.equals(authority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("NO_AUTHORITY!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
