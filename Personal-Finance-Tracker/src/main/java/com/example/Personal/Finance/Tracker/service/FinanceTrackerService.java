package com.example.Personal.Finance.Tracker.service;

import com.example.Personal.Finance.Tracker.model.FinanceTrackerModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FinanceTrackerService {

    private final FinanceTrackerModel financeTrackerModel;

    List<FinanceTrackerModel> financeTrackerModelList;
    private Long id = 1L;
}
