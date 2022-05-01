package com.example.simpleCRUD.controller;


import com.example.simpleCRUD.entity.User;
import com.example.simpleCRUD.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model){
        List<User> userList = userService.getUsers();
        model.addAttribute("users", userList);
        return "list";
    }

    @GetMapping("/add")
    public String initAddUser (Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "form";
        }
        userService.addUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/update/{id}")
    public String initUpdateUser(Model model, @PathVariable long id){
        model.addAttribute("user", userService.getUser(id));
        return "form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "form";
        }
        userService.updateUser(user);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String initDeleteUser(Model model, @PathVariable long id){
        User user = userService.getUser(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("user", user);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@RequestParam String confirmed, @RequestParam long id) {
        if ("yes".equals(confirmed)) {
            userService.deleteUser(id);
        }
        return "redirect:/user/all";
    }
}
