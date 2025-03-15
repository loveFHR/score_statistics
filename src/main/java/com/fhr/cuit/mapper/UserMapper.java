package com.fhr.cuit.mapper;

import com.fhr.cuit.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
public interface UserMapper extends BaseMapper<User> {

    @Update("UPDATE user SET password = #{newPassword} WHERE user_id = #{userId}")
    int updatePass(@Param("userId") Long userId,
                   @Param("newPassword") String newPassword);
}




