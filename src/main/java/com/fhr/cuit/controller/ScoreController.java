package com.fhr.cuit.controller;

import com.fhr.cuit.service.ScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FHR
 * @create 2025/03/19 20:57
 */
@RestController
@RequestMapping("score")
public class ScoreController {

    private final ScoreService scoreService;
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

}
