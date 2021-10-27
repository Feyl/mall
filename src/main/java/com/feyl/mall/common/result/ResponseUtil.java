package com.feyl.mall.common.result;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Feyl
 * @date 2021/10/27 0:08
 */

public class ResponseUtil {
    public static void out(HttpServletResponse resp, R r) {
        ObjectMapper mapper = new ObjectMapper();
        resp.setStatus(HttpStatus.OK.value());
        resp.setContentType("application/json;charset=utf-8");
        try {
            mapper.writeValue(resp.getWriter(), r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
