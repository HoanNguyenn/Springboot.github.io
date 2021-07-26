package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import com.example.demo.Model.Person;
import com.example.demo.Repository.JobRepository;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Service.StorageService;

import java.util.List;
import java.util.Optional;

@Controller

public class PersonController {
    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private StorageService storageService;

    @Autowired
    private JobRepository jobRepo;

    //Trang chu
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("jobs",jobRepo.getAll());
        return "home";
    }

    //Them Person
    @PostMapping(value = "/post", consumes = {"multipart/form-data"})
    public String postInfo(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) throws Exception {
        if (person.getPhoto().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("person", "photo", "Photo is required"));
        }
        if (result.hasErrors()) {
            return "home";
        }
        if (person.getId() > 0) {
            personRepo.edit(person);
        } else {
            personRepo.create(person);
        }
        storageService.uploadFile(person.getPhoto(), person.getId());
        model.addAttribute("people", personRepo.getAll());
        return "listAll";

    }

    //Liet ke danh sach Person
    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<Person> people = personRepo.getAll();
        model.addAttribute("people", people);
        return "listAll";
    }

    //Hien thi chi tiet Person
    @GetMapping("/person/{id}")
    public String personInfo(@PathVariable("id")int id,Model model){
        Optional<Person> person = personRepo.get(id);
        if(person.isPresent()){
            model.addAttribute("person",person.get());
            return "personInfor";
        }
        return "home";
    }


    //Cap nhat thong tin Person
    @GetMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        Optional<Person> person = personRepo.get(id);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
        }
        return "personForm";
    }

    //Xoa person
    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personRepo.deleteById(id);
        model.addAttribute("people", personRepo.getAll());
        return "redirect:/listAll";
    }
}