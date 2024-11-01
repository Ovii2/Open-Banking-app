package org.example.company.service;


import org.example.company.dto.transaction.TransactionResponseDTO;
import org.example.company.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    public List<TransactionResponseDTO> findAllByAccountNumber(Integer accountNumber) {
        Transaction transaction1 = Transaction.builder()
                .type("Debit")
                .date(LocalDate.of(2024, 10, 1))
                .accountNumber(accountNumber)
                .currency("USD")
                .amount(100.50)
                .merchantName("Amazon")
                .merchantLogo("amazon_logo.png")
                .build();

        Transaction transaction2 = Transaction.builder()
                .type("Credit")
                .date(LocalDate.of(2024, 10, 2))
                .accountNumber(accountNumber)
                .currency("USD")
                .amount(200.75)
                .merchantName("Walmart")
                .merchantLogo("walmart_logo.png")
                .build();

        Transaction transaction3 = Transaction.builder()
                .type("Debit")
                .date(LocalDate.of(2024, 10, 3))
                .accountNumber(accountNumber)
                .currency("USD")
                .amount(50.00)
                .merchantName("Starbucks")
                .merchantLogo("starbucks_logo.png")
                .build();

        List<Transaction> transactions = List.of(transaction1, transaction2, transaction3);


        return transactions.stream()
                .map(transaction -> TransactionResponseDTO.builder()
                        .build())
                .collect(Collectors.toList());
    }
}
