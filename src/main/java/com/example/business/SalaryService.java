package com.example.business;

import com.example.model.Person;

public class SalaryService {
    private final static Double monthlyBaseSalary = 2000.00;

    public final static Integer mealCheckAmount = 8;

    public Double getMonthlySalary(Person person) {
        switch (person.getSeniority()) {
            case JUNIOR -> {
                return monthlyBaseSalary;
            }
            case MEDIOR -> {
                return monthlyBaseSalary * 1.1;
            }
            case SENIOR -> {
                return monthlyBaseSalary * 1.3;
            }
            case PRINCIPAL -> {
                return monthlyBaseSalary * 1.5;
            }
        }
        return null;
    }

    public Double getYearlySalary(Person person) {
        return getMonthlySalary(person) * 12;
    }

    public Integer getTotalMealCheckAmount(Integer daysWorked){
        if (daysWorked < 0) {
            throw new IllegalArgumentException("Gewerkte dagen kan niet minder dan nul zijn.");
        }
        return mealCheckAmount * daysWorked;
    }
}
