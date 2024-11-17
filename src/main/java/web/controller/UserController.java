package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final String REDIRECT_USERS = "redirect:/users";
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping(value = "/users")
    @GetMapping
    public String getString(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        userService.getAllUsers().stream().forEach(System.out::println);
        return "users/users";
    }

    @GetMapping (value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return REDIRECT_USERS;
    }

    @GetMapping(value = "/update")
    public String update(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/update";
    }

    @PatchMapping
    public String edit(@ModelAttribute("user") User user) {
        userService.updateUser(user.getId(), user);
        return REDIRECT_USERS;
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/delete";
    }

    @DeleteMapping(value = "/{id}")
    public String remove(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return REDIRECT_USERS;
    }
}
