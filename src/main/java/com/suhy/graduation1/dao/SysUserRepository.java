package com.suhy.graduation1.dao;

import com.suhy.graduation1.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRepository extends JpaRepository<SysUserEntity, Long> {


    List<SysUserEntity> findByEmail(String email);
}


