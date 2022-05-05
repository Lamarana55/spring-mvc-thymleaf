package com.lamarana.patient;

import com.github.javafaker.Faker;
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
        Faker faker = new Faker();
        return args -> {
            patientRepository.save(new Patient(null, faker.name().lastName(), faker.name().firstName(), faker.date().birthday(), faker.bool().bool(), faker.number().randomDigit()));
            patientRepository.save(new Patient(null, faker.name().lastName(), faker.name().firstName(), faker.date().birthday(), faker.bool().bool(), faker.number().numberBetween(10,100)));
            patientRepository.save(new Patient(null, faker.name().lastName(), faker.name().firstName(), faker.date().birthday(), faker.bool().bool(), faker.number().randomDigit()));
            patientRepository.save(new Patient(null, faker.name().lastName(), faker.name().firstName(), faker.date().birthday(), faker.bool().bool(), faker.number().randomDigit()));
            patientRepository.save(new Patient(null, faker.name().lastName(), faker.name().firstName(), faker.date().birthday(), faker.bool().bool(), faker.number().numberBetween(10,100)));
        };
    }

}
