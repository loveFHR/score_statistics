package com.fhr.cuit.model.dto;

import lombok.Data;

/**
 * @author FHR
 * @create 2025/03/15 17:44
 */
@Data
public class UserResetPassDto {

    private String oldPassword;
    private String newPassword;
}
