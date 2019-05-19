package cn.benlocke.webservice.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.benlocke.webservice.web.form.PersonForm;


@Controller
public class FormController {

    @GetMapping("/myform")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/myform")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
}