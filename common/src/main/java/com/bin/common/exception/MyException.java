package com.bin.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  //无参构造
@AllArgsConstructor //有参构造
public class MyException extends RuntimeException {

    private Integer code;   //状态码

    private String msg; //异常信息
}
