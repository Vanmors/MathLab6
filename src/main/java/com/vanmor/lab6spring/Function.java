package com.vanmor.lab6spring;

import javax.swing.plaf.metal.MetalTheme;

public class Function {
    public double f(double x, double y, int functionNumber) {
        switch (functionNumber) {
            case (1) -> {
                return y + (1 + x) * (y * y);
            }
            case (2) -> {
//                return x + Math.cos(y / Math.sqrt(5));
                return Math.pow(y, 2) + 1 / (x * y);
            }
            default -> {
                return 6 * Math.pow(x, 2) + 5 * x * y;
            }
        }
    }


    public double f1(double x, double y, int functionNumber) {
        switch (functionNumber) {
            case (1) -> {
//                return y * y * (Math.pow(x, 2) / 2 + x) + y * x;
//                return 1 / x;
                return -1 * (1 / x);

            }
            case (2) -> {
//                return Math.pow(x, 2) / 2 + Math.cos(y / Math.sqrt(5)) * x;
//                return Math.sqrt(5) * Math.acos(Math.pow(x, 2) / 2);
                return Math.pow(Math.log(x), 2) + 0  * Math.log(x) - 1;
            }
            default -> {
//                return 2 * Math.pow(x, 3) + (5 * y * Math.pow(x, 2) / 2);
                System.out.println((-4 * Math.pow(x, 3)) / (5 * Math.pow(x, 2)));
                return (-4 * Math.pow(x, 3)) / (5 * Math.pow(x, 2));
            }
        }
    }

}
