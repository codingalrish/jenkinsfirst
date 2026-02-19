package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testMessage() {
        String message = "Hello, Jenkins + Maven!";
        assertEquals("Hello, Jenkins + Maven!", message);
    }
}
