package io.github.mihkels.demo.model;

public record Counter(
        Long current,
        String message
) {
    public Counter(Long current) {
        this(current, "Counter value is: " + current);
    }
}
