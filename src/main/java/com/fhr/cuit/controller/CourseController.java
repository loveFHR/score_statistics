package com.fhr.cuit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fhr.cuit.model.dto.CourseDto;
import com.fhr.cuit.model.entity.Course;
import com.fhr.cuit.model.vo.PageVo;
import com.fhr.cuit.model.vo.Result;
import com.fhr.cuit.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FHR
 * @create 2025/03/15 18:01
 */
@RestController
@RequestMapping("api/course")
@Tag(name = "课程管理")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 获取课程列表
     * @param courseDto 查询条件
     * @return 课程列表
     */
    @Operation(summary = "获取课程列表")
    @GetMapping("list")
    public Result<PageVo<Course>> list(CourseDto courseDto) {
        PageVo<Course> res = courseService.getList(courseDto);
        return Result.success(res);
    }

    /**
     * 新增或修改课程
     * @param course 课程
     * @return 是否成功
     */
    @Operation(summary = "新增或修改课程")
    @PostMapping("save")
    public Result<Void> save(@RequestBody Course course) {
        Long courseId = course.getCourseId();
        if (courseId == null) {
            courseService.save(course);
        } else {
            courseService.updateById(course);
        }
        return Result.success(200, "修改成功");
    }

    /**
     * 删除课程
     * @param ids 课程id列表
     * @return 是否成功
     */
    @Operation(summary = "删除课程")
    @DeleteMapping("delete/{ids}")
    public Result<Void> delete(@PathVariable("ids")List<Long> ids)  {
        boolean res = courseService.removeBatchByIds(ids);
        return res ? Result.success(200," 删除成功")
                : Result.error("删除失败");
    }

    /**
     * 根据id获取课程信息
     * @param id id
     * @return 课程
     */
    @Operation(summary = "根据id获取课程信息")
    @GetMapping("get/{id}")
    public Result<Course> get(@PathVariable("id") Long id) {
        Course course = courseService.getById(id);
        return Result.success(course);
    }
}
