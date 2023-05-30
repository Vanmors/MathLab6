package com.vanmor.lab6spring.Methods;

import com.vanmor.lab6spring.Function;

public class EulerMethod {

    public double[][] method(double a, double b, double y0, double h, int functionNumber, double e) {
        Function function = new Function();
        int p = 1;
        double[][] result = null;
        double[][] result2 = null;

        int counter = 2;
        int count = 0;
        int n2 = 0;
        while (!function.compareColumn(result, result2, e, p)) {


            count++;
            if (count == 2) {
                System.out.println();
            }
            double hNew = h / counter;
            int n;

            if (count == 1) {
                n = (int) (Math.abs(b - a) / h) + 1;
            }
            else {
                n = n2;
            }
            n2 = (int) (Math.abs(b - a) / hNew) + 1;

            if (result != null) {
                result = result2;
            } else {
                result = new double[n][4];
            }
            result2 = new double[n2][4];

            if (count == 1) {
                result[0][0] = a;
                result[0][1] = y0;
                result[0][2] = function.f(result[0][0], result[0][1], functionNumber);
                result[0][3] = function.f1(result[0][0], result[0][1], functionNumber);

                for (int i = 1; i < n; i++) {
                    result[i][0] = result[i - 1][0] + h;
                    result[i][1] = result[i - 1][1] + h * function.f(result[i - 1][0], result[i - 1][1], functionNumber);
                    result[i][2] = function.f(result[i][0], result[i][1], functionNumber);
                    result[i][3] = function.f1(result[i][0], result[i][1], functionNumber);
                }
            }

            result2[0][0] = a;
            result2[0][1] = y0;
            result2[0][2] = function.f(result2[0][0], result2[0][1], functionNumber);
            result2[0][3] = function.f1(result2[0][0], result2[0][1], functionNumber);

            for (int i = 1; i < n2; i++) {
                result2[i][0] = result2[i - 1][0] + hNew;
                result2[i][1] = result2[i - 1][1] + hNew * function.f(result2[i - 1][0], result2[i - 1][1], functionNumber);
                result2[i][2] = function.f(result2[i][0], result2[i][1], functionNumber);
                result2[i][3] = function.f1(result2[i][0], result2[i][1], functionNumber);
            }
            counter *= 2;
            if (count == 0){
                System.out.println();
            }
        }

        return result;
    }
}
