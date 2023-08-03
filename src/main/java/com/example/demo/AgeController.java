package com.example.demo;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    @GetMapping("/calculate-age")
    public String calculateAge(@RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob) {
        int age = calculateAgeFromBirthDate(dob);
        return "Age: " + age + " years";
    }

    private int calculateAgeFromBirthDate(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}



