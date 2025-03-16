package com.fhr.cuit.mapper;

import com.fhr.cuit.model.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
public interface CourseMapper extends BaseMapper<Course> {

    @Update("UPDATE student_corse SET status = 'dropped' " +
            "WHERE student_id = #{studentId} " +
            "AND course_id = #{courseId}")
    void drop(@Param("courseId") Long courseId,
              @Param("studentId") Long studentId);
}




