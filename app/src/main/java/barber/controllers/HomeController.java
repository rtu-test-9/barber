package barber.controllers;

import barber.dao.CommentDAO;
import barber.entities.Comment;
import barber.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @Autowired
    public CommentService commentService;
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("comments", commentService.find3LastComments());
        return "landing";
    }
}
