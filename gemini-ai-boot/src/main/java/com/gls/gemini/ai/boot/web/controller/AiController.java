package com.gls.gemini.ai.boot.web.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * AI控制器
 */
@RestController
@RequestMapping("/ai")
public class AiController {
    /**
     * 聊天客户端
     */
    @Resource
    private ChatClient chatClient;
    /**
     * 嵌入客户端
     */
    @Resource
    private EmbeddingClient embeddingClient;

    /**
     * 问候
     *
     * @return
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
        return chatClient.call(question);
    }

    /**
     * 回答
     *
     * @param question 问题
     * @return 答案
     */
    @GetMapping("/answer")
    public Map<String, Object> answer(String question) {
        return Map.of("answer", embeddingClient.embedForResponse(List.of(question)));
    }
}
