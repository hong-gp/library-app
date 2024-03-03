package com.group.libraryapp.controller;

import com.group.libraryapp.domain.test.Calculator;
import com.group.libraryapp.domain.test.DayOfTheWeek;
import com.group.libraryapp.dto.test.request.CalculatorRequest;
import com.group.libraryapp.dto.test.request.DateRequest;
import com.group.libraryapp.dto.test.request.SumRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
public class TestController {

    @GetMapping("/api/v1/calc")
    public Calculator calc(CalculatorRequest request) {
        int num1 = request.getNum1();
        int num2 = request.getNum2();
        int add = num1 + num2;
        int minus = num1 - num2;
        int multiply = num1 * num2;
        return new Calculator(add, minus, multiply);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayOfTheWeek dayOfTheWeek(DateRequest request) {
        DayOfWeek dayOfWeek = LocalDate.parse(request.getDate()).getDayOfWeek();
        int week = dayOfWeek.getValue();
        String date = "";

        switch (week) {
            case 1: date = "MON";
                break;
            case 2: date = "TUE";
                break;
            case 3: date = "WED";
                break;
            case 4: date = "THU";
                break;
            case 5: date = "FRI";
                break;
            case 6: date = "SAT";
                break;
            case 7: date = "SUN";
                break;
        }

        return new DayOfTheWeek(date);
    }

    @PostMapping("/api/v1/sum")
    public Integer sum(@RequestBody SumRequest request) {
        int sum = 0;
        for (int i : request.getNumbers()) {
            sum += i;
        }
        return sum;
    }
}
