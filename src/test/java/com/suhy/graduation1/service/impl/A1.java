package com.suhy.graduation1.service.impl;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class A1 {
    private A2 a2;

    HashMap<String, String> tronConfigAttr;

    /**
     * 初始化 tron 配置
     */
    @PostConstruct
    public void initTronConfig() {
        System.out.println("initTronConfig...\n");
    }

    public A1() {
        a2 = new A2();
        System.out.println("A1 instance...\n");
    }

    public void fn1() {
        System.out.println("fn1 exec...");

        if (tronConfigAttr == null) {
            System.out.println("tronConfigAttr is null, initializing...");
            this.tronConfigAttr = new HashMap<>();
            this.tronConfigAttr.put("tronNetName", "testnet");
        } else {
            System.out.printf("%s\n", JSON.toJSONString(this.tronConfigAttr));
        }
    }
}
