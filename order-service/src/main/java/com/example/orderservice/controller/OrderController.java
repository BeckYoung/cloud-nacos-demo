package com.example.orderservice.controller;

import com.example.feign.response.ResponseResult;
import com.example.feign.response.StatusCode;
import com.example.orderservice.pojo.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseResult queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        System.out.println("OrderController queryOrderByUserId orderId = " + orderId);
        // 根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);
        if (order == null) {
            return new ResponseResult(StatusCode.CODE_FAIL, null, "query failure");
        } else {
            return new ResponseResult(StatusCode.CODE_SUCCESS, order, "query success");
        }
    }
}
