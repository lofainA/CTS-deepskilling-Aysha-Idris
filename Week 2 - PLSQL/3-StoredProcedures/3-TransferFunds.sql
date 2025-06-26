CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) AS
  v_balance NUMBER;
BEGIN
  -- Check balance
  SELECT balance INTO v_balance FROM accounts WHERE account_id = p_from_account;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
  END IF;

  -- Perform transfer
  UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_from_account;
  UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_to_account;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transferred ₹' || p_amount || ' from account ' || p_from_account || ' to ' || p_to_account);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
    ROLLBACK;
END;
/
