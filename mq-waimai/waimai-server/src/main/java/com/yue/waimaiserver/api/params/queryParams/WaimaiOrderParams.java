package com.yue.waimaiserver.api.params.queryParams;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: lsSaitaoYue
 * @Create: 2020/4/3 17:23
 */
@Data
public class WaimaiOrderParams {

    @NotNull
    private Integer userId;
    @NotNull
    private Integer salerId;
    @NotNull
    private Integer goodId;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderTime;
    @NotNull
    private BigDecimal totalPrice;
}
