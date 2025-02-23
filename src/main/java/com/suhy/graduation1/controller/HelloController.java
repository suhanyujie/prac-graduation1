package com.suhy.graduation1.controller;

import com.suhy.graduation1.Response;
import com.suhy.graduation1.dto.SysUserDto;
import com.suhy.graduation1.entity.SysUserEntity;
import com.suhy.graduation1.mapper.SysUserMapper;
import com.suhy.graduation1.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ISysUserService sysUserService;

    // 基于 jpa 的数据查询
    @GetMapping("/hello/{id}")
    public Response<SysUserDto> hello1(@PathVariable long id) {
        SysUserDto user = sysUserService.getList(id);
        System.out.printf("%s\n", user.toString());

        return Response.success(user);
    }

    // 基于 mybatis 的数据查询
    @GetMapping("/hello2/{id}")
    public Response<SysUserEntity> hello2(@PathVariable long id) {
        SysUserEntity user = sysUserMapper.findById(id);
        System.out.printf("%s\n", user.toString());

        return Response.success(user);
    }

    @PostMapping("/create")
    public Response<?> create(@RequestBody SysUserDto sysUserDto) {
        try {
            long newUid = sysUserService.newUser(sysUserDto);
            System.out.printf("%s\n", newUid);
            return Response.success(newUid);
        } catch (Exception e) {
            return Response.fail(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public Response<?> updateUser(@PathVariable long id,
                                  @RequestParam(required = false) String nickname
    ) {
        sysUserService.updateUserById(id, nickname);
        return Response.success(1);
    }

    @DeleteMapping("/delete/{id}")
    public Response<String> delete(@PathVariable long id) {
        sysUserService.deleteUser(id);
        return Response.success("ok");
    }
}
