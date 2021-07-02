package web.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.RoleDao;

import web.models.User;
import web.service.UserService;


import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleDao roleDao;

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
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "rolesId") List<String> roles) {
//        Long idRole = Long.parseLong(roles.get(0));
//        if (idRole != 1) {
//            Set<Role> rolesUser = new HashSet<>();
//            rolesUser.add(roleDao.getById(1L));
//            rolesUser.add(roleDao.getById(idRole));
//            user.setRoles(rolesUser);
//        } else {
//            user.setRoles(Collections.singleton(roleDao.getById(1L)));
//        }
//        userService.addUser(user);
        return "redirect:/admin";
    }



    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "testEdit";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") Long id,
                         @RequestParam(value = "rolesId") List<String> roles) {
//        Long idRole = Long.parseLong(roles.get(0));
//        if (idRole != 1) {
//            Set<Role> rolesUser = new HashSet<>();
//            rolesUser.add(roleDao.getById(1L));
//            rolesUser.add(roleDao.getById(idRole));
//            user.setRoles(rolesUser);
//        } else {
//            user.setRoles(Collections.singleton(roleDao.getById(1L)));
//        }
//        userService.updateUser(user);
        return "redirect:/admin";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        userService.removeUserById(id);
        return "redirect:/admin";
    }




}
