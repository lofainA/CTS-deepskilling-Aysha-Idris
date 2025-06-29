CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
 
  IF :NEW.TransactionType = 'CREDIT' AND :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Deposit amount must be positive.');
  END IF;

  IF :NEW.TransactionType = 'DEBIT' THEN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;

    IF :NEW.Amount > v_balance THEN
      RAISE_APPLICATION_ERROR(-20002, 'Insufficient balance for withdrawal.');
    END IF;
  END IF;
END;
/
