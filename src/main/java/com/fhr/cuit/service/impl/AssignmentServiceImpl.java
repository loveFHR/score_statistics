package com.fhr.cuit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fhr.cuit.common.BaseContext;
import com.fhr.cuit.model.dto.AssignmentDto;
import com.fhr.cuit.model.entity.Assignment;
import com.fhr.cuit.model.vo.PageVo;
import com.fhr.cuit.service.AssignmentService;
import com.fhr.cuit.mapper.AssignmentMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FHR
 * @create 2025/03/15 15:38
 */
@Service
public class AssignmentServiceImpl extends ServiceImpl<AssignmentMapper, Assignment>
        implements AssignmentService {
    private final AssignmentMapper assignmentMapper;

    public AssignmentServiceImpl(AssignmentMapper assignmentMapper) {
        this.assignmentMapper = assignmentMapper;
    }

    @Override
    public PageVo<Assignment> getAssignmentList(AssignmentDto assignmentDto) {
        Page<Assignment> page = new Page<>(assignmentDto.getPage(), assignmentDto.getSize());
        LambdaQueryWrapper<Assignment> wrapper = new LambdaQueryWrapper<>();
        String title = assignmentDto.getTitle();
        String description = assignmentDto.getDescription();
        if (title != null && StringUtils.isNoneBlank(title)) {
            wrapper.like(Assignment::getTitle, title);
        }
        if (description != null && StringUtils.isNoneBlank(description)) {
            wrapper.like(Assignment::getDescription, description);
        }
        Page<Assignment> res = assignmentMapper.selectPage(page, wrapper);
        PageVo<Assignment> pageVo = new PageVo<>();
        pageVo.setTotal(res.getTotal());
        pageVo.setData(res.getRecords());
        return pageVo;
    }

    @Override
    public void saveAssignment(Assignment assignment) {
        assignmentMapper.insert(assignment);
    }

    @Override
    public void updateAssignmentById(Assignment assignment) {
        assignmentMapper.updateById(assignment);
    }

    @Override
    public void delete(List<Long> ids) {
        assignmentMapper.deleteByIds(ids);
    }

    @Override
    public Assignment getAssignment(Long id) {
        return assignmentMapper.selectById(id);
    }
}




