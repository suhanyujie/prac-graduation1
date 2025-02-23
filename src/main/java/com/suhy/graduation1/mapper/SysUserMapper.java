package com.suhy.graduation1.mapper;

import com.suhy.graduation1.entity.SysUserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user")
    List<SysUserEntity> findAll();

    @Select("select * from sys_user where id = #{id}")
    SysUserEntity findById(Long id);

    @Insert("INSERT into sys_user(username, pwd, nickname, email, phone, address) " +
            "VALUES (#{username}, #{pwd}, #{nickname}, #{email}, #{phone})")
    int insert(SysUserEntity sysUserEntity);
}
