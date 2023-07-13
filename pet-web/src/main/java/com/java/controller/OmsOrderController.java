package com.java.controller;

import com.alibaba.fastjson.JSON;
import com.java.constant.Constants;
import com.java.po.OmsOrder;
import com.java.result.Result;
import com.java.service.UmsUserService;
import com.java.thirdpartservice.redis.RedisService;
import com.java.utils.OmsUtils;
import com.java.utils.RedisKeyUtils;
import com.java.vo.OmsCartVo;
import com.java.vo.UmsUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/oms/order")
public class OmsOrderController {
    @Autowired
    private UmsUserService umsUserService;
    @Autowired
    private RedisService redisService;
    /**
     * 生成订单
     * @param request
     * @return
     */
    @GetMapping("/add")
    public Result add(HttpServletRequest request){
        String token = request.getHeader(Constants.Auth.HEADER_TOKEN_KEY_NAME);
        //1.通过token获取用户
        UmsUserVo umsUser = umsUserService.getUmsUserByToken(token);
        //2.获取用户购物车   Map<key,Map<hashkey,Object>>
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_CART, "107");
        Map<String, String> map = redisService.getMap(key);
        System.out.println(map);

        //3.对购物车商品生成订单和订单项，插入数据库
        //3.1获取订单
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setUserId(umsUser.getId());
        omsOrder.setOrderNo(OmsUtils.generateOrderNo());

        BigDecimal totalMoney = new BigDecimal(0);
        Integer totalNum=0;
        //3.2获取购物车商品
        for (Map.Entry<String,String> entry:map.entrySet()){
            String skuId = entry.getKey();
            String value = entry.getValue();
            OmsCartVo omsCartVo = JSON.parseObject(value, OmsCartVo.class);
            Integer num = omsCartVo.getNum();
            totalNum+=num;
            BigDecimal bigNum = new BigDecimal(num);
            BigDecimal price = omsCartVo.getPrice();
            totalMoney=bigNum.multiply(price);

            //4.1把购物车商品封装成订单项，插入订单项表，清空购物车

        }
        //设置订单总价
        omsOrder.setTotalMoney(totalMoney);
        omsOrder.setPayMoney(totalMoney);
        omsOrder.setTotalNum(totalNum);
        omsOrder.setPayType(Constants.Order.PayWay.ONLINE);
        omsOrder.setOrderStatus(Constants.Order.Status.OBLIGATION);
        omsOrder.setPayStatus(Constants.Order.PayStatus.WAIT);
        omsOrder.setReceiverName(umsUser.getUserName());//用户名作为收货人名字
        omsOrder.setReceiverPhone(umsUser.getAccount());//注册的手机号
        //把订单插入订单表中，返回订单主键，在订单项中使用（mapper写方法插入订单：自己补全）

        //4.获取订单项对象








        return null;


    }
}
