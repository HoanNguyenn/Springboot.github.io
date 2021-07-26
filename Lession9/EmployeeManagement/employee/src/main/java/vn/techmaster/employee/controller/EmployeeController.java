package vn.techmaster.employee.controller;

import vn.techmaster.employee.exception.ResourceNotFoundException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.techmaster.employee.model.Employee;
import vn.techmaster.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ExceptionHandler(ResourceNotFoundException.class)
    public String home(Model model, Exception ex) {
        List<Employee> employees = this.employeeService.findAll();
        model.addAttribute("ex", ex.getMessage());
        model.addAttribute("employees", employees);
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("title", "Add New Employee");
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("title") String title, @ModelAttribute @Valid Employee employee, 
        BindingResult bindingResult, RedirectAttributes rAttributes, Model model) {
        model.addAttribute("title", title);
        if (bindingResult.hasErrors()) {
            return "form";
        }
        this.employeeService.addOrUpdate(employee);
        rAttributes.addFlashAttribute("successMsg", "Employee duoc update thanh cong");
        return "redirect:/employee";
    }

  
}
