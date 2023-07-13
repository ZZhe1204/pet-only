package com.java.utils;



import com.aliyun.core.utils.StringUtils;
import com.java.constant.Constants;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pet.team
 * @Description 订单相关工具类
 */
public class OmsUtils {

    private static Integer initValue = 1000;
    private static Integer maxValue = 9999;
    private static final AtomicInteger SEQ = new AtomicInteger(initValue);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");

    /**
     * 生成订单编号
     * yyyyMMddHHmmssSS(时间戳) + 4位随机数
     *
     * @return
     */
    public static String generateOrderNo() {
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if (SEQ.intValue() > maxValue) {
            SEQ.getAndSet(initValue);
        }
        return dataTime.format(DF_FMT_PREFIX) + SEQ.getAndIncrement();
    }

    /**
     * 生成订单过期时间：当前时间延后半个小时
     * @return
     */
    public static String generateOrderExpirationTime() {
        long currentTime = System.currentTimeMillis() + Constants.Time.ORDER_KEEP_TIME;
        Date date = new Date(currentTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }


    /**
     * 创建支付订单号
     * 根据系统订单号生成支付订单号，支付订单号规则为：系统订单号 + 6位随机数
     * 作用：以便同一系统订单可多次向微信、支付宝发起支付请求（满足误关支付页面、支付失败重新支付等需求）
     * @param orderNo
     * @return
     */
    public static String createPayOrderNo(String orderNo){
        StringBuilder payOrderNo = new StringBuilder();
        if(!StringUtils.isBlank(orderNo)){
            payOrderNo.append(orderNo).append(MathUtils.random(Constants.Pay.ORDER_NO_APPEND_SIZE));
        }
        return payOrderNo.toString();
    }

    /**
     * 根据支付宝、微信回调接口入参中的第三方支付订单号获得项目订单号
     * 规则：移除第三方支付订单号中的后6位支付
     * @param outTradeNo
     * @return
     */
    public static String getPayOrderNo(String outTradeNo){
        String orderNo = outTradeNo;
        if(!StringUtils.isBlank(outTradeNo) && outTradeNo.length() > Constants.Pay.ORDER_NO_APPEND_SIZE){
            orderNo = outTradeNo.substring(0, outTradeNo.length() - Constants.Pay.ORDER_NO_APPEND_SIZE);
        }
        return orderNo;
    }

}
