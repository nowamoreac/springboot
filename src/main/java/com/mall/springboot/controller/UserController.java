package com.mall.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.mall.springboot.service.IUserService;
import com.mall.springboot.entity.User;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liyajun
 * @since 2022-04-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

@Resource
private IUserService userService;


// 新增或者更新
@PostMapping
public boolean save(@RequestBody User user) {return userService.saveOrUpdate(user);}
//按照id删除
@DeleteMapping("/{id}")
public Boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
        }
//批量删除
@PostMapping("/del/batch")
public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeByIds(ids);
        }

//查询所有
@GetMapping
public List<User> findAll() {
        return userService.list();
        }
//根据id查询
@GetMapping("/{id}")
public User findOne(@PathVariable Integer id) {
        return userService.getById(id);
        }
//分页查询
@GetMapping("/page")
public Page<User> findPage(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "")String username,
                           @RequestParam(defaultValue = "")String email,
                           @RequestParam(defaultValue = "")String address) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);
        queryWrapper.like("email", email);
        queryWrapper.like("address", address);
        queryWrapper.orderByDesc("id");
        return userService.page(new Page<>(pageNum, pageSize), queryWrapper);
}

}

