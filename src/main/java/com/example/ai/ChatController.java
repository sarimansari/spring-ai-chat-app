package com.example.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller exposing a /chat endpoint for AI chat.
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * POST /chat - Accepts user message, returns AI-generated reply
     * @param request chat message from user
     * @return AI reply
     */
    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String aiReply = chatService.getAIResponse(request.getMessage());
        return new ChatResponse(aiReply);
    }

    // Simple request DTO for user message
    public static class ChatRequest {
        public String message;
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    // Simple response DTO for AI reply
    public static class ChatResponse {
        public String response;
        public ChatResponse(String response) { this.response = response; }
        public String getResponse() { return response; }
    }
}
