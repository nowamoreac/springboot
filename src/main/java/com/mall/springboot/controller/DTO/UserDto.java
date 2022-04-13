package com.mall.springboot.controller.DTO;

import lombok.Data;
import lombok.ToString;

/**
 * @author liyajun
 * @date 2022/4/13 16:51
 * 接收前端 传来的数据
 */
@Data
@ToString
public class UserDto {
    /**
     * 所有的参数
     */
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private String avatarUrl;
}
