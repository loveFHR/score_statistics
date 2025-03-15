package com.fhr.cuit.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 成绩比例配置表
 *
 * @author FHR
 */
@TableName(value = "score_config")
@Data
@Schema(description = "成绩比例配置")
public class ScoreConfig implements Serializable {
    /**
     * 配置ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "配置id")
    private Long configId;

    /**
     * 课程ID
     */
    @Schema(description = "课程id")
    private Long courseId;

    /**
     * 作业类型(homework,midterm,final)
     */
    @Schema(description = "作业类型")
    private String scoreType;

    /**
     * 所占比例（0.00-1.00）
     */
    @Schema(description = "比例")
    private BigDecimal proportion;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}