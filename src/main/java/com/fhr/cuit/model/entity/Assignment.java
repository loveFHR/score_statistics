package com.fhr.cuit.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 作业考试表
 * @TableName assignment
 */
@TableName(value ="assignment")
@Data
public class Assignment implements Serializable {
    /**
     * 作业ID
     */
    @TableId(type = IdType.AUTO)
    private Long assignmentId;

    /**
     * 所属课程ID
     */
    private Long courseId;

    /**
     * 作业标题
     */
    private String title;

    /**
     * 作业描述
     */
    private String description;

    /**
     * 作业类型(homework,midterm,final)
     */
    private String type;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 截止时间
     */
    private Date deadline;

    /**
     * 满分分值
     */
    private BigDecimal maxScore;

    /**
     * 附件存储路径
     */
    private String attachment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}