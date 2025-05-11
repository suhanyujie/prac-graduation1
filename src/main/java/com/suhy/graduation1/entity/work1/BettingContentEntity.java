package com.suhy.graduation1.entity.work1;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "betting_content")
public class BettingContentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lotteryId;
    private Long siteId;
    private String expect;
    private BigDecimal bonus;
    private String bettingContent;
    private String playModeCode;
}
