package com.fhr.cuit.service;

import com.fhr.cuit.model.dto.UserLoginDto;
import com.fhr.cuit.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fhr.cuit.model.vo.UserVo;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
public interface UserService extends IService<User> {
    String login(UserLoginDto user);

    UserVo getUserInfo();
}
