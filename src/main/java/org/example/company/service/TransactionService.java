package org.example.company.service;

import lombok.AllArgsConstructor;
import org.example.company.dto.transaction.TransactionResponseDTO;
import org.example.company.model.Transaction;
import org.example.company.repo.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionResponseDTO> findAllByAccountNumber(int accountNumber) {
        List<Transaction> transactions = transactionRepository.findAllByAccountNumber(accountNumber);

        return transactions.stream()
                .map(transaction -> new TransactionResponseDTO(
                        transaction.getType(),
                        transaction.getDate(),
                        transaction.getAccountNumber(),
                        transaction.getCurrency(),
                        transaction.getAmount(),
                        transaction.getMerchantName(),
                        transaction.getMerchantLogo()
                ))
                .collect(Collectors.toList());
    }
}