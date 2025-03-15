package com.fhr.cuit.service;

import com.fhr.cuit.model.dto.CourseDto;
import com.fhr.cuit.model.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fhr.cuit.model.vo.PageVo;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
public interface CourseService extends IService<Course> {

    PageVo<Course> getList(CourseDto courseDto);
}
