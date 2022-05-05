package com.lamarana.patient.controllers;

import com.lamarana.patient.Repositories.PatientRepository;
import com.lamarana.patient.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public String index(Model model) {
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(System.out::println);
        model.addAttribute("listPatients", patients);
        return "patients";
    }
}
