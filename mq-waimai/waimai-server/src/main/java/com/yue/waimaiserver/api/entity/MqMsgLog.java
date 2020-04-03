package com.yue.waimaiserver.api.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
public class MqMsgLog {
    private Integer id;

    private String status;

    private String cause;

    private String exchange;

    private String routingKey;

    private String msg;

    /**
     * TINYINT类型，重试次数
     */
    private Byte tryCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey == null ? null : routingKey.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Byte getTryCount() {
        return tryCount;
    }

    public void setTryCount(Byte tryCount) {
        this.tryCount = tryCount;
    }

    public MqMsgLog() {
    }

    public MqMsgLog(Integer id, String status, String cause, String exchange, String routingKey, String msg, Byte tryCount) {
        this.id = id;
        this.status = status;
        this.cause = cause;
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.msg = msg;
        this.tryCount = tryCount;
    }
}