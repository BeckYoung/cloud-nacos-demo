package com.example.orderservice.service;

import com.example.feign.clients.UserClient;
import com.example.feign.pojo.User;
import com.example.feign.response.ResponseResult;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.pojo.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        ResponseResult<User> result = userClient.getUserById(order.getUserId());
        Optional.ofNullable(result).map(res -> res.getData()).ifPresent(user -> order.setUser(user));
        // 4.返回
        return order;
    }
}
