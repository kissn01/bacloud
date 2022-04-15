package com.miffen.springcloud.service;


import com.miffen.springcloud.model.CommonResult;
import com.miffen.springcloud.model.Payment;

/**
 * @Author: kiss
 * @Date: 2022-04-15 9:06
 * @Desc:
 */
public interface PaymentService {
    /**
     * 创建一个 payment
     * @param payment
     * @return
     */
    CommonResult create(Payment payment);

    /**
     * 根据 id 查询 payment
     * @param id
     * @return
     */
    CommonResult getPaymentById(Long id);

}
