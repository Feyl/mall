package com.feyl.mall.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feyl
 * @date 2021/10/27 0:07
 */
//统一返回的数据格式
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class R<T> {

    /**
     * 状态码
     */
    private long code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;


    public static <T> R <T> success(){
        return new R<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(), null);
    }



    /**
     * 成功返回结果
     * @param message 提示信息
     */
    public static <T> R<T> success(String message){
        return new R<>(ResultCode.SUCCESS.getCode(),message, null);
    }


    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> R<T> success(String message,T data){
        return new R<>(ResultCode.SUCCESS.getCode(),message, data);
    }


    public static <T> R<T> failed(){
        return new R<>(ResultCode.FAILED.getCode(),ResultCode.SUCCESS.getMessage(), null);
    }


    /**
     * 失败返回结果
     * @param  message 提示信息
     */
    public static <T> R<T> failed(String message){
        return new R<>(ResultCode.FAILED.getCode(),message,null);
    }




    /**
     * 参数验证失败返回结果
     */
    public static <T> R<T> validateFailed(){
        return new R<>(ResultCode.FAILED.getCode(),ResultCode.VALIDATE_FAILED.getMessage(), null);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> R<T> validateFailed(String message){
        return new R<>(ResultCode.FAILED.getCode(),message, null);
    }


    /**
     * 未认证返回结果
     */
    public static <T> R<T> unauthorized(){
        return new R<>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    /**
     * 未认证返回结果
     * @param message 提示信息
     */
    public static <T> R<T> unauthorized(String message){
        return new R<>(ResultCode.UNAUTHORIZED.getCode(),message, null);
    }

    /**
     * 未授权返回结果
     */
    public static <T> R<T> forbidden(){
        return new R<>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(), null);
    }

    /**
     * 未授权返回结果
     * @param message 提示信息
     */
    public static <T> R<T> forbidden(String message){
        return new R<>(ResultCode.FORBIDDEN.getCode(),message, null);
    }
}
