package com.feyl.mall.security.handler;

import com.feyl.mall.common.result.R;
import com.feyl.mall.common.result.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Feyl
 * @date 2021/10/27 0:19
 */
public class LogoutHandlerImpl implements LogoutHandler {
    private RedisTemplate redisTemplate;

    public LogoutHandlerImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void logout(HttpServletRequest req, HttpServletResponse resp, Authentication auth) {
        String token = req.getHeader("token");
        if(token!=null){
            redisTemplate.delete("token:"+token);
        }
        ResponseUtil.out(resp, R.ok());
    }
}
