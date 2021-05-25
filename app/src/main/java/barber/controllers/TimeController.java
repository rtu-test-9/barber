package barber.controllers;

import barber.entities.Employee;
import barber.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/timeChoice")
    public String getController(Model model, @RequestParam(name = "masterName") String masterName) {
        Employee master = employeeService.getByName(masterName);
        model.addAttribute("master", master);
        return "orderDetails";
    }
}
