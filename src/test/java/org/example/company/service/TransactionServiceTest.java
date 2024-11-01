package org.example.company.service;

import org.example.company.dto.transaction.TransactionResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService();
    }

    @Test
    void testFindAllByAccountNumber() {
        Integer accountNumber = 12345;

        List<TransactionResponseDTO> transactions = transactionService.findAllByAccountNumber(accountNumber);

        int expectedTransactionCount = 3;
        assertEquals(expectedTransactionCount, transactions.size(), "Expected 3 transactions but found : " + transactions.size());
    }
}