package com.fhr.cuit.controller;

import com.fhr.cuit.mapper.UploadRecordMapper;
import com.fhr.cuit.model.entity.UploadRecord;
import com.fhr.cuit.model.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author FHR
 * @create 2025/03/19 20:53
 */
@RestController
@RequestMapping("file")
public class FileUploadController {
    private final UploadRecordMapper uploadRecordMapper;
    public FileUploadController(UploadRecordMapper uploadRecordMapper) {
        this.uploadRecordMapper = uploadRecordMapper;
    }

    @PostMapping("upload")
    public Result<Void> upload(MultipartFile file) {}
}
