package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void applicationClassShouldExist() {
        assertTrue(App.class.isAnnotationPresent(
                org.springframework.boot.autoconfigure.SpringBootApplication.class
        ));
    }
}