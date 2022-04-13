package com.mall.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyajun
 * @date 2022/4/13 18:08
 * 接口有统一返回包装类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * @param {code} -> 错误编码
     * @oaram {msg} -> 失败信息
     * @param {data} -> 带回的数据(对象形式)
     */
    private String code;
    private String msg;
    private Object data;
    /**
     * @return {成功信息}
     */
    public static Result success(){
        return new Result(Constants.CODE_200,"",null);
    }

    /**
     * @param {data}
     * @return {带有请求信对象的息}
     */
    public static Result success(Object data){
        return new Result(Constants.CODE_200,"",data);
    }

    /**
     *
     * @param {code} {msg}
     * @return {错误信息反馈}
     */
    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }

    /**
     *
     * @param {code} {msg}
     * @return {系统错误反馈}
     */
    public static Result error(){
        return new Result(Constants.CODE_500,"系统错误",null);
    }
}
