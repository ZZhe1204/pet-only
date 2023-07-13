package com.java.controller;

import com.java.constant.Constants;
import com.java.exception.BaseException;
import com.java.po.OmsOrder;
import com.java.result.Result;
import com.java.result.ResultEnum;
import com.java.service.OmsOrderService;
import com.java.service.UmsUserService;
import com.java.thirdpartservice.aliyun.pay.AliPayService;
import com.java.utils.ResultUtils;
import com.java.vo.UmsUserVo;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/api/oms/pay")
@Controller
public class OmsPayController {
    @Autowired
    private UmsUserService umsUserService;
    @Autowired
    private OmsOrderService omsOrderService;
    @Autowired
    private AliPayService aliPayService;
    @GetMapping("/aliPay")
    public void pay(String orderNo, HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        //1.获取token
        String token = request.getHeader(Constants.Auth.HEADER_TOKEN_KEY_NAME);
        //2.获取用户
      //  UmsUserVo user = umsUserService.getUmsUserByToken(token);
        //3.根据用户id，订单编号查询订单
        OmsOrder order = omsOrderService.getOrderByUserIdAndOrderNo(orderNo, 90l);
        //4.判断订单是否存在
        if (StringUtils.isEmpty(order)){//判断订单不存在
            throw new BaseException(ResultEnum.ORDER_NOT_EXIST);
        }
        //订单状态，
        if (order.getOrderStatus()!=Constants.Order.Status.OBLIGATION){
            //表示订单已经支付了
            throw new BaseException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //5.订单正常，可以支付
        String pay = aliPayService.pay(order.getPayMoney().toString(), orderNo);
        //6.把返回值pay显示到浏览器中
        try {
            response.getWriter().println(pay);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
