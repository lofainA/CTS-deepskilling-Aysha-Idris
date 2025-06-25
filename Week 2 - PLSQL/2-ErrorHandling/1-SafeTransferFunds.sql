CREATE OR REPLACE PROCEDURE SafeTransferFunds (
  from_id IN NUMBER,
  to_id IN NUMBER,
  amount IN NUMBER
) AS
  insufficient_funds EXCEPTION;
  v_balance NUMBER;
BEGIN
  SELECT balance INTO v_balance FROM accounts WHERE account_id = from_id;

  IF v_balance < amount THEN
    RAISE insufficient_funds;
  END IF;

  UPDATE accounts
  SET balance = balance - amount
  WHERE account_id = from_id;

  UPDATE accounts
  SET balance = balance + amount
  WHERE account_id = to_id;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transfer successful.');
EXCEPTION
  WHEN insufficient_funds THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
