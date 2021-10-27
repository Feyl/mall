package com.feyl.mall.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feyl
 * @date 2021/10/27 0:07
 */
//统一返回的数据格式
@Data
public class R<T> {
    //是否成功
    private Boolean success;

    //返回的状态码
    private Integer code;

    //返回的消息
    private String message;

    //返回的数据
    private Map<String,T> data = new HashMap<>();


    private R(){}

    public static <T> R<T> ok(){
        R<T> r = new R<>();
        r.success(true);
        r.code(ResultCode.SUCCESS);
        r.message("成功");
        return r;
    }


    public static <T> R<T> error(){
        R<T> r = new R<>();
        r.success(false);
        r.code(ResultCode.ERROR);
        r.message("失败");
        return r;
    }


    public static <T> R<T> error(Integer code,String message){
        R<T> r = new R<>();
        r.success(false);
        r.code(code);
        r.message(message);
        return r;
    }

    public R<T> success(Boolean success) {
        this.success = success;
        return this;
    }

    public R<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public R<T> message(String message) {
        this.message = message;
        return this;
    }


    public R<T> data(String key, T value){
        this.data.put(key, value);
        return this;
    }

    public R<T> data(Map<String, T> map){
        this.setData(map);
        return this;
    }
}
