package com.crud.simpleCrud.controllers;

import com.crud.simpleCrud.entities.PersonEntity;
import com.crud.simpleCrud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("people", personService.findAll());
        return "mainPage";
    }

//    @RequestMapping({"/edit/{id}"})
//    public String editPerson (@PathVariable("id") String id) {
//        return "formPage";
//    }

    @RequestMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable Long id, Model model) {

        personService.deleteById(id);
        model.addAttribute("people", personService.findAll());
        return "redirect:/";
    }
    @GetMapping({"/create"})
    public String initCreate(Map<String,Object> model) {
        PersonEntity personEntity = new PersonEntity();
        model.put("personEntity", personEntity);
        return "formPage";
    }
    @PostMapping({"/create"})
    public String processCreate(@Valid PersonEntity personEntity, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("personEntity",personEntity);
            return "formPage";
        } else {
            this.personService.save(personEntity);
            model.addAttribute("people", personService.findAll());
            return "redirect:/";
        }
    }
    @GetMapping({"/edit/{id}"})
    public String initEdit(@PathVariable("id") Long id, Model model) {
        PersonEntity personEntity = this.personService.findById(id);
        model.addAttribute("personEntity",personEntity);
        return "formPage";
    }
    @PostMapping({"/edit/{id}"})
    public String processEdit(@Valid PersonEntity personEntity, BindingResult bindingResult,
                              @PathVariable("id") Long id,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("personEntity",personEntity);
            return "formPage";
        } else {
            personEntity.setId(id);
            this.personService.save(personEntity);
            model.addAttribute("people", personService.findAll());
            return "redirect:/";
        }
    }
}
