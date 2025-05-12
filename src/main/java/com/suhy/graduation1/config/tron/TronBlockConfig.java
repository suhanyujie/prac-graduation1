package com.suhy.graduation1.config.tron;

import org.springframework.beans.factory.annotation.Value;

public class TronBlockConfig {

    // 使用的 tron 网络
    @Value("${tron.setting.net}")
    private String tronNet;

    // 主账户的私钥
    @Value("${tron.setting.privateKey}")
    private String privateKey;

    // 主账户的钱包地址
    @Value("${tron.setting.srcAddr}")
    private String srcAddr;

    // 转账的目标账户钱包地址
    @Value("${tron.setting.destAddr}")
    private String destAddr;
}

