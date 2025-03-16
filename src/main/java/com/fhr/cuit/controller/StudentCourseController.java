package com.fhr.cuit.controller;

import com.fhr.cuit.model.entity.Course;
import com.fhr.cuit.model.entity.StudentCourse;
import com.fhr.cuit.model.vo.PageVo;
import com.fhr.cuit.model.vo.Result;
import com.fhr.cuit.service.StudentCourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

/**
 * @author FHR
 * @create 2025/03/15 20:55
 */

@RestController
@RequestMapping("api/student/course")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    /**
     * 选课
     *
     * @param studentCourse
     * @return
     */
    @PostMapping("choose")
    @Operation(summary = "选课")
    public Result<Void> choose(@RequestBody StudentCourse studentCourse) {
        studentCourseService.choose(studentCourse);
        return Result.success();
    }

    /**
     * 查看已选课程
     *
     * @return
     */
    @GetMapping("list")
    @Operation(summary = "查看已选课程")
    public Result<PageVo<Course>> list() {
        PageVo<Course> res = studentCourseService.getList();
        return Result.success(res);
    }

    @Operation(summary = "退课")
    @PostMapping("drop")
    public Result<Void> drop(@RequestBody Long courseId){
        studentCourseService.drop(courseId);
        return Result.success(200,"退课成功");
    }
}
