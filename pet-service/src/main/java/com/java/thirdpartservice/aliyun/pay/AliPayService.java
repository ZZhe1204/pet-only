package com.java.thirdpartservice.aliyun.pay;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import org.springframework.stereotype.Service;

@Service
public class AliPayService {
    public String pay(String money,String orderNo){
        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(getOptions());
        AlipayTradePagePayResponse response=null;
        try {
            // 2. 发起API调用（扫描网页支付宝收款的二维码）
            response = Factory.Payment.Page().pay("Apple iPhone11 128G", orderNo, money, null);
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                System.out.println("调用成功");
            } else {
                System.err.println("调用失败");
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
        return response.body;//返回的是html中body标签内容
    }

    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";//使用阿里云支付宝沙箱环境地址 alipay--》aplipaydev
        config.signType = "RSA2";
        config.appId = "2021000119686638";
        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBz91AtN/3jcVHhX9jn+Q9gf01ajau4ZEQVvo8v14yCJjpNyi+KLpmFRkDLr0D5YHjzNYKvJw1FABIaZJ3cusS+TGApxQFRJW5O3+mTqL5Cgf4r78RKZm+kuhIxu2U48Mh0SSrWriJ8+fxlmXPYH4pLe6z1aQQjuBdjTfv80w2vFZB7NbEp4KuII5IS5eB2ZMFMwIS8YIYfkxyR9SBRLjBycQ0R9AsspQJjoXNoJvYinS3RODhGKH/AVDcNUEXxZhNhyRe5qWzDggN3WPm0fepD4eT8XOwZiaftup+mc0FcatYFvV85D/NsB8+6vpDTXTIJw6QY2r4C/b5c/FgRj41AgMBAAECggEALEJ8NJi3GEetMOKSeZxFjLcqZzDsrhnYhRKyxU2WR0bpI/MboCJw02d0HMKtzYtOCyaHACgotmw4YHgmaTW0csamGzBcQiONTRe9QS3koTbLWv5JDgf6FKEwM8gnrzEtEfWmJAqNivOvbI6T7e3/dfjkP0qjYsXkN+FzZgu1O5/k9sfJNcA8JEJcQ1EUAXmOHMW8t9bnax+NyDw7ihtNQxpU3IM+cgIPMjxG/S7uOF3qlrujITHKGQ7j6npekWfu+JlfTez8NOTslxt2Yz331zAT6p4m6qkxaNXkv7Y7GCWX3v6J6VFno2PlyKJW0pRASSQbmc9sHzHUv3nYwEfUzQKBgQC+gBoIxR4BbrX0xdY4P/Sxykcj0Ivfv/qslmqdZBPEn/Q1b4x9PdEJTr6j0/kcT3CUenmVY11Klgv662D58LVnS+GVUFAkVlu2/GD/TOR0uWBxsYQHREJJUjgAoOflka5LlYeXOuaac4sgJgqXh2dQi2NQbm+ZVKIP6siIi9QjfwKBgQCucfNACyM+W5sIWG5v5cx1dvTJj9wvZn3c4TD6UiVa8KHgfa0Sglt8Fa5heLizl2XBEVvy4w5I3Jo4ieMxrIFScUPy5hLdxfKhCSUTZknRMfksvnyqkNK9HtogBr6ZsPT+KkLrMDTVVcvZkgSs3wktfWkIEEwgwFHJcC6ktmwoSwKBgE7tYlv514m+ZfMJOM1LakVzSnBDSoCk2OZC199oBGy13Qd6tRl60C3sCz5zZ8XcAAf0ioVjitaJPmNyvFYx7ebjYI5tnRbBFPTGsiV0pT7bQ2M3qj0cgd5BC2TvRcUuy6kTRf9ZbwvVDXJ/cGoBtsN/TOGZL/G2SAMSQo2YaYdfAoGASL/GxQegDAph7ioK7Gl2SepxDXoMRkxE4w+awFnvsCw4JgnjWpu4kVftYELbLDJQQiL+KJ3eQC6Xtkpy0C1zxTDtOGgQqCI8HEJXDu8Si8Z+dtV94hgBetNZ/g8x/6BXm4N+Yty4u9tK5xJJFtrw1eK+IZnCVco+kXZSTWiyVF8CgYEAll+8AsfsOmzXB3tNxXMMQd8tUgEX6ctGbELblDsI37Mt5iTBSz5E6U5XvUSXOV3NBqnbgAPVgi46Q9jt7fJT42+OOhyWRTNwnrygREfuaOVaCmhjAyQ+08wwM7F7iVtwc5aki2BmGPPkbImGMSnPcguzcwLX7rzZAUEEsQN5/JU=";
        config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmkqxdeGm9VqFGs2wXM8Glx8YpVrZHQIU3j2OfkqZhKG1okVPwts1EtW8aGjGwjeMf8SWnOpRM8pGW7+dkT/oj0gNbDy3snBjsAloX0O08E5UnJttSJq8+s1hrfpNBndL3/eisO2hsGPAjseEvZLP9k1P6yMkgU0+vSC9rS2QMI3KDVmAN6gYOZOJBJYQTdon1ZgAOaCK/L4ZaFEv2U8Nh+B5IH+NEcCQPfz2VRohszqKGzav+MzverDuMRzC8W/hnpDCxFX1ILWjUGQyJN6qYmAa0tEOKd5AvjhScEmPPg4YV4/5y8WqHYQhGcOfYbXHm99ZILEMEFwltRKE0C6L3wIDAQAB";
        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = "";
        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
        config.encryptKey = "";
        return config;
    }
}
