package com.suhy.graduation1.service;


import com.suhy.graduation1.dto.SysUserDto;

public interface ISysUserService {

    SysUserDto getList(long id);

    Long newUser(SysUserDto sysUserDto);

    SysUserDto updateUserById(long id, String nickname);

    Long deleteUser(long id);
}
