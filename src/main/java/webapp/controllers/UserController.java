package webapp.controllers;

import webapp.models.User;
import webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String user(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findUserByLogin(username);
        model.addAttribute("user", user);
        return "user";
    }

}