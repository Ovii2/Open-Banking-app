package org.example.company.dto.transaction;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {

    private String merchantName;

    @NotEmpty(message = "Account number cannot be empty")
    private Integer accountNumber;

    public TransactionRequestDTO(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }
}
