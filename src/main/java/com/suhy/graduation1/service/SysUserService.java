package com.suhy.graduation1.service;

import com.suhy.graduation1.converter.UserConverter;
import com.suhy.graduation1.dao.SysUserRepository;
import com.suhy.graduation1.dto.SysUserDto;
import com.suhy.graduation1.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SysUserService implements ISysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUserDto getList(long id) {
        SysUserEntity sysUser = sysUserRepository.findById(id).orElseThrow(RuntimeException::new);
        SysUserDto userDto = UserConverter.convertSysUser(sysUser);
        return userDto;
    }

    @Override
    public Long newUser(SysUserDto sysUserDto) {
        // check email if exists
        List<SysUserEntity> users = sysUserRepository.findByEmail(sysUserDto.getEmail());
        if (!CollectionUtils.isEmpty(users)) {
            throw new IllegalStateException("email account exists");
        }
        // add user
        SysUserEntity userEntity = UserConverter.convertToUserEntity(sysUserDto);
        SysUserEntity user = sysUserRepository.save(userEntity);
        return user.getId();
    }

    // update
    @Override
    @Transactional
    public SysUserDto updateUserById(long id, String nickname) {
        // check exists
        SysUserEntity userEntity = sysUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user not exists."));
        if (StringUtils.hasLength(nickname)) {
            userEntity.setNickname(nickname);
        }
        SysUserEntity sysUserEntity = sysUserRepository.save(userEntity);
        SysUserDto userDto = UserConverter.convertSysUser(sysUserEntity);
        return userDto;
    }


    @Override
    public Long deleteUser(long id) {
        sysUserRepository.deleteById(id);
        return 1L;
    }
}
