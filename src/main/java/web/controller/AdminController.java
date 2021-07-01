package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getAllUsers(Model model){
        model.addAttribute("getAllUsers", userService.getAllUsers());
        return "testIndex";
    }

    @GetMapping("/new")
    public String createNewUser(Model model){
        model.addAttribute("createNewUserGetMethod", new User());
        return "testNew";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user, @ModelAttribute("myRole") String myRole) {
        Role role = new Role((myRole.equals("ADMIN") ? 1L : 2L), "ROLE" + myRole);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "testEdit";
    }

    @PatchMapping("/{id}")
    public String patch(@ModelAttribute("user") User user,  @PathVariable Long id, @ModelAttribute("myRole") String myRole){

     userService.updateUser(userService.getUserById(id));

        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        userService.removeUserById(id);
        return "redirect:/admin";
    }




}
