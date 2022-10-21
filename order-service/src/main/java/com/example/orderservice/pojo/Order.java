package com.example.orderservice.pojo;

import com.example.feign.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private String name;
    private Double price;
    private Integer num;
    private Long userId;
    private User user;
}
