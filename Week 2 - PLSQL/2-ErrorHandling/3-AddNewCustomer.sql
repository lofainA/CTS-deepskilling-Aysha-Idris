CREATE OR REPLACE PROCEDURE AddNewCustomer (
  p_customer_id IN NUMBER,
  p_name        IN VARCHAR2,
  p_age         IN NUMBER,
  p_balance     IN NUMBER,
  p_is_vip      IN CHAR
) AS
BEGIN
  INSERT INTO customers (customer_id, name, age, balance, is_vip)
  VALUES (p_customer_id, p_name, p_age, p_balance, p_is_vip);

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Customer added successfully: ' || p_name);
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
    ROLLBACK;
END;
/
