package com.feyl.mall.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Feyl
 * @date 2021/10/27 0:15
 */
public class JwtUtil {
    //token过期时间
    private static final long EXPIRE = 1000*60*60*24;
    //密钥
    private static final String SECRET_KEY = "RmV5bA==";

    public static String getJwtToken(String username){
        return Jwts.builder()
                //jwt的头信息(head)
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //jwt所面向的用户
                .setSubject("mall")
                //签发时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                //载荷(payload)携带有效信息
                .claim("username",username)
                //签名
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }


    /**
     * 判断token是否存在且有效
     * @param token token字符串
     * @return
     */
    public static boolean checkToken(String token){
        if(!StringUtils.hasLength(token)){
            return false;
        }
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 判断token是否存在且有效
     * @param req HttpServletRequest请求参数
     * @return
     */
    public static boolean checkToken(HttpServletRequest req){
        try {
            String token = req.getHeader("token");
            if(!StringUtils.hasLength(token)){
                return false;
            }
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 通过客户端传来的token字符串获取用户的email
     * @param token
     * @return
     */
    public static String getUsernameByJwtToken(String token){
        if(!checkToken(token)){
            return "";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("username");
    }

    /**
     * 通过客户端传来的HttpServletRequest请求参数获取token字符串从而获取token中包含的用户email
     * @param req
     * @return
     */
    public static String getUsernameByJwtToken(HttpServletRequest req){
        if(!checkToken(req)){
            return "";
        }
        String token = req.getHeader("token");
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("username");
    }
}
