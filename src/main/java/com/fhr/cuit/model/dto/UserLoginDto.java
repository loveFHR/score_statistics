package com.fhr.cuit.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author FHR
 * @create 2025/03/15 16:33
 */
@Data
@Schema(description = "用户登录参数")
public class UserLoginDto {

    /**
     * 登录账号（学号/工号）
     */
    @Schema(description = "账号")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 角色
     */
    @Schema(description = "角色")
    private String role;
}
