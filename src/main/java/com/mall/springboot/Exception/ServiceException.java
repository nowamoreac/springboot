package com.mall.springboot.Exception;

import lombok.Getter;

/**
 * @author liyajun
 * @date 2022/4/13 18:51
 */
@Getter
public class ServiceException extends RuntimeException {

    private String code;

    /**
     *
     * @param code
     * @param msg
     */
    public ServiceException(String code,String msg){
        super(msg);
        this.code = code;
    }
}
