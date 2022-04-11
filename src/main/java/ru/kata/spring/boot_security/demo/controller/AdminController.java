package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("rolelist", roleService.getAllRoles());
        return "edit";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id, @RequestParam String[] roles) {
        List<Role> rolelist = new ArrayList<>();
        for (String s : roles) {
            rolelist.add(roleService.getByName(s));
        }
        user.setRole(rolelist);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", roleService.getAllRoles());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user, String[] roles) {
        List<Role> roleList = new ArrayList<>();
        for (String s : roles) {
            roleList.add(roleService.getByName(s));
        }
        user.setRole(roleList);
        userService.addUser(user);
        return "redirect:/admin";

    }
}
