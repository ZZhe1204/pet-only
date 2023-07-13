package com.java.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* @author pet.team
* @Description 订单商品明细表
*/
public class OmsOrderItem implements Serializable {
    /** 主键ID */
    private Long id;
    /** 订单ID(对应订单表主键ID) */
    private Long orderId;
    /** 商品spuID(对应商品spu表主键ID) */
    private Long spuId;
    /** 商品图片 */
    private String productPic;
    /** 商品名称 */
    private String productName;
    /** 销售价格 */
    private BigDecimal productPrice;
    /** 购买数量 */
    private Integer productQuantity;
    /** 商品skuID(对应商品sku表主键ID) */
    private Long skuId;
    /** 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}] */
    private String productAttr;
    /** get set 方法 */
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setOrderId (Long  orderId){
        this.orderId=orderId;
    }
    public  Long getOrderId(){
        return this.orderId;
    }
    public void setSpuId (Long  spuId){
        this.spuId=spuId;
    }
    public  Long getSpuId(){
        return this.spuId;
    }
    public void setProductPic (String  productPic){
        this.productPic=productPic;
    }
    public  String getProductPic(){
        return this.productPic;
    }
    public void setProductName (String  productName){
        this.productName=productName;
    }
    public  String getProductName(){
        return this.productName;
    }
    public void setProductPrice (BigDecimal  productPrice){
        this.productPrice=productPrice;
    }
    public  BigDecimal getProductPrice(){
        return this.productPrice;
    }
    public void setProductQuantity (Integer  productQuantity){
        this.productQuantity=productQuantity;
    }
    public  Integer getProductQuantity(){
        return this.productQuantity;
    }
    public void setSkuId (Long  skuId){
        this.skuId=skuId;
    }
    public  Long getSkuId(){
        return this.skuId;
    }
    public void setProductAttr (String  productAttr){
        this.productAttr=productAttr;
    }
    public  String getProductAttr(){
        return this.productAttr;
    }
}
