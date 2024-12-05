package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    public String listAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("title", "Lista de Usuarios");
        model.addAttribute("listaUsuarios", users);
        return "pages/list-user";
    }

    @GetMapping("/nuevo")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("title", "Registrar Usuario");
        model.addAttribute("user", user);
        return "pages/form-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user/listar";
    }
    @GetMapping("/delete/{id}")
    public String deleteMatricula(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user/listar";
    }
}
