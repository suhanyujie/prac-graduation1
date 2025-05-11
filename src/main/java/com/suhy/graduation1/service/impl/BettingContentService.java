package com.suhy.graduation1.service.impl;

import com.suhy.graduation1.entity.work1.BettingContentEntity;
import com.suhy.graduation1.mapper.work1.BettingContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BettingContentService {

    @Autowired
    BettingContentMapper bettingContentMapper;

    public List<BettingContentEntity> getBettingContentList(String[] playModes) {
        List<BettingContentEntity> list = bettingContentMapper.getBettingContentByPlayModeCodes(List.of(playModes));
        return list;
    }
}
