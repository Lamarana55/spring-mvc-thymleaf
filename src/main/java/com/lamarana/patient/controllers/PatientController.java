package com.lamarana.patient.controllers;

import com.lamarana.patient.Repositories.PatientRepository;
import com.lamarana.patient.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size) {
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
        pagePatients.getContent().forEach(System.out::println);
        model.addAttribute("listPatients", pagePatients);
        model.addAttribute("pages",new int[ pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        System.out.println("Total pages " + pagePatients.getTotalPages());
        return "patients";
    }
}
