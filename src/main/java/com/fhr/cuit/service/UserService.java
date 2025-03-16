package com.fhr.cuit.service;

import com.fhr.cuit.model.dto.UserLoginDto;
import com.fhr.cuit.model.dto.UserResetPassDto;
import com.fhr.cuit.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fhr.cuit.model.vo.Result;
import com.fhr.cuit.model.vo.UserVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
public interface UserService extends IService<User> {
    String login(UserLoginDto user);

    UserVo getUserInfo();

    Result<Void> resetPass(UserResetPassDto resetPassDto);

    void processExcel(MultipartFile file) throws IOException;
}
