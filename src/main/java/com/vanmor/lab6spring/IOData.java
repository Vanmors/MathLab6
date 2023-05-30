package com.vanmor.lab6spring;


import com.vanmor.lab6spring.Charts.UploadChart;
import com.vanmor.lab6spring.Methods.EulerMethod;
import com.vanmor.lab6spring.Methods.MilanaMethod;
import com.vanmor.lab6spring.Methods.RungeMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IOData {

    @GetMapping("/")
    public String welcomePage(Model model) {
        model.addAttribute("form", new Form());
        return "index";
    }

    @GetMapping("/resultPage")
    public String outTable(@ModelAttribute Form form, Model model) {
        EulerMethod eulerMethod = new EulerMethod();
        RungeMethod rungeMethod = new RungeMethod();
        MilanaMethod milanaMethod = new MilanaMethod();
        int n = (int) (Math.abs(form.getB() - form.getA()) / form.getH()) + 1;
//        double[][] result = new double[n][4];

        if (form.getMethod() == 1) {
            double[][] result = eulerMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction(), form.getH());
            UploadChart.result = result;
            model.addAttribute("result", result);
        } else if (form.getMethod() == 2) {
            double[][] result = rungeMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction());
            model.addAttribute("result", result);
            UploadChart.result = result;
        } else if (form.getMethod() == 3) {
            double[][] result = milanaMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction());
            UploadChart.result = result;
            model.addAttribute("result", result);
        }


        UploadChart.numberOfFunction = form.getNumberOfFunction();


        return "result";
    }
}
