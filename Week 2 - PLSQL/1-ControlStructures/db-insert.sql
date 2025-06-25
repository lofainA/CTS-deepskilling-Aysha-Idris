-- Customers
INSERT INTO customers (name, age, balance) VALUES ('Chris Evans', 68, 12000);
INSERT INTO customers (name, age, balance) VALUES ('Mackenzie Smith', 54, 9000);
INSERT INTO customers (name, age, balance) VALUES ('Bob Ross', 92, 15000);

-- Loans
INSERT INTO loans (customer_id, interest_rate, due_date) VALUES (1, 7.5, SYSDATE + 15);
INSERT INTO loans (customer_id, interest_rate, due_date) VALUES (2, 8.0, SYSDATE + 43);
INSERT INTO loans (customer_id, interest_rate, due_date) VALUES (3, 9.2, SYSDATE + 7);

COMMIT;
