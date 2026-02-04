package com.cts.controller;

import com.cts.model.Insurance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @RequestMapping("/first")
    public Insurance getInsurance() {
        Insurance insurance = new Insurance(1,"education", LocalDate.of(2027,11,12), 12000);
        return insurance;
    }

    @RequestMapping("/all")
    public Insurance[] getAllInsurance() {
        return insurance;
    }
    static Insurance insurance[];
    static {
        insurance=new Insurance[] {
                new Insurance(1,"education", LocalDate.of(2027,11,12), 12000),
                new Insurance(2,"marriage", LocalDate.of(2025,4,1), 500000),
                new Insurance(3,"health", LocalDate.of(2026,6,12), 250000),
                new Insurance(4,"car", LocalDate.of(2029,9,12), 400000),
                new Insurance(5,"home", LocalDate.of(2027,12,4), 1200000),
                new Insurance(6,"jwellery", LocalDate.of(2028,5,12), 900000),
        };
    }
}
