package com.miffen.springcloud.controller;

import com.miffen.springcloud.model.CommonResult;
import com.miffen.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: kiss
 * @Date: 2022-04-15 9:39
 * @Desc:
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {
    public static final String PaymentSrv_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
     *
     * @param payment
     * @return
     */
    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/payment/get/" + id,CommonResult.class,id);
    }
}