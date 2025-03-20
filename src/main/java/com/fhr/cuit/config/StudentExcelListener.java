package com.fhr.cuit.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fhr.cuit.exception.BusinessException;
import com.fhr.cuit.model.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author FHR
 * @create 2025/03/16 21:54
 */
@Getter
public class StudentExcelListener extends AnalysisEventListener<User> {
    private static final List<String> EXPECTED_HEADERS = List.of(
            "学号","姓名","性别","所在院系","电子邮箱"
    );

    private final List<User> students = new ArrayList<>();

    @Override
    public void invokeHeadMap(Map headMap, AnalysisContext context) {
//        List<String> headers = headMap.values()
//                .stream()
//                .map(String::trim)
//                .collect(Collectors.toList());
//        if (!headers.containsAll(EXPECTED_HEADERS)) {
//            throw new BusinessException("Excel表头必须包含：学号，姓名，性别，院系，邮箱");
//        }
    }

    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        validateStudent(user,analysisContext.readRowHolder().getRowIndex());
        students.add(user);
    }

    private void validateStudent(User user,int rowIndex) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new BusinessException("学号不能为空");
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
