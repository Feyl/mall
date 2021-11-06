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
 * 访问过滤器
 *
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的token项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 *  如果校验通过，就认为这是一个取得授权的合法请求。
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


    /**
     * 针对使用用户名和密码验证的请求按照约定进行了一定的封装：将username赋值到了principal ，
     * 而将password赋值到了credentials,按照流程，将其传递给AuthenticationManager调用身份验证核心完成相关工作。
     */
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        if (authentication != null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            ResponseUtil.out(resp, R.unauthorized());
        }
        chain.doFilter(req, resp);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req){
        String token = req.getHeader("token");
        if(!redisTemplate.hasKey("token:"+token)){
            return null;
        }

        if(token!=null && !"".equals(token.trim())){
            String username = JwtUtil.getUsernameByJwtToken(token);
            List<String> roles = roleService.selectRolesByUsername(username);
            Collection<GrantedAuthority> authorities = PackageUtil.packageAuthorityStringToObj(roles);
            if(StringUtils.hasLength(username)){
                return new UsernamePasswordAuthenticationToken(username,token,authorities);
            }
        }
        return null;
    }
}