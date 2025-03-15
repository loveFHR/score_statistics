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
 * 成绩记录表
 *
 * @author FHR
 */
@TableName(value = "score")
@Data
@Schema(description = "成绩")
public class Score implements Serializable {
    /**
     * 成绩ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "成绩id")
    private Long scoreId;

    /**
     * 学生ID
     */
    @Schema(description = "学生id")
    private Long studentId;

    /**
     * 作业ID
     */
    @Schema(description = "作业id")
    private Long assignmentId;

    /**
     * 实际得分
     */
    @Schema(description = "实际得分")
    private BigDecimal score;

    /**
     * 记录时间
     */
    @Schema(description = "记录时间")
    private Date recordTime;

    /**
     * 录入教师ID
     */
    @Schema(description = "录入老师id")
    private Long uploaderId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}