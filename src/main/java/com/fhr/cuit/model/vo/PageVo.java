package com.fhr.cuit.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author FHR
 * @create 2025/03/15 18:09
 */
@Data
public class PageVo<T> {
    private long total;
    private List<T>  data;
}
