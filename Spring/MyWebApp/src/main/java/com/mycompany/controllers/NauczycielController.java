package com.mycompany.controllers;


import com.mycompany.nauczyciel.Nauczyciel;
import com.mycompany.nauczyciel.NauczycielNotFoundException;
import com.mycompany.nauczyciel.NauczycielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NauczycielController {

    @Autowired
    private NauczycielService service;

    @GetMapping("/nauczyciele")
    public String showNauczycieleList(Model model){
        List<Nauczyciel> listaNauczycieli=service.listaNauczycieli();
        model.addAttribute("listaNauczycieli",listaNauczycieli);
        return "nauczyciele";
    }
    @GetMapping("/nauczyciele/new")
    public String showNewForm(Model model){
        model.addAttribute("nauczyciel",new Nauczyciel());
        model.addAttribute("pageTitle","Dodaj Nauczyciela");
        return "nauczyciel_form";
    }

    @PostMapping("/nauczyciel/save")
    public String saveNauczyciel(Nauczyciel nauczyciel, RedirectAttributes ra) {
        service.save(nauczyciel);
        ra.addFlashAttribute("message", "Nauczyciel pomyślnie zapisany!");
        return "redirect:/nauczyciele";
    }

    @GetMapping("/nauczyciele/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Nauczyciel nauczyciel= service.get(id);
            model.addAttribute("nauczyciel",nauczyciel);
            model.addAttribute("pageTitle","Edytujesz nauczyciela o (ID: "+id+")");
            return "nauczyciel_form";
        } catch (NauczycielNotFoundException e) {
            ra.addFlashAttribute("message","Nauczyciel zapisany pomyślnie");
            return "redirect:/nauczyciele";
        }
    }

    @GetMapping("/nauczyciele/delete/{id}")
    public String deleteNauczyciel(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Nauczyciel pomyślnie usunięty!");
        } catch (NauczycielNotFoundException e) {
            ra.addFlashAttribute("message", "Nie znaleziono nauczyciela");
        }
        return "redirect:/nauczyciele";
    }
}
