package com.gls.gemini.ai.boot.web.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AiController {
    @Resource
    private ChatClient chatClient;
    @Resource
    private EmbeddingClient embeddingClient;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Gemini AI!";
    }

    @GetMapping("/ask")
    public String ask(String question) {
        return chatClient.call(question);
    }

    @GetMapping("/answer")
    public Map<String, Object> answer(String question) {
        return Map.of("answer", embeddingClient.embedForResponse(List.of(question)));
    }
}
