package com.java.mapper;

import com.java.po.OmsOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OmsOrderMapper {
    public OmsOrder getOrderByUserIdAndOrderNo(@Param("orderNo") String orderNo,@Param("userId") Long userId);
}
