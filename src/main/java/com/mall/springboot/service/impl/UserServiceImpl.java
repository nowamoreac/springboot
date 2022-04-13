package com.mall.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.springboot.Exception.ServiceException;
import com.mall.springboot.common.Constants;
import com.mall.springboot.controller.DTO.UserDto;
import com.mall.springboot.entity.User;
import com.mall.springboot.mapper.UserMapper;
import com.mall.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
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

    private static final Log LOG = Log.get();

    /**
     * 登录
     * @param userDto
     * @return
     */
    @Override
    public UserDto login(UserDto userDto) {
        User one = getUserInfo(userDto);
        if(one != null){
            BeanUtil.copyProperties(one, userDto,true);
            return userDto;
        }
        else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    /**
     * 目前问题 只能传入username 和 password  此处
     * 注册
     * @param userDto
     * @return
     */
    @Override
    public UserDto register(UserDto userDto) {
        User one = getUserInfo(userDto);
        if (one == null){  //没有找到就可以注册
            one = new User();
            BeanUtil.copyProperties( userDto,one,true);
            save(one);
            return userDto;
        }
        else{
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }

    }

    /**
     * 封装成一个方法 ?(方法貌似是只能传入username and password)
     *  Q: 传入的UserDto是个完整的 但是里面之校验了username and password 在里面找到的也只有这两个（返回的是一个新对象
     * @param userDto
     * @return
     */
    private User getUserInfo(UserDto userDto){
        System.out.println(userDto);
        //先校验
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        queryWrapper.eq("password", userDto.getPassword());
        User one;
        try {
            one = getOne(queryWrapper);  //查到多条记录会抛出异常
        }catch (Exception e){  //sql查询错误报系统异常
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        return one;
    }
}
