/*
package com.feyl.mall.security.entity;

import com.feyl.mall.security.util.PackageUtil;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

*/
/**
 * @author Feyl
 * @date 2021/10/27 0:17
 *//*

@Data
public class SecurityUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private List<String> auths;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return PackageUtil.packageAuthorityStringToObj(auths);
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
*/
