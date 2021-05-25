package barber.controllers;

import barber.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterChoice {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/order")
    public String getOrderForm(Model model) {
        model.addAttribute("masters", employeeService.getAll());
        return "masterChoice";
    }
}
