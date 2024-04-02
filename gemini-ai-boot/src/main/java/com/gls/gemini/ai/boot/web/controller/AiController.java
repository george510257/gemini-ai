package com.gls.gemini.ai.boot.web.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {
    @Resource
    private ChatClient chatClient;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Gemini AI!";
    }

    @GetMapping("/ask")
    public String ask(String question) {
        return chatClient.call(question);
    }
}
