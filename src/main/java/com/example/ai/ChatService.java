package com.example.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling interaction with the AI model using Spring AI's ChatClient.
 */
@Service
public class ChatService {
    private final ChatClient chatClient;

    @Autowired
    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getAIResponse(String userMessage) {
        if (userMessage == null || userMessage.isEmpty()) {
            return "[No message provided]";
        }
        // Use Spring AI ChatClient to get AI response
        return chatClient.prompt(userMessage).call().content();
    }
}
