package com.lamarana.patient;

import com.lamarana.patient.Repositories.PatientRepository;
import com.lamarana.patient.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Diallo", "Lamarana", new Date(), false, 10));
            patientRepository.save(new Patient(null, "Diallo", "Mamadou", new Date(), true, 15));
            patientRepository.save(new Patient(null, "Sow", "Hassanatou", new Date(), false, 159));
        };
    }

}
