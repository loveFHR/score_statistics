package com.fhr.cuit.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 课程信息表
 * @author FHR
 */
@TableName(value ="course")
@Data
@Schema(description = "课程")
public class Course implements Serializable {
    /**
     * 课程ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "课程id")
    private Long courseId;

    /**
     * 课程代码
     */
    @Schema(description = "课程代码")
    private String courseCode;

    /**
     * 课程名称
     */
    @Schema(description = "课程名称")
    private String courseName;

    /**
     * 授课教师ID
     */
    @Schema(description = "老师id")
    private Long teacherId;

    /**
     * 学期（格式：YYYY-YYYY-学期，如2024-2025-1）
     */
    @Schema(description = "学期")
    private String semester;

    /**
     * 学分
     */
    @Schema(description = "学分")
    private BigDecimal credit;

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