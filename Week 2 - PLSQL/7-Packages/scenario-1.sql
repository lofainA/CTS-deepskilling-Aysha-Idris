CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE,
    p_balance     IN NUMBER
  );

  PROCEDURE UpdateCustomer(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE
  );

  FUNCTION GetCustomerBalance(
    p_customer_id IN NUMBER
  ) RETURN NUMBER;
END CustomerManagement;
/


CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

  PROCEDURE AddCustomer(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE,
    p_balance     IN NUMBER
  ) IS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
  END AddCustomer;

  PROCEDURE UpdateCustomer(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE
  ) IS
  BEGIN
    UPDATE Customers
    SET Name = p_name,
        DOB = p_dob,
        LastModified = SYSDATE
    WHERE CustomerID = p_customer_id;

    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No customer found with ID: ' || p_customer_id);
    ELSE
      DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_customer_id);
    END IF;
  END UpdateCustomer;

  FUNCTION GetCustomerBalance(
    p_customer_id IN NUMBER
  ) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance
    FROM Customers
    WHERE CustomerID = p_customer_id;

    RETURN v_balance;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END GetCustomerBalance;

END CustomerManagement;
/
