package com.fhr.cuit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhr.cuit.model.entity.User;
import com.fhr.cuit.service.UserService;
import com.fhr.cuit.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




