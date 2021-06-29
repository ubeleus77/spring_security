package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getAllUsers(Model model){
        model.addAttribute("getAllUsers", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String createNewUser(Model model){
        model.addAttribute("createNewUserGetMethod", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("createUser") User user){
        userService.addUser(user);
        return "redirect:/admin";

    }


    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String patch(@ModelAttribute("user") User user,  @PathVariable Long id){

     userService.updateUser(userService.getUserById(id));

        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        userService.removeUserById(id);
        return "redirect:/admin";
    }




}
