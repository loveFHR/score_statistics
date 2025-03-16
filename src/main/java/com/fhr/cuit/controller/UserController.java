package com.fhr.cuit.controller;

import com.fhr.cuit.exception.BusinessException;
import com.fhr.cuit.model.dto.UserLoginDto;
import com.fhr.cuit.model.dto.UserResetPassDto;
import com.fhr.cuit.model.entity.User;
import com.fhr.cuit.model.vo.Result;
import com.fhr.cuit.model.vo.UserVo;
import com.fhr.cuit.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author FHR
 * @create 2025/03/15 16:24
 */

@RestController
@RequestMapping("api/user")
@Tag(name = "用户管理")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @param user 登录参数
     * @return token
     */
    @Operation(summary = "用户登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody UserLoginDto user) {
        String token = userService.login(user);
        return Result.success(token);
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @Operation(summary = "获取用户信息")
    @GetMapping("userInfo")
    public Result<UserVo> getUserInfo() {
        return Result.success(userService.getUserInfo());
    }

    /**
     * 修改密码
     * @param resetPassDto 旧密码和新密码
     */
    @Operation(summary = "修改密码")
    @PostMapping("resetPass")
    public Result<Void> resetPass(@RequestBody UserResetPassDto resetPassDto){
        return  userService.resetPass(resetPassDto);
    }

    @PostMapping
    public Result<Void> register(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()){
            return Result.error("文件不能为空");
        }
        if (!file.getContentType().contains("spreadsheetml") && !file.getContentType().contains("xls") && !file.getContentType().contains("xlsx")) {
            throw new BusinessException("仅支持Excel文件");
        }

        try {
            userService.processExcel(file);
            return Result.success(200,"数据导入成功");
        } catch (IOException e) {
            throw new BusinessException("文件读取失败");
        } catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }
}
