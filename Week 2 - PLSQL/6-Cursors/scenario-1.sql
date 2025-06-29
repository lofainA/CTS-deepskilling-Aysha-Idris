SET SERVEROUTPUT ON;

DECLARE
  CURSOR txn_cursor IS
    SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
    FROM Customers c
    JOIN Accounts a ON c.CustomerID = a.CustomerID
    JOIN Transactions t ON a.AccountID = t.AccountID
    WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
    ORDER BY c.CustomerID, t.TransactionDate;

  v_customer_id     Customers.CustomerID%TYPE;
  v_name            Customers.Name%TYPE;
  v_transaction_id  Transactions.TransactionID%TYPE;
  v_date            Transactions.TransactionDate%TYPE;
  v_amount          Transactions.Amount%TYPE;
  v_type            Transactions.TransactionType%TYPE;
  v_current_cust    NUMBER := NULL;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Monthly Statement ---');

  OPEN txn_cursor;
  LOOP
    FETCH txn_cursor INTO v_customer_id, v_name, v_transaction_id, v_date, v_amount, v_type;
    EXIT WHEN txn_cursor%NOTFOUND;

    IF v_current_cust IS NULL OR v_current_cust != v_customer_id THEN
      DBMS_OUTPUT.PUT_LINE(CHR(10) || 'Customer: ' || v_name || ' (ID: ' || v_customer_id || ')');
      v_current_cust := v_customer_id;
    END IF;

    DBMS_OUTPUT.PUT_LINE('  -> [' || TO_CHAR(v_date, 'DD-MON-YYYY') || '] '
                         || v_type || ' Rs.' || v_amount
                         || ' (Transaction ID: ' || v_transaction_id || ')');
  END LOOP;
  CLOSE txn_cursor;
END;
/
