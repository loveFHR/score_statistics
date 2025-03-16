package com.fhr.cuit.service;

import com.fhr.cuit.model.entity.Course;
import com.fhr.cuit.model.entity.StudentCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fhr.cuit.model.vo.PageVo;

/**
 * @author FHR
 * @create 2025/03/15 15:38
 */
public interface StudentCourseService extends IService<StudentCourse> {

    /**
     * 选课
     *
     * @param studentCourse
     */
    void choose(StudentCourse studentCourse);

    /**
     * 查看已选课程
     *
     * @return
     */
    PageVo<Course> getList();

    /**
     * 退课
     */
    void drop(Long courseId);

}
