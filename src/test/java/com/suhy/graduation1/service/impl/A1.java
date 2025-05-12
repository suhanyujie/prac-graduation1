package com.suhy.graduation1.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class A1 {
    private A2 a2;

    /**
     * 初始化 tron 配置
     */
    @PostConstruct
    public void initTronConfig() {
        System.out.println("initTronConfig...\n");
    }

    public A1() {
        a2 = new A2();
        System.out.println("A1 exec...\n");
    }
}
