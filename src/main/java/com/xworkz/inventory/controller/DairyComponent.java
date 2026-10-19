package com.xworkz.inventory.controller;

import com.xworkz.inventory.dto.DairyDto;
import com.xworkz.inventory.service.DairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/dairy")
public class DairyComponent
{
    @Autowired
    public DairyService dairyService;

    public List<String> location;

    public DairyComponent()
    {
        System.out.println("created DairyComponent");
    }

    @PostConstruct
    public void loadDropdown()
    {
        System.out.println("loadDropdown() started in DairyComponent with @PostConstruct");
        location= Stream.of("Bidar","Kalaburagi","Yadgir","Raichur","Koppal","Bellary","Vijayanagara").collect(Collectors.toList());
    }

    @GetMapping
    public String start(Model model)
    {
        System.out.println("start() @GetMapping in DairyComponent");
        model.addAttribute("location",location);
        return "Dairy";
    }

    @PostMapping
    public String accept(Model model, @Valid DairyDto dairyDto, BindingResult bindingResult)
    {
        System.out.println("accept() @PostMapping in DairyComponent");
        if(bindingResult.hasErrors())
        {
            model.addAttribute("error","Validation failed");
            List<ObjectError> errors = bindingResult.getAllErrors();
            model.addAttribute("errors",errors);
            model.addAttribute("location",location);
        }
        else {
            System.out.println("validation passed"+"\n"+"dairyDto = " + dairyDto);
            this.dairyService.save(dairyDto);
            model.addAttribute("success","Dairy details are saved successfully");
            model.addAttribute(new DairyDto());
            model.addAttribute("location",location);
        }
        return "Dairy";
    }



}
