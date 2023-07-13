package com.java.service;

import com.java.po.OmsOrder;

import javax.security.auth.login.LoginContext;

public interface OmsOrderService {
    public OmsOrder getOrderByUserIdAndOrderNo(String orderNo, Long userId);
}
