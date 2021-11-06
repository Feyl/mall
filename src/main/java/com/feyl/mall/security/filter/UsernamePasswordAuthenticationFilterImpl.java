package com.feyl.mall.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feyl.mall.common.jwt.JwtUtil;
import com.feyl.mall.common.result.R;
import com.feyl.mall.common.result.ResponseUtil;
import com.feyl.mall.security.entity.SecurityUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Feyl
 * @date 2021/10/27 0:18
 */
public class UsernamePasswordAuthenticationFilterImpl extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private RedisTemplate redisTemplate;

    public UsernamePasswordAuthenticationFilterImpl(AuthenticationManager authenticationManager, RedisTemplate redisTemplate) {
        this.authenticationManager = authenticationManager;
        this.redisTemplate = redisTemplate;
        this.setPostOnly(true);
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login","POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException {
        try {
            SecurityUser user = new ObjectMapper().readValue(req.getInputStream(), SecurityUser.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        String token = JwtUtil.getJwtToken(user.getUsername());
        redisTemplate.opsForValue().set("token:"+token,"");
        ResponseUtil.out(resp, R.success("token",token));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException failed) throws IOException, ServletException {
        ResponseUtil.out(resp, R.unauthorized("账号信息有误,请检查用户名或密码是否正确"));
    }
}
