package com.vanmor.lab6spring;

public class Function {
    public double f(double x, double y, int functionNumber) {
        switch (functionNumber) {
            case (1) -> {
                return y + (1 + x) * (y * y);
            }
            case (2) -> {
                return x + Math.cos(y / Math.sqrt(5));
            }
            default -> {
                return 6 * Math.pow(x, 2) + 5 * x * y;
            }
        }
    }

}
