package com.example.userservice.controller;

public @interface StatusCode {
    int CODE_SUCCESS = 200;

    int CODE_FAIL = -1001;
    int CODE_UNKNOWN_ERR = -1002;
}
