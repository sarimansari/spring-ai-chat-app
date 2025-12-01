# Spring AI Chat App

A simple Spring Boot application that exposes a REST API for AI-powered chat using OpenAI via Spring AI.

## Features
- REST endpoint `/chat` for sending user messages and receiving AI-generated responses
- Uses Spring AI's OpenAI integration
- Easily configurable via `application.properties`

## API Usage
- **POST /chat**
  - Request body:
    ```json
    {
      "message": "Hello, AI!"
    }
    ```
  - Response body:
    ```json
    {
      "response": "AI-generated reply here."
    }
    ```