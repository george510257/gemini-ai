package com.gls.gemini.ai.boot.web.controller;

import com.gls.gemini.ai.boot.web.service.OllamaService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * AI控制器
 */
@RestController
@RequestMapping("/ai")
public class AiController {
    @Resource
    private OllamaService ollamaService;

    /**
     * 问候
     *
     * @return 问候语
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Gemini AI!";
    }

    /**
     * 问答
     *
     * @param question 问题
     * @return 答案
     */
    @GetMapping("/ask")
    public String ask(String question) {
        return ollamaService.ask(question);
    }

    /**
     * 回答
     *
     * @param question 问题
     * @return 答案
     */
    @GetMapping("/answer")
    public Map<String, Object> answer(String question) {
        return ollamaService.answer(question);
    }
}
