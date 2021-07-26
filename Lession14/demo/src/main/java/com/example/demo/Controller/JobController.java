package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.example.demo.Model.Job;
import com.example.demo.Repository.JobRepository;

import java.util.Optional;

@Controller

public class JobController {
    @Autowired
    private JobRepository jobRepository;

    //List cac job
    @GetMapping("/listJob")
    public String getAllJob(Model model){
        model.addAttribute("jobs",jobRepository.getAll());
        return "jobList";
    }

    //Job Form
    @GetMapping("/addJob")
    public String addJob(Model model){
        model.addAttribute("job",new Job());
        model.addAttribute("title", "Add New Job");
        return "jobForm";
    }

    //Them job
    @PostMapping("/addJob")
    public String addJob(@Valid @ModelAttribute("job")Job job, BindingResult result,Model model){

        if(result.hasErrors()){
            return "jobForm";
        }
        if (job.getId() > 0) {
            jobRepository.edit(job);
            model.addAttribute("jobs",jobRepository.getAll());
            return "jobList";
        } else {
            Job newJob = jobRepository.create(job);
            if(newJob!=null){
                model.addAttribute("jobs",jobRepository.getAll());
                return "jobList";
            }
            model.addAttribute("error","Job already exist");
            return "jobForm";
        }

    }

    //Cap nhat Job
    @GetMapping("/job/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {
        Optional<Job> job = jobRepository.get(id);
        if (job.isPresent()) {
            model.addAttribute("job", job.get());
            model.addAttribute("title", "Edit job");
        }
        return "jobForm";
    }

    //Xoa job
    @GetMapping("/job/delete/{id}")
    public String deleteJob(@PathVariable("id") int id, Model model) {
        jobRepository.deleteById(id);
        model.addAttribute("jobs", jobRepository.getAll());
        return "jobList";
    }
}