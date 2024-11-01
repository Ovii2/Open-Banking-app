package org.example.company.service;


import lombok.AllArgsConstructor;
import org.example.company.model.Transaction;
import org.example.company.repo.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;


    public List<Transaction> findAllByAccountNumber(int accountNumber) {
        return transactionRepository.findAllByAccountNumber(accountNumber);
//        return List.of(Transaction.builder()
//                .type("Debit")
//                .date(LocalDate.of(2024, 10, 1))
//                .accountNumber(accountNumber)
//                .currency("USD")
//                .amount(100.50)
//                .merchantName("Amazon")
//                .merchantLogo("amazon_logo.png")
//                .build());

    }
}
