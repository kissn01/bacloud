package com.miffen.springcloud.impl;

import com.miffen.springcloud.dao.PaymentDao;
import com.miffen.springcloud.service.PaymentService;
import com.miffen.springcloud.model.CommonResult;
import com.miffen.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: kiss
 * @Date: 2022-04-15 9:07
 * @Desc:
 */
@Slf4j
@Service
public class  PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentDao paymentDao;

    @Override
    public CommonResult create(Payment payment) {
        int result = paymentDao.create(payment);
        log.info("*****插入操作返回结果:{}",result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        Payment payment = paymentDao.getPaymentById(id);
        log.info("*****查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }
}
