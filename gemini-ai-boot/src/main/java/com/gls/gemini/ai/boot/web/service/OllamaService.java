package com.gls.gemini.ai.boot.web.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Ollama服务
 */
@Service
public class OllamaService {

    @Resource
    private ChatModel chatModel;
    @Resource
    private EmbeddingModel embeddingModel;

    public String ask(String question) {
        return chatModel.call(question);
    }

    public Map<String, Object> answer(String question) {
        EmbeddingResponse response = embeddingModel.embedForResponse(CollUtil.newArrayList(question));
        return MapUtil.of("embedding", response);
    }
}
