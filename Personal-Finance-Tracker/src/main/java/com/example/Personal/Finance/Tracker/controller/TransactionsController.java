package com.example.Personal.Finance.Tracker.controller;

import com.example.Personal.Finance.Tracker.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    List<Transaction> transactionList = new ArrayList<>();
    Long nextId = 1L;

//    @GetMapping
//    public List<FinanceTrackerModel> getFinanceTrackerModelList() {
//        return financeTrackerModelList;
//    }

    @GetMapping("/{id}")
    public Optional<Transaction> getFinanceTrackerModel(@PathVariable Long id) {
        return transactionList.stream()
                .filter(t -> t.getId().equals(id)).findFirst();
    }

    @DeleteMapping("/{id}")
    public String deleteFinanceTrackerModel(@PathVariable Long id) {
        transactionList.removeIf(t -> t.getId().equals(id));
        return "Deleted";
    }

    @PostMapping
    public String saveFinanceTrackerModel(@RequestBody Transaction transaction) {
        transaction.setId(nextId++);
        transactionList.add(transaction);
        return "Saved";
    }


    @GetMapping
    public List<Transaction> getFinanceTrackerModelByType(
            @RequestParam(required = false) String type) {

        if (type == null) {
            return transactionList;
        }

        return transactionList.stream()
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
