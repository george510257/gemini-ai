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
    /**
     * 聊天模型
     */
    @Resource
    private ChatModel chatModel;
    /**
     * 嵌入模型
     */
    @Resource
    private EmbeddingModel embeddingModel;

    /**
     * 问候
     *
     * @param question 问题
     * @return 答案
     */
    public String ask(String question) {
        return chatModel.call(question);
    }

    /**
     * 回答
     *
     * @param question 问题
     * @return 答案
     */
    public Map<String, Object> answer(String question) {
        EmbeddingResponse response = embeddingModel.embedForResponse(CollUtil.newArrayList(question));
        return MapUtil.of("embedding", response);
    }
}
