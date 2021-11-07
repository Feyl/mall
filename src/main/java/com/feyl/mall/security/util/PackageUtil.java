/*
package com.feyl.mall.security.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

*/
/**
 * @author Feyl
 * @date 2021/10/27 0:36
 *//*

public class PackageUtil {
    public static Collection<GrantedAuthority> packageAuthorityStringToObj(List<String> roles){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for(String role : roles) {
            if(!StringUtils.hasLength(role)) {
                continue;
            }
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        }
        return authorities;
    }
}
*/
