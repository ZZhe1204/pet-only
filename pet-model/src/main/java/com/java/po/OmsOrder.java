package com.java.po;
import java.math.BigDecimal;
import java.util.Date;

/**
* @author pet.team
* @Description 订单表
*/
public class OmsOrder {
    /** 主键ID */
    private Long id;
    /** 用户ID(对应用户表主键ID) */
    private Long userId;
    /** 订单编号 */
    private String orderNo;
    /** 订单总金额合计 */
    private BigDecimal totalMoney;
    /** 实付金额合计 */
    private BigDecimal payMoney;
    /** 数量合计 */
    private Integer totalNum;
    /** 支付方式：0->在线支付；1->货到付款 */
    private Integer payType;
    /** 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->超时 */
    private Integer orderStatus;
    /** 支付状态：支付状态：0->未支付；1->支付中；2->支付成功；3->支付失败 */
    private Integer payStatus;
    /** 支付时间 */
    private Date payTime;
    /** 收件人名称 */
    private String receiverName;
    /** 收件人电话 */
    private String receiverPhone;
    /** 收件人地址 */
    private String receiverAddress;
    /** 订单过期时间 */
    private Date expirationTime;
    /** 创建时间 */
    private Date createdTime;
    /** 修改时间 */
    private Date updatedTime;
    /** get set 方法 */
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setUserId (Long  userId){
        this.userId=userId;
    }
    public  Long getUserId(){
        return this.userId;
    }
    public void setOrderNo (String  orderNo){
        this.orderNo=orderNo;
    }
    public  String getOrderNo(){
        return this.orderNo;
    }
    public void setTotalMoney (BigDecimal  totalMoney){
        this.totalMoney=totalMoney;
    }
    public  BigDecimal getTotalMoney(){
        return this.totalMoney;
    }
    public void setPayMoney (BigDecimal  payMoney){
        this.payMoney=payMoney;
    }
    public  BigDecimal getPayMoney(){
        return this.payMoney;
    }
    public void setTotalNum (Integer  totalNum){
        this.totalNum=totalNum;
    }
    public  Integer getTotalNum(){
        return this.totalNum;
    }
    public void setPayType (Integer  payType){
        this.payType=payType;
    }
    public  Integer getPayType(){
        return this.payType;
    }
    public void setOrderStatus (Integer  orderStatus){
        this.orderStatus=orderStatus;
    }
    public  Integer getOrderStatus(){
        return this.orderStatus;
    }
    public void setPayStatus (Integer  payStatus){
        this.payStatus=payStatus;
    }
    public  Integer getPayStatus(){
        return this.payStatus;
    }
    public void setPayTime (Date  payTime){
        this.payTime=payTime;
    }
    public  Date getPayTime(){
        return this.payTime;
    }
    public void setReceiverName (String  receiverName){
        this.receiverName=receiverName;
    }
    public  String getReceiverName(){
        return this.receiverName;
    }
    public void setReceiverPhone (String  receiverPhone){
        this.receiverPhone=receiverPhone;
    }
    public  String getReceiverPhone(){
        return this.receiverPhone;
    }
    public void setReceiverAddress (String  receiverAddress){
        this.receiverAddress=receiverAddress;
    }
    public  String getReceiverAddress(){
        return this.receiverAddress;
    }
    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }
    public void setCreatedTime (Date  createdTime){
        this.createdTime=createdTime;
    }
    public  Date getCreatedTime(){
        return this.createdTime;
    }
    public void setUpdatedTime (Date  updatedTime){
        this.updatedTime=updatedTime;
    }
    public  Date getUpdatedTime(){
        return this.updatedTime;
    }
}
