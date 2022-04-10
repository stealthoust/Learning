package com.mycompany.controllers;

import com.mycompany.kierunek.Kierunek;
import com.mycompany.kierunek.KierunekNotFoundException;
import com.mycompany.kierunek.KierunekService;
import com.mycompany.przedmiot.Przedmiot;
import com.mycompany.przedmiot.PrzedmiotService;
import com.mycompany.user.User;
import com.mycompany.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class KierunekController {

    @Autowired private KierunekService service;


    @GetMapping("/kierunki")
    public String showKierunkiList(Model model){
        List<Kierunek> listKierunki=service.listaKierunkow();
        model.addAttribute("listKierunki",listKierunki);



        return "kierunki";
    }
    @GetMapping("/kierunki/new")
    public String showNewForm(Model model){
        model.addAttribute("kierunek",new Kierunek());
        model.addAttribute("pageTitle","Dodaj kierunek");
        return "kierunek_form";
    }

    @PostMapping("/kierunki/save")
    public String saveKierunek(Kierunek kierunek, RedirectAttributes ra) {
        service.save(kierunek);
        ra.addFlashAttribute("message", "Kierunek pomyślnie zapisany!");
        return "redirect:/kierunki";
    }

    @GetMapping("/kierunki/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Kierunek kierunek= service.get(id);
            model.addAttribute("kierunek",kierunek);
            model.addAttribute("pageTitle","Edytujesz kierunek o (ID: "+id+")");
            return "kierunek_form";
        } catch (KierunekNotFoundException e) {
            ra.addFlashAttribute("message","Kierunek zapisany pomyślnie");
            return "redirect:/kierunki";
        }
    }

    @GetMapping("/kierunki/delete/{id}")
    public String deleteKierunek(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Kierunek pomyślnie usunięty!");
        } catch (KierunekNotFoundException e) {
            ra.addFlashAttribute("message", "Nie znaleziono kierunku");
        }
        return "redirect:/kierunki";
    }

}
