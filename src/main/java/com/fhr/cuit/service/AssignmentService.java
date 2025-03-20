package com.fhr.cuit.service;

import com.fhr.cuit.model.dto.AssignmentDto;
import com.fhr.cuit.model.entity.Assignment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fhr.cuit.model.vo.PageVo;

import java.util.List;

/**
* @author FHR
* @create 2025/03/15 15:38
*/
public interface AssignmentService extends IService<Assignment> {

    PageVo<Assignment> getAssignmentList(AssignmentDto assignmentDto);

    void saveAssignment(Assignment assignment);

    void updateAssignmentById(Assignment assignment);

    void delete(List<Long> ids);

    Assignment getAssignment(Long id);
}
