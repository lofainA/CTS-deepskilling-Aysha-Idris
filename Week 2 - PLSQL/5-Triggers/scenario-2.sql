CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (
    TransactionID,
    AccountID,
    TransactionDate,
    Amount,
    TransactionType,
    LoggedAt
  ) VALUES (
    :NEW.TransactionID,
    :NEW.AccountID,
    :NEW.TransactionDate,
    :NEW.Amount,
    :NEW.TransactionType,
    SYSDATE
  );
END;
/
