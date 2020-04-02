package com.yue.mqseckill.api.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/3/25 15:42
 */
@Data
public class CommitOrderDto implements Serializable {

    @NotNull
    private int userId;
    @NotNull
    private String targetAddr;
    @NotNull
    private int goodId;
    @Min(1)
    private long count;

    public CommitOrderDto(@NotNull int userId, @NotNull String targetAddr, @NotNull int goodId, @Min(1) long count) {
        this.userId = userId;
        this.targetAddr = targetAddr;
        this.goodId = goodId;
        this.count = count;
    }

    public CommitOrderDto() {
    }
}
