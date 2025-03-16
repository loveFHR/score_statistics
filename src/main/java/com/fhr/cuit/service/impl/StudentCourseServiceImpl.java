package com.fhr.cuit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhr.cuit.common.BaseContext;
import com.fhr.cuit.common.SnowflakeUtil;
import com.fhr.cuit.mapper.CourseMapper;
import com.fhr.cuit.model.entity.Course;
import com.fhr.cuit.model.entity.StudentCourse;
import com.fhr.cuit.model.vo.PageVo;
import com.fhr.cuit.service.StudentCourseService;
import com.fhr.cuit.mapper.StudentCourseMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper, StudentCourse>
    implements StudentCourseService{

    private final StudentCourseMapper studentCourseMapper;
    private final CourseMapper courseMapper;

    public StudentCourseServiceImpl(StudentCourseMapper studentCourseMapper,
                                    CourseMapper courseMapper) {
        this.studentCourseMapper = studentCourseMapper;
        this.courseMapper = courseMapper;
    }

    @Override
    public void choose(StudentCourse studentCourse) {
        Long studentId = BaseContext.getUserId();
        //id
        studentCourse.setId(SnowflakeUtil.createId());
        //用户id
        studentCourse.setStudentId(studentId);
        //选课时间
        studentCourse.setSelectTime(new Date());
        //选课状态（正常）
        studentCourse.setStatus("normal");
        studentCourseMapper.insert(studentCourse);
    }

    @Override
    public PageVo<Course> getList() {
        Long studentId = BaseContext.getUserId();
        LambdaQueryWrapper<StudentCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentCourse::getStudentId, studentId);
        wrapper.eq(StudentCourse::getStatus, "normal");
        List<StudentCourse> list = studentCourseMapper.selectList(wrapper);
        PageVo<Course> pageVo = new PageVo<>();
        pageVo.setTotal(list.size());
        ArrayList<Course> courseList = new ArrayList<>();
        for (StudentCourse sc : list) {
            Course course = courseMapper.selectById(sc.getCourseId());
            courseList.add(course);
        }
        pageVo.setData(courseList);
        return pageVo;
    }

    @Override
    public void drop(Long courseId) {
        Long studentId = BaseContext.getUserId();
        courseMapper.drop(courseId,studentId);
    }
}




