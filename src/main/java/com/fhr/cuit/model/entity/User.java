package com.fhr.cuit.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统用户表
 *
 * @author FHR
 */
@TableName(value = "user")
@Data
@Schema(description = "用户")
public class User implements Serializable {
    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 登录账号（学号/工号）
     */
    @Schema(description = "账号")
    private String username;

    /**
     * 加密后的密码
     */
    @Schema(description = "密码")
    private String password;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}