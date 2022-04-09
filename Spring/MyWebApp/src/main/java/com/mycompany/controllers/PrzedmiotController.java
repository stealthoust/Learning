package com.mycompany.controllers;


import com.mycompany.nauczyciel.Nauczyciel;
import com.mycompany.nauczyciel.NauczycielService;
import com.mycompany.przedmiot.Przedmiot;
import com.mycompany.przedmiot.PrzedmiotNotFoundException;
import com.mycompany.przedmiot.PrzedmiotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PrzedmiotController {

    @Autowired
    private PrzedmiotService service;

    @Autowired
    NauczycielService nauczycielService;

    @GetMapping("/przedmioty")
    public String showPrzedmiotyList(Model model){

        List<Przedmiot> listaPrzedmiotow=service.listaPrzedmiotow();
        model.addAttribute("listaPrzedmiotow",listaPrzedmiotow);

        List<Nauczyciel> listaNauczycieli=nauczycielService.listaNauczycieli();
        model.addAttribute("listaNauczycieli",listaNauczycieli);

        return "przedmioty";
    }
    @GetMapping("/przedmioty/new")
    public String showNewForm(Model model){

        List<Nauczyciel> listaNauczycieli=nauczycielService.listaNauczycieli();
        model.addAttribute("listaNauczycieli",listaNauczycieli);

        model.addAttribute("przedmiot",new Przedmiot());
        model.addAttribute("pageTitle","Dodaj Przedmiot");
        return "przedmiot_form";
    }

    @PostMapping("/przedmiot/save")
    public String savePrzedmiot(Przedmiot przedmiot, RedirectAttributes ra) {
        service.save(przedmiot);
        ra.addFlashAttribute("message", "Przedmiot pomyślnie zapisany!");
        return "redirect:/przedmioty";
    }

    @GetMapping("/przedmioty/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            List<Nauczyciel> listaNauczycieli=nauczycielService.listaNauczycieli();
            model.addAttribute("listaNauczycieli",listaNauczycieli);
            Przedmiot przedmiot= service.get(id);
            model.addAttribute("przedmiot",przedmiot);
            model.addAttribute("pageTitle","Edytujesz przedmiot o (ID: "+id+")");
            return "przedmiot_form";
        } catch (PrzedmiotNotFoundException e) {
            ra.addFlashAttribute("message","Przedmiot zapisany pomyślnie");
            return "redirect:/przedmioty";
        }
    }

    @GetMapping("/przedmioty/delete/{id}")
    public String deletePrzedmiot(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Przedmiot pomyślnie usunięty!");
        } catch (PrzedmiotNotFoundException e) {
            ra.addFlashAttribute("message", "Nie znaleziono przedmiotu");
        }
        return "redirect:/przedmioty";
    }
}
