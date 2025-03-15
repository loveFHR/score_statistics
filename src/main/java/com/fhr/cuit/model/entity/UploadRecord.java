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
 * 上传记录表
 *
 * @author FHR
 */
@TableName(value = "upload_record")
@Data
@Schema(description = "上传记录")
public class UploadRecord implements Serializable {
    /**
     * 文件上传主键
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "文件上传id")
    private Long id;

    /**
     * 文件路径
     */
    @Schema(description = "路径")
    private String filePath;

    /**
     * 上传时间
     */
    @Schema(description = "上传时间")
    private Date uploadTime;

    /**
     * 上传人id
     */
    @Schema(description = "上传人id")
    private Long userId;

    /**
     * 上传状态
     */
    @Schema(description = "上传状态")
    private String uploadStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}