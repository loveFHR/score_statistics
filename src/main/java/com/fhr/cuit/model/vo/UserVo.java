package com.fhr.cuit.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author FHR
 * @create 2025/03/15 16:55
 */
@Data
public class UserVo {

    @Schema(description = "用户id")
    private Long userId;

    /**
     * 登录账号（学号/工号）
     */
    @Schema(description = "账号")
    private String username;

    /**
     * 真实姓名
     */
    @Schema(description = "姓名")
    private String realName;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private Integer gender;

    /**
     * 用户角色(student,teacher,admin)
     */
    @Schema(description = "角色")
    private String role;

    /**
     * 所属院系
     */
    @Schema(description = "院系")
    private String department;

    /**
     * 电子邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}
