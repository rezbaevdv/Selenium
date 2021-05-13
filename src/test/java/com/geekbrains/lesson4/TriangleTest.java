package com.geekbrains.lesson4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    Triangle triangle = new Triangle();
    @Test
    void testGivenSideWhenGreaterThanZeroThenTrue() {
        boolean result = triangle.isSquare(1,1,1);
        Assertions.assertTrue(result);
    }
}

