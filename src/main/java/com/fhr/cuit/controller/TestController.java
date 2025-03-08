package com.fhr.cuit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FHR
 * @create 2025/03/08 11:20
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String test(){
        return "hello spring boot!";
    }
}
