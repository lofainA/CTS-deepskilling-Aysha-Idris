CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(
    p_account_id   IN NUMBER,
    p_customer_id  IN NUMBER,
    p_account_type IN VARCHAR2,
    p_balance      IN NUMBER
  );

  PROCEDURE CloseAccount(
    p_account_id IN NUMBER
  );

  FUNCTION GetTotalBalance(
    p_customer_id IN NUMBER
  ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount(
    p_account_id   IN NUMBER,
    p_customer_id  IN NUMBER,
    p_account_type IN VARCHAR2,
    p_balance      IN NUMBER
  ) IS
  BEGIN
    INSERT INTO Accounts (
      AccountID, CustomerID, AccountType, Balance, LastModified
    )
    VALUES (
      p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE
    );

    DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_account_id);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Error: Account ID already exists.');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
  END OpenAccount;

  PROCEDURE CloseAccount(
    p_account_id IN NUMBER
  ) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_account_id;

    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No account found with ID: ' || p_account_id);
    ELSE
      DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_account_id);
    END IF;
  END CloseAccount;

  FUNCTION GetTotalBalance(
    p_customer_id IN NUMBER
  ) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT NVL(SUM(Balance), 0)
    INTO v_total
    FROM Accounts
    WHERE CustomerID = p_customer_id;

    RETURN v_total;
  END GetTotalBalance;

END AccountOperations;
/
