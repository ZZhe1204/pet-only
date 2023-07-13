package com.java.params;

import java.io.Serializable;

/**
 * @author pet.team
 * @Description 订单相关
 */
public class OmsSkuParam implements Serializable {
    /** 商品sku ID */
    private Long skuId;
    /** 商品sku的数量 */
    private Integer skuNum;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }
}
