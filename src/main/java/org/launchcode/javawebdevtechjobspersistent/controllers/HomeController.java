package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model) {
        Iterable<Job> jobs;
        jobs = jobRepository.findAll();
        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs", jobs);
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {

        Iterable<Employer> employers;
        Iterable<Skill> skills;

        skills = skillRepository.findAll();
        //System.out.println("count:");


        employers = employerRepository.findAll();

        //System.out.println("count:");
        model.addAttribute("skills", skills);
        model.addAttribute("employers", employers);
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }
        Optional optEmployer = employerRepository.findById(employerId);
        Employer employer = (Employer) optEmployer.get();
        newJob.setEmployer(employer);
        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);

        jobRepository.save(newJob);
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional optionalJob = jobRepository.findById(jobId);
        if (optionalJob.isPresent()) {
            Job job = (Job) optionalJob.get();
            model.addAttribute("job", job);
            return "view";
        } else {
            return "redirect:../";
        }
    }


}
