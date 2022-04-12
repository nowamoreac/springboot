package com.mall.springboot.service.impl;

import com.mall.springboot.entity.User;
import com.mall.springboot.mapper.UserMapper;
import com.mall.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liyajun
 * @since 2022-04-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
