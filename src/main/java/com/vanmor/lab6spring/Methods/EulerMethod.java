package com.vanmor.lab6spring.Methods;

import com.vanmor.lab6spring.Function;

public class EulerMethod {

    public double[][] method(double a, double b, double y0, double h, int functionNumber) {
        Function function = new Function();
        int n = (int) (Math.abs(b - a) / h) + 1;
        double[][] result = new double[n][3];

        result[0][0] = a;
        result[0][1] = y0;
        result[0][2] = function.f(result[0][0], result[0][1], functionNumber);

        for (int i = 1; i < n; i++) {
            result[i][0] = result[i - 1][0] + h;
            result[i][1] = result[i - 1][1] + h * function.f(result[i - 1][0], result[i - 1][1], functionNumber);
            result[i][2] = function.f(result[i][0], result[i][1], functionNumber);
            System.out.println(result[i][2]);
        }

        return result;
    }
}
