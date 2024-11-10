CREATE TABLE IF NOT EXISTS transactions
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    type             VARCHAR(10),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    account_number   VARCHAR(20),
    currency         VARCHAR(10),
    amount           DECIMAL(10, 2),
    merchant_name    VARCHAR(100),
    merchant_logo    VARCHAR(255)
) ENGINE = InnoDB;

INSERT INTO transactions (type, transaction_date, account_number, currency, amount, merchant_name, merchant_logo)
VALUES ('debit', NOW(), '1234567', 'EUR', 100.00, 'Acme Ltd.', 'images/acme.png');

INSERT INTO transactions (type, transaction_date, account_number, currency, amount, merchant_name, merchant_logo)
VALUES ('debit', NOW(), '1234567', 'EUR', 5.00, 'Caffeinenation Inc', 'images/caffeinenation.png');

