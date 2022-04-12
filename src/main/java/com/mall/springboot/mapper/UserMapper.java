package com.mall.springboot.mapper;

import com.mall.springboot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liyajun
 * @since 2022-04-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
