package com.java.service.impl;

import com.java.mapper.OmsOrderMapper;
import com.java.po.OmsOrder;
import com.java.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Override
    public OmsOrder getOrderByUserIdAndOrderNo(String orderNo, Long userId) {
        return omsOrderMapper.getOrderByUserIdAndOrderNo(orderNo,userId);
    }
}
