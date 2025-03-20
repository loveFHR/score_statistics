package com.fhr.cuit.controller;

import com.fhr.cuit.model.dto.AssignmentDto;
import com.fhr.cuit.model.entity.Assignment;
import com.fhr.cuit.model.vo.PageVo;
import com.fhr.cuit.model.vo.Result;
import com.fhr.cuit.service.AssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FHR
 * @create 2025/03/19 20:19
 */
@RestController
@RequestMapping("assignment")
@Tag(name = "作业管理")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("list")
    @Operation(summary = "获取作业列表")
    public Result<PageVo<Assignment>> getAssignmentList(AssignmentDto assignmentDto) {
        PageVo<Assignment> res = assignmentService.getAssignmentList(assignmentDto);
        return Result.success(res);
    }

    @PostMapping("save")
    @Operation(summary = "布置/修改作业")
    public Result<Void> saveAssignment(@RequestBody Assignment assignment) {
        if (assignment.getAssignmentId() == null) {
            assignmentService.saveAssignment(assignment);
        }else {
            assignmentService.updateAssignmentById(assignment);
        }
        return Result.success();
    }

    @Operation(summary = "作业删除")
    @DeleteMapping("delete/{ids}")
    public Result<Void> deleteAssignment(@PathVariable("ids") List<Long> ids) {
        assignmentService.delete(ids);
        return Result.success();
    }
    @Operation(summary = "根据id获取作业")
    @GetMapping("get")
    public Result<Assignment> getAssignmentById(Long id) {
        Assignment res = assignmentService.getAssignment(id);
        return Result.success(res);
    }
}
