package io.github.mihkels.demo.model;

public record CounterRequest(String message) {
    public CounterRequest {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
    }
}
