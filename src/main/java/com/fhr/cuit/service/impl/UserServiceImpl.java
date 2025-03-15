package com.fhr.cuit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhr.cuit.common.BaseContext;
import com.fhr.cuit.common.JwtUtil;
import com.fhr.cuit.exception.BusinessException;
import com.fhr.cuit.model.dto.UserLoginDto;
import com.fhr.cuit.model.dto.UserResetPassDto;
import com.fhr.cuit.model.entity.User;
import com.fhr.cuit.model.vo.Result;
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

    @Override
    public Result<Void> resetPass(UserResetPassDto resetPassDto) {
        String oldPassword = resetPassDto.getOldPassword();
        String newPassword = resetPassDto.getNewPassword();
        oldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        Long userId = BaseContext.getUserId();
        User user = userMapper.selectById(userId);
        if (!user.getPassword().equals(oldPassword)) {
            throw new BusinessException("密码错误，请重试");
        }
        newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());

        int res = userMapper.updatePass(user.getUserId(),newPassword);

        if (res < 1) {
            throw new BusinessException("修改失败");
        }
        return Result.success(200,"修改成功");
    }
}




