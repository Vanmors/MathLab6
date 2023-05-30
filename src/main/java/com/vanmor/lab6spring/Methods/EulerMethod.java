package com.vanmor.lab6spring.Methods;

import com.vanmor.lab6spring.Function;

public class EulerMethod {

    public double[][] method(double a, double b, double y0, double h, int functionNumber, double e) {

        if (a==b){
            return null;
        }
//        Function function = new Function();
//        int p = 1;
//        int n = (int) (Math.abs(b - a) / h) + 1;
//        double[][] result = null;
//        double[][] result2 = null;
//        double h1 = h;
//        double h2 = h1 / 2;
//        int n2 = (int) (Math.abs(b - a) / h2) + 1;
//        int counter = 0;
//
//        while (result == null) {
//            result = new double[n][4];
//            result2 = new double[n2][4];
//
//            result[0][0] = a;
//            result[0][1] = y0;
//            result2[0][0] = a;
//            result2[0][1] = y0;
//
//            double y1 = e + 1;
//            double y2 = 0;
//            while (true) {
//                counter++;
//                if (counter == result.length) {
//                    break;
//                }
//                result[counter][0] = result[counter - 1][0] + h1;
////                y1 = result[counter - 1][1] + h / 2 * function.f(result[counter - 1][0], result[counter - 1][1], functionNumber);
//                result2[counter][0] = result2[counter - 1][0] + h1/2;
////                y2 = result2[counter - 1][1] + h2 / 2 * function.f(result2[counter - 1][0], result2[counter - 1][1], functionNumber);
//                double yH = result[counter - 1][1] + h1 / 2 * (function.f(result[counter - 1][0], result[counter - 1][1], functionNumber)
//                        + function.f(result[counter - 1][0], result[counter - 1][1] + h1 * function.f(result[counter - 1][0],
//                result[counter - 1][1], functionNumber), functionNumber));
//                double yHdiv2 = result2[counter - 1][1] + h1 / 4 * (function.f(result2[counter - 1][0], result2[counter - 1][1], functionNumber)
//                        + function.f(result2[counter - 1][0], result2[counter - 1][1] + h1/2 * function.f(result2[counter - 1][0],
//                        result2[counter - 1][1], functionNumber), functionNumber));
//                if (Math.abs(yH - yHdiv2) > e) {
//                    result = null;
//                    result2 = null;
//                    counter = 0;
////                    h1 = h2;
////                    h2 = h2 / 2;
//                    h1 /= 2;
//                    n = (int) (Math.abs(b - a) / h1) + 1;
//                    n2 = (int) (Math.abs(b - a) / (h1/2)) + 1;
//                    break;
//                } else {
//                    result[counter][1] = yH;
//                    result2[counter][1] = yHdiv2;
//                }
//            }
//        }

        Function function = new Function();
        int n = (int) (Math.abs(b - a) / h) + 1;
        double[][] result = new double[n][4];
        if (h >= Math.abs(a-b)) {
            return null;
        }
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

        return result;
    }
}
