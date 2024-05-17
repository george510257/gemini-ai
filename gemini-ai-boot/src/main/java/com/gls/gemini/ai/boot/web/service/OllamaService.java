package com.gls.gemini.ai.boot.web.service;

import jakarta.annotation.Resource;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;

/**
 * Ollama服务
 */
@Service
public class OllamaService {

    @Resource
    private OllamaChatClient ollamaChatClient;

    public String generateText(String text) {
        return ollamaChatClient.call(text);
    }
}
