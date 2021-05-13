package com.geekbrains.lesson4;

public class Triangle {

    public boolean isSquare(int a, int b, int c) {  //площадь треугольника по формуле Герона
        int p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        if ((a <= 0) | (b <= 0) | (c <= 0)) {
            return false;
        }
        if (p < 0) {
            return false;
        } else if (p > 0) {
            return true;
        }
        return s > 0;
    }
}