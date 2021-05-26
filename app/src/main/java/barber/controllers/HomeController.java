package barber.controllers;

import barber.services.CommentService;
import barber.services.EmployeeService;
import barber.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    public CommentService commentService;

    @Autowired
    public ServicesService servicesService;

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("comments", commentService.find3LastComments());
        model.addAttribute("services", servicesService.getAll());
        model.addAttribute("barbers", employeeService.getAll());
        return "landing";
    }
}
