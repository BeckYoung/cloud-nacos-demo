package com.example.userservice.controller;

import com.example.userservice.pojo.User;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/test")
    public ResponseResult testApi() {
        System.out.println("testApi...");
        return new ResponseResult(StatusCode.CODE_SUCCESS, null, "test api");
    }

    @PostMapping
    public ResponseResult save(User user) {
        System.out.println("UserController save:" + user.toString());
        int code = userService.save(user);
        if (code > 0) {
            return new ResponseResult(StatusCode.CODE_SUCCESS, null, "save success");
        } else {
            return new ResponseResult(StatusCode.CODE_FAIL, null, "save failure");
        }
    }

    @PutMapping
    public ResponseResult update(User user) {
        System.out.println("UserController update");
        int code = userService.update(user);
        if (code > 0) {
            return new ResponseResult(StatusCode.CODE_SUCCESS, null, "update success");
        } else {
            return new ResponseResult(StatusCode.CODE_FAIL, null, "update failure");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        System.out.println("UserController delete");
        int code = userService.delete(id);
        if (code > 0) {
            return new ResponseResult(StatusCode.CODE_SUCCESS, null, "delete success");
        } else {
            return new ResponseResult(StatusCode.CODE_FAIL, null, "delete failure");
        }
    }

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable Integer id) {
        System.out.println("UserController getById: id = " + id);
        if (id <= 0) {
            throw new IllegalArgumentException("args invalid");
        }
        User user = userService.getById(id);
        if (user != null) {
            return new ResponseResult(StatusCode.CODE_SUCCESS, user, "query success");
        } else {
            return new ResponseResult(StatusCode.CODE_FAIL, null, "query failure");
        }
    }

    @GetMapping
    public ResponseResult getAll() {
        List<User> userList = userService.getAll();
        System.out.println("UserController getAll:" + userList);
        if (userList != null) {
            return new ResponseResult(StatusCode.CODE_SUCCESS, userList, "query success");
        } else {
            return new ResponseResult(StatusCode.CODE_FAIL, null, "query failure");
        }
    }
}
