package ru.gil.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static ru.gil.thymeleaf_demo.model.EmployeeDto.*;

@Controller
public class ExampleController {

    private final String INDEX_PAGE = "example";

    private final String EXAMPLE_LINK = "/example";

    @GetMapping("/example")
    public String getPage(Model model) {
        model.addAttribute("defaultName", "Peter Parker");
        model.addAttribute("greeting", "Hello world");
        model.addAttribute("employee", getEmployeeFirst());
        model.addAttribute("employeeMap", getMap());
        model.addAttribute("employeeList", getEmployeeList());
        model.addAttribute("employeeObject", getEmployeeSecond());
        return INDEX_PAGE;
    }

    @GetMapping("/example/link-expression")
    public ModelAndView linkExpressionMethod(@RequestParam(required = false) String status) {
        ModelAndView model = new ModelAndView();
        model.setView(new RedirectView(EXAMPLE_LINK));
        System.out.println(status);
        return model;
    }
}
