CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (SELECT account_id, balance FROM accounts WHERE account_type = 'savings') LOOP
    UPDATE accounts
    SET balance = acc.balance + (acc.balance * 0.01)
    WHERE account_id = acc.account_id;

    DBMS_OUTPUT.PUT_LINE('Interest applied to account ID: ' || acc.account_id);
  END LOOP;

  COMMIT;
END;
/
