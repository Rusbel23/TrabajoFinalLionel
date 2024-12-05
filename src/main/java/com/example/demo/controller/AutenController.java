package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class AutenController {
    private final UserService userService;

    public AutenController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    public String listAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("title", "Lista de Usuarios");
        model.addAttribute("listaUsuarios", users);
        return "pages/list-user";
    }
}