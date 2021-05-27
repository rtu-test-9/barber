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

    public CommentService commentService;

    public ServicesService servicesService;

    public EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    public void setServicesService(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("comments", commentService.find3LastComments());
        model.addAttribute("services", servicesService.getAll());
        model.addAttribute("barbers", employeeService.getAll());
        return "landing";
    }
}
