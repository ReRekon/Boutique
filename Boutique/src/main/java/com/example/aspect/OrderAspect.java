package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderAspect {

    @After("execution(public * com.example.controller.OrderController.createOrder())")
    public String payOrder()
    {
      return " ";
    }

}
