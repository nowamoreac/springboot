package com.mall.springboot.service;

import com.mall.springboot.controller.DTO.UserDto;
import com.mall.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liyajun
 * @since 2022-04-12
 */
@Mapper
public interface IUserService extends IService<User> {

    /**
     *
     * @param userDto
     * @return
     */
    UserDto login(UserDto userDto);

    /**
     *
     * @param userDto
     * @return
     */
    UserDto register(UserDto userDto);
}
