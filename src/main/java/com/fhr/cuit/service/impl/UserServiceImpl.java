package com.fhr.cuit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhr.cuit.common.BaseContext;
import com.fhr.cuit.common.JwtUtil;
import com.fhr.cuit.exception.BusinessException;
import com.fhr.cuit.model.dto.UserLoginDto;
import com.fhr.cuit.model.entity.User;
import com.fhr.cuit.model.vo.UserVo;
import com.fhr.cuit.service.UserService;
import com.fhr.cuit.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    private final UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String login(UserLoginDto userLoginDto) {
        String loginPassword = DigestUtils.md5DigestAsHex(userLoginDto.getPassword().getBytes());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, userLoginDto.getUsername());
        wrapper.eq(User::getRole,userLoginDto.getRole());
        User loginUser = userMapper.selectOne(wrapper);
        if (loginUser == null) {
            throw new BusinessException("该用户不存在");
        }
        if (!loginUser.getPassword().equals(loginPassword)) {
            throw new BusinessException("用户名或账号错误");
        }
        //登录成功，生成token
        //生成JWT
        Map<String,Object> map = new HashMap<>();
        map.put("userId",loginUser.getUserId());
        return JwtUtil.createJWT("FHR^*^*^*^*^*^*^*^*^*&^%$%^%%^%$^#%#", 7200000, map);
    }

    @Override
    public UserVo getUserInfo() {
        Long userId = BaseContext.getUserId();
        User user = userMapper.selectById(userId);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }
}




