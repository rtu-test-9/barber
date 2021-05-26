package barber.controllers;

import barber.entities.Employee;
import barber.entities.EmployeesServices;
import barber.entities.Service;
import barber.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class TimeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/timeChoice")
    @Transactional
    public String getController(Model model, @RequestParam(name = "masterName") String masterName) {
        Employee master = employeeService.getByName(masterName);
        Set<EmployeesServices> services = master.getServices();
        List<Service> masterServices = new ArrayList<>();
        for (EmployeesServices employeeService:services) {
            masterServices.add(employeeService.getService());
        }
        List<Date> time = new ArrayList<>();
        for (Date availableDate: master.getAvailableDates()) {
            time.add(availableDate);
        }
        model.addAttribute("master", master);
        model.addAttribute("services", masterServices);
        model.addAttribute("times", time);
        return "orderDetails";
    }
}
