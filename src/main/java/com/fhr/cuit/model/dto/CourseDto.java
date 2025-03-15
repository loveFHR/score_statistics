package com.fhr.cuit.model.dto;

import lombok.Data;

/**
 * @author FHR
 * @create 2025/03/15 18:06
 */
@Data
public class CourseDto {

    private Integer page;
    private Integer size;
    private String courseName;
    private String teacherName;
    private String semester;
}
