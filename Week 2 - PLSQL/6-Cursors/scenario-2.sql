SET SERVEROUTPUT ON;

DECLARE
  CURSOR account_cursor IS
    SELECT AccountID, Balance FROM Accounts;

  v_account_id Accounts.AccountID%TYPE;
  v_balance    Accounts.Balance%TYPE;
  v_fee        NUMBER := 500;  -- Annual fee amount
BEGIN
  OPEN account_cursor;
  LOOP
    FETCH account_cursor INTO v_account_id, v_balance;
    EXIT WHEN account_cursor%NOTFOUND;

    IF v_balance >= v_fee THEN
      UPDATE Accounts
      SET Balance = Balance - v_fee,
          LastModified = SYSDATE
      WHERE AccountID = v_account_id;

      DBMS_OUTPUT.PUT_LINE('Fee of Rs.' || v_fee || ' applied to Account ID: ' || v_account_id);
    ELSE
      DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id || ' skipped due to insufficient balance.');
    END IF;
  END LOOP;
  CLOSE account_cursor;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Annual fee processing completed.');
END;
/
