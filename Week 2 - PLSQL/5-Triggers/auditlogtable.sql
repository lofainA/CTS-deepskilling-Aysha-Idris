CREATE TABLE AuditLog (
  LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  TransactionID NUMBER,
  AccountID NUMBER,
  TransactionDate DATE,
  Amount NUMBER,
  TransactionType VARCHAR2(10),
  LoggedAt DATE
);
