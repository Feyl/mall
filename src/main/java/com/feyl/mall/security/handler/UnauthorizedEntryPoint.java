package com.feyl.mall.security.handler;

import com.feyl.mall.common.result.R;
import com.feyl.mall.common.result.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Feyl
 * @date 2021/10/27 0:20
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.out(resp, R.unauthorized());
    }
}