package com.java.params;

import java.io.Serializable;
import java.util.List;

/**
 * @author pet.team
 * @Description 订单入参包装类
 */
public class OmsOrderParam implements Serializable {
    /** 商品sku信息数组 */
    List<OmsSkuParam> skuInfos;
    /** 用户ID(对应用户表主键ID) */
    private Long userId;
    /** 收件人名称 */
    private String receiverName;
    /** 收件人电话 */
    private String receiverPhone;
    /** 收件人地址 */
    private String receiverAddress;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OmsSkuParam> getSkuInfos() {
        return skuInfos;
    }

    public void setSkuInfos(List<OmsSkuParam> skuInfos) {
        this.skuInfos = skuInfos;
    }
}
