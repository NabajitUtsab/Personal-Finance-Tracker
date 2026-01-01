package com.example.Personal.Finance.Tracker.controller;

import com.example.Personal.Finance.Tracker.model.FinanceTrackerModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class FinanceController {

    List<FinanceTrackerModel> financeTrackerModelList = new ArrayList<>();
    Long nextId = 1L;

//    @GetMapping
//    public List<FinanceTrackerModel> getFinanceTrackerModelList() {
//        return financeTrackerModelList;
//    }

    @GetMapping("/{id}")
    public Optional<FinanceTrackerModel> getFinanceTrackerModel(@PathVariable Long id) {
        return financeTrackerModelList.stream()
                .filter(t -> t.getId().equals(id)).findFirst();
    }

    @DeleteMapping("/{id}")
    public String deleteFinanceTrackerModel(@PathVariable Long id) {
        financeTrackerModelList.removeIf(t -> t.getId().equals(id));
        return "Deleted";
    }

    @PostMapping
    public String saveFinanceTrackerModel(@RequestBody FinanceTrackerModel financeTrackerModel) {
        financeTrackerModel.setId(nextId++);
        financeTrackerModelList.add(financeTrackerModel);
        return "Saved";
    }


    @GetMapping
    public List<FinanceTrackerModel> getFinanceTrackerModelByType(
            @RequestParam(required = false) String type) {

        if (type == null) {
            return financeTrackerModelList;
        }

        return financeTrackerModelList.stream()
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
