package com.example.Personal.Finance.Tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinanceTrackerModel {

    private Long id;
    private String title;
    private String type;
    private double amount;
    private LocalDate date;

}
