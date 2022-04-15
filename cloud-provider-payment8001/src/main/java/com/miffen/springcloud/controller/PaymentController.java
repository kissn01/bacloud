package com.miffen.springcloud.controller;


import com.miffen.springcloud.service.PaymentService;
import com.miffen.springcloud.model.CommonResult;
import com.miffen.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: kiss
 * @Date: 2022-04-15 9:04
 * @Desc:
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t"
                    + instance.getUri());
        }

        return this.discoveryClient;
    }

}
