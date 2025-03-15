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
 * 总评成绩表
 * @author FHR
 */
@TableName(value ="final_score")
@Data
@Schema(description = "最终成绩")
public class FinalScore implements Serializable {
    /**
     * 记录ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "最终成绩")
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
     * 总评成绩
     */
    @Schema(description = "总评成绩")
    private BigDecimal totalScore;

    /**
     * 计算时间
     */
    @Schema(description = "计算时间")
    private Date calculateTime;

    /**
     * 成绩状态(draft,confirmed,uploaded)
     */
    @Schema(description = "成绩状态")
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}