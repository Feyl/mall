package com.feyl.mall.security.filter;

import com.feyl.mall.common.jwt.JwtUtil;
import com.feyl.mall.common.result.R;
import com.feyl.mall.common.result.ResponseUtil;
import com.feyl.mall.security.util.PackageUtil;
import com.feyl.mall.service.SysRoleService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author Feyl
 * @date 2021/10/27 0:18
 */
public class TokenAuthenticationFilter extends BasicAuthenticationFilter {
    private RedisTemplate redisTemplate;
    private SysRoleService roleService;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager, RedisTemplate redisTemplate, SysRoleService roleService) {
        super(authenticationManager);
        this.redisTemplate = redisTemplate;
        this.roleService = roleService;
    }


   /* @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        if (authentication != null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            ResponseUtil.out(resp, R.error().code(408).message("token过期"));
        }
        chain.doFilter(req, resp);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req){
        String token = req.getHeader("token");
        if(!redisTemplate.hasKey("token:"+token)){
            return null;
        }

        if(token!=null && !"".equals(token.trim())){
            String email = JwtUtil.getEmailByJwtToken(token);
            List<String> roles = roleService.selectRolesByUsername(email);
            Collection<GrantedAuthority> authorities = PackageUtil.packageAuthorityStringToObj(roles);
            if(StringUtils.hasLength(email)){
                return new UsernamePasswordAuthenticationToken(email,token,authorities);
            }
        }
        return null;
    }*/
}