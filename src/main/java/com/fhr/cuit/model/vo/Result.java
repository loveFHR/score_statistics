package com.fhr.cuit.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

/**
 * @author FHR
 * @create 2025/03/08 11:49
 */
@Data
@Schema(name = "同一返回类")
public class Result<T> {
    /**
     * 代码
     */
    @Schema(name = "代码")
    private Integer code;
    /**
     * 信息
     */
    @Schema(name = "信息")
    private String msg;
    /**
     * 数据
     */
    @Schema(name = "数据")
    private T data;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 500;
        return result;
    }
    public static <T> Result<T> error(Integer code,String msg){
        Result result = new Result();
        result.msg = msg;
        result.code = code;
        return result;
    }
}
