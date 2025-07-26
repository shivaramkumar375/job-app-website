package com.jobportal.backend.controller;

import com.jobportal.backend.model.JobApplication;
import com.jobportal.backend.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")  // Allow requests from React
@RequestMapping("/apply")
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository repository;

    @PostMapping("/submit")
    public String submitApplication(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam("resume") MultipartFile file
    ) {
        try {
            JobApplication app = new JobApplication();
            app.setName(name);
            app.setEmail(email);
            app.setPhone(phone);
            app.setResume(file.getBytes());

            repository.save(app);
            return "Application submitted successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

