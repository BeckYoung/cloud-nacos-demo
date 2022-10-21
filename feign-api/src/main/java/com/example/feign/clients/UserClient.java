package com.example.feign.clients;

import com.example.feign.pojo.User;
import com.example.feign.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/users/{id}")
    ResponseResult<User> getUserById(@PathVariable Long id);
}
