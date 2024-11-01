package org.example.company.controller;

import lombok.AllArgsConstructor;
import org.example.company.dto.transaction.TransactionResponseDTO;
import org.example.company.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<TransactionResponseDTO> findAllByAccountNumber(@PathVariable Integer accountNumber) {
        try {
            TransactionResponseDTO response = (TransactionResponseDTO) transactionService.findAllByAccountNumber(accountNumber);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TransactionResponseDTO());
        }
    }
}
