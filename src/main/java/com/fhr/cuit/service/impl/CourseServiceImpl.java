package com.fhr.cuit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhr.cuit.common.SnowflakeUtil;
import com.fhr.cuit.model.dto.CourseDto;
import com.fhr.cuit.model.entity.Course;
import com.fhr.cuit.model.vo.PageVo;
import com.fhr.cuit.service.CourseService;
import com.fhr.cuit.mapper.CourseMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
* @author FHR
* @create 2025/03/15 15:38
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

    private final CourseMapper courseMapper;
    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public PageVo<Course> getList(CourseDto courseDto) {
        Page<Course> page = new Page<>(courseDto.getPage(), courseDto.getSize());
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNoneBlank(courseDto.getCourseName())) {
            wrapper.like(Course::getCourseName, courseDto.getCourseName());
        }
        if (StringUtils.isNoneBlank(courseDto.getTeacherName())) {
            wrapper.like(Course::getTeacherName, courseDto.getTeacherName());
        }
        if (StringUtils.isNoneBlank(courseDto.getSemester())) {
            wrapper.eq(Course::getSemester, courseDto.getSemester());
        }
        Page<Course> selectPage = courseMapper.selectPage(page, wrapper);
        PageVo<Course> pageVo = new PageVo<>();
        pageVo.setTotal(selectPage.getTotal());
        pageVo.setData(selectPage.getRecords());
        return pageVo;
    }

    @Override
    public void saveCourse(Course course) {
        course.setCourseId(SnowflakeUtil.createId());
        courseMapper.insert(course);
    }
}




