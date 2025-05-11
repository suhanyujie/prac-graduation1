package com.suhy.graduation1.mapper.work1;

import com.suhy.graduation1.entity.work1.BettingContentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BettingContentMapper {
    List<BettingContentEntity> getBettingContentByPlayModeCodes(List<String> playModeCodes);
}
