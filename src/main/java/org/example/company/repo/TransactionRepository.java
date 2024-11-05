package org.example.company.repo;

import org.example.company.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findAllByAccountNumber(Integer accountNumber);
}
