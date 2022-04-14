package com.miffen.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: kiss
 * @Date: 2022-04-14 18:34
 * @Desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T>{
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
