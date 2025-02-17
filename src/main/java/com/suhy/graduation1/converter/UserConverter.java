package com.suhy.graduation1.converter;

import com.suhy.graduation1.dto.SysUserDto;
import com.suhy.graduation1.entity.SysUserEntity;
import org.springframework.util.DigestUtils;

public class UserConverter {

    public static SysUserDto convertSysUser(SysUserEntity sysUserEntity) {
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setId(sysUserEntity.getId());
        sysUserDto.setUsername(sysUserEntity.getUsername());
        sysUserDto.setNickname(sysUserEntity.getNickname());
        return sysUserDto;
    }

    public static SysUserEntity convertToUserEntity(SysUserDto sysUserDto) {
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername(sysUserDto.getUsername());
        sysUserEntity.setNickname(sysUserDto.getNickname());
        sysUserEntity.setEmail(sysUserDto.getEmail());
        sysUserEntity.setPhone(sysUserDto.getPhone());
        if (sysUserDto.getPwd().isEmpty()) {
            sysUserDto.setPwd("123456");
        }
        String md5Str = DigestUtils.md5DigestAsHex(sysUserDto.getPwd().getBytes());
        sysUserEntity.setPwd(md5Str);
        sysUserEntity.setStatus(1);

        return sysUserEntity;
    }
}
