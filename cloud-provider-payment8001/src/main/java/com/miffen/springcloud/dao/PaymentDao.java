package com.miffen.springcloud.dao;

import com.miffen.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: kiss
 * @Date: 2022-04-15 9:07
 * @Desc:
 */
@Mapper
public interface PaymentDao {

    /**
     * 创建一个 payment
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据 id 查询 payment
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
