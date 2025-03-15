package com.fhr.cuit.controller;

import com.fhr.cuit.model.dto.UserLoginDto;
import com.fhr.cuit.model.entity.User;
import com.fhr.cuit.model.vo.Result;
import com.fhr.cuit.model.vo.UserVo;
import com.fhr.cuit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author FHR
 * @create 2025/03/15 16:24
 */

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public Result<String> login(@RequestBody UserLoginDto user) {
        String token =  userService.login(user);
        return Result.success(token);
    }

    @GetMapping("userInfo")
    public Result<UserVo> getUserInfo() {
        return Result.success(userService.getUserInfo());
    }
}
