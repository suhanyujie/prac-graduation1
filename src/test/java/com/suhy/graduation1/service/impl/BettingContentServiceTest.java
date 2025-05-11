package com.suhy.graduation1.service.impl;

import com.alibaba.fastjson2.JSON;
import com.mysql.cj.xdevapi.JsonArray;
import com.suhy.graduation1.entity.work1.BettingContentEntity;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BettingContentServiceTest {

    @Autowired
    BettingContentService bettingContentService;

    @Test
    public void test1() {
        List<String> playModes = new ArrayList<>();
        List<BettingContentEntity> bettingContentList = bettingContentService.getBettingContentList(playModes.toArray(new String[0]));
        System.out.printf("%s\n", JSON.toJSONString(bettingContentList));
    }
}
