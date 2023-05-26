package com.vanmor.lab6spring;


import com.vanmor.lab6spring.Methods.EulerMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IOData {

    @GetMapping("/data")
    public String welcomePage(Model model) {
        model.addAttribute("form", new Form());
        return "index";
    }

    @GetMapping("/resultPage")
    public String outTable(@ModelAttribute Form form, Model model) {
        EulerMethod eulerMethod = new EulerMethod();

        model.addAttribute("result",
                eulerMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(), form.getNumberOfFunction()));
        return "result";
    }
}
