package com.fhr.cuit.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 学生选课表
 *
 * @author FHR
 */
@TableName(value = "student_course")
@Data
@Schema(description = "学生选课")
public class StudentCourse implements Serializable {
    /**
     * 记录ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "学生选课id")
    private Long id;

    /**
     * 学生ID
     */
    @Schema(description = "学生id")
    private Long studentId;

    /**
     * 课程ID
     */
    @Schema(description = "课程id")
    private Long courseId;

    /**
     * 选课时间
     */
    @JsonFormat(pattern = "yyyy-m-dd",timezone = "GMT+8")
    @Schema(description = "选课时间")
    private Date selectTime;

    /**
     * 选课状态(normal,dropped)
     */
    @Schema(description = "选课状态")
    private String status;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}