package com.suhy.graduation1.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.suhy.graduation1.entity.work1.BettingContentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class BettingContentServiceTest {

    @Autowired
    BettingContentService bettingContentService;

    @Test
    public void tronConfigDataConvertTest1() {
        String[] playModes = {"tronNetName", "tronApiKey", "tronPrivateKey", "tronSrcAddr", "tronDestAddr"};
        List<BettingContentEntity> bettingContentList = bettingContentService.getBettingContentList(playModes);
        HashMap<String, String> tronConfigMap = data2MapConfig(bettingContentList);
        System.out.printf("%s\n", JSON.toJSONString(tronConfigMap));
    }

    @Test
    public void testConfig2ForUnserialize() {
        String cacheJson = "{\"tronNetName\":\"testnet\",\"tronApiKey\":\"tk-74a11c\",\"tronPrivateKey\":\"a74a11c\",\"tronSrcAddr\":\"TCpRTTAzsZn\",\"tronDestAddr\":\"TGtzcBPT9ddtj\"}";
        HashMap<String, String> tronConfig = JSONObject.parseObject(cacheJson, HashMap.class);
        assert tronConfig.get("tronNetName").equals("testnet");
        System.out.printf("%s\n", tronConfig.get("tronApiKey"));
    }

    public HashMap<String, String> data2MapConfig(List<BettingContentEntity> list) {
        HashMap<String, String> ret = new HashMap<>();
        if (list.isEmpty()) {
            return ret;
        }
        for (BettingContentEntity bettingContentEntity : list) {
            ret.put(bettingContentEntity.getPlayModeCode(), bettingContentEntity.getBettingContent());
        }
        return ret;
    }

    @Test
    public void testConstruct1() {
        A1 a1 = new A1();
    }
}


