package webapp.controllers;
import webapp.models.User;
import webapp.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String helloPage() {
        return "/mainpage";
    }

    @GetMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "/edit";
    }

    @GetMapping("/new")
    public String openPageNew(@ModelAttribute ("user") User user){
        return "/create";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/admin/all";
    }

    @PostMapping("/{id}")
    public String postEdit(@ModelAttribute() User user) {
        userService.update(user);
        return "redirect:all";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:all";
    }
}