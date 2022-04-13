package com.mall.springboot.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.springboot.common.Constants;
import com.mall.springboot.common.Result;
import com.mall.springboot.controller.DTO.UserDto;
import com.mall.springboot.entity.User;
import com.mall.springboot.mapper.UserMapper;
import com.mall.springboot.service.IUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

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

        @Resource
        private UserMapper userMapper;


        /**
         * 新增或者更新用户
         * @param user
         * @return
         */
        @PostMapping
        public boolean save(@RequestBody User user) { return userService.saveOrUpdate(user); }

        /**
         * 按照id删除
         * @param id
         * @return
         */
        @DeleteMapping("/{id}")
        public boolean delete(@PathVariable Integer id) {
                return userService.removeById(id);
        }


        /**
         * 批量删除
         * @param ids
         * @return
         */
        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids) {
                return userService.removeByIds(ids);
        }

        //

        /**
         * 登录
         * @param userDto
         * @return
         */
        @PostMapping("/login")
        public Result login(@RequestBody UserDto userDto){
                //有一个为空
                if(StrUtil.isBlank(userDto.getUsername()) || StrUtil.isBlank(userDto.getPassword())){
                        return Result.error(Constants.CODE_400,"参数错误");
                }
                return Result.success(userService.login(userDto));
        }

        /**
         * 查询所有
         * @return
         */
        @GetMapping
        public List<User> findAll() {
                return userMapper.selectList(null);
        }


        /**
         * 根据id查询
         * @param id
         * @return
         */
        @GetMapping("/{id}")
        public User findOne(@PathVariable Integer id) {
                return userService.getById(id);
        }

        /**
         * 多条件分页查询
         * @param pageNum
         * @param pageSize
         * @param username
         * @param email
         * @param address
         * @return
         */
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

        /**
         * 导出接口
          * @param response
         * @throws Exception
         */
        @GetMapping("/export")

        public void export(HttpServletResponse response) throws Exception{
                //查询出所有的数据
                List<User> list = userMapper.selectList(null);
                //利用hutool  （可以指定磁盘路径） 当前模式为使用浏览器下载
                ExcelWriter writer = ExcelUtil.getWriter(true);
                //自定义标题
//                writer.addHeaderAlias("username", "用户名");
//                writer.addHeaderAlias("password", "密码");
//                writer.addHeaderAlias("nickname", "昵称");
//                writer.addHeaderAlias("email", "邮箱");
//                writer.addHeaderAlias("phone", "电话");
//                writer.addHeaderAlias("address", "地址");
//                writer.addHeaderAlias("createTime", "创建时间");
                //一次性写出list内的对象
                writer.write(list,true);
                //浏览器响应格式
                // 设置浏览器响应的格式
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
                String fileName = URLEncoder.encode("用户信息", "UTF-8");
                response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

                //利用输出流返回到浏览器
                ServletOutputStream out = response.getOutputStream();
                writer.flush(out,true);
                out.close();
                writer.close();
        }

        /**
         * 导入接口
         * bean导入 需要表头和数据库字段对应
         * @param file
         * @return
         * @throws Exception
         */
        @PostMapping("/import")
        public boolean imp(MultipartFile file) throws Exception {
                InputStream inputStream = file.getInputStream();
                ExcelReader reader = ExcelUtil.getReader(inputStream);
                List<User> list = reader.readAll(User.class);
                return userService.saveBatch(list);
        }

        /**
         * 注册接口
         * @param userDto
         * @return
         */
        @PostMapping("/register")
        public Result register(@RequestBody UserDto userDto){
                System.out.println(userDto);
                if(StrUtil.isBlank(userDto.getUsername()) || StrUtil.isBlank(userDto.getPassword())){
                        return Result.error(Constants.CODE_400,"参数错误");
                }
                return Result.success(userService.register(userDto));
        }
}

