package org.example.company.service;


import org.example.company.repo.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService transactionService;
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService(transactionRepository);
    }

    @Test
    public void testTransactionCount() {
        int accountNumber = 12345;

        assertEquals(1, transactionService.findAllByAccountNumber(accountNumber).size());
    }
}