package com.mycompany.controllers;

import com.mycompany.kierunek.Kierunek;
import com.mycompany.kierunek.KierunekService;
import com.mycompany.nauczyciel.Nauczyciel;
import com.mycompany.user.User;
import com.mycompany.user.UserNotFoundException;
import com.mycompany.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @Autowired private KierunekService kierunekService;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers=service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }


    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        List<Kierunek> listaKierunkow=kierunekService.listaKierunkow();
        model.addAttribute("listaKierunkow",listaKierunkow);

        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        service.save(user);
        ra.addFlashAttribute("message", "User successfully saved!");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
           User user= service.get(id);
            List<Kierunek> listaKierunkow=kierunekService.listaKierunkow();
            model.addAttribute("listaKierunkow",listaKierunkow);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit User (ID: "+id+")");
            return "user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message","The user have been saved succesfully");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "User successfully deleted!");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "User not found!");
        }
        return "redirect:/users";
    }

}
