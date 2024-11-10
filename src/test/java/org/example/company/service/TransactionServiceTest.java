package org.example.company.service;

import org.example.company.OpenBankingAppApplication;
import org.example.company.dto.transaction.TransactionResponseDTO;
import org.example.company.model.Transaction;
import org.example.company.repo.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OpenBankingAppApplication.class)
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    private final int accountNumber = 12345;

    @BeforeEach
    void setUp() {
        transactionRepository.deleteAll();

        Transaction transaction = new Transaction();
        transaction.setAccountNumber(accountNumber);
        transaction.setType("Debit");
        transaction.setDate(LocalDate.now());
        transaction.setCurrency("USD");
        transaction.setAmount(100.0);
        transaction.setMerchantName("Amazon");
        transaction.setMerchantLogo("amazon_logo.png");

        transactionRepository.save(transaction);
    }

    @Test
    public void testTransactionCountAndMapping() {
        assertNotNull(transactionService);
        assertNotNull(transactionRepository);

        List<TransactionResponseDTO> transactions = transactionService.findAllByAccountNumber(accountNumber);

        assertEquals(1, transactions.size());

        TransactionResponseDTO transactionDTO = transactions.getFirst();
        assertEquals("Debit", transactionDTO.getType());
        assertEquals("USD", transactionDTO.getCurrency());
        assertEquals(100.0, transactionDTO.getAmount());
        assertEquals("Amazon", transactionDTO.getMerchantName());
        assertEquals("amazon_logo.png", transactionDTO.getMerchantLogo());
    }
}