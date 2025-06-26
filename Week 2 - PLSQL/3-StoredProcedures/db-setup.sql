BEGIN EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS'; 
    EXCEPTION WHEN OTHERS THEN NULL; 
END;
/

BEGIN EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS'; 
    EXCEPTION WHEN OTHERS THEN NULL; 
END;
/

CREATE TABLE accounts (
  account_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  account_type VARCHAR2(20), 
  balance NUMBER(10, 2)
);

CREATE TABLE employees (
  emp_id NUMBER PRIMARY KEY,
  emp_name VARCHAR2(100),
  department_id NUMBER,
  salary NUMBER(10, 2)
);

INSERT INTO accounts (account_id, customer_id, account_type, balance) VALUES (1, 101, 'savings', 10000);
INSERT INTO accounts (account_id, customer_id, account_type, balance) VALUES (2, 101, 'checking', 5000);
INSERT INTO accounts (account_id, customer_id, account_type, balance) VALUES (3, 102, 'savings', 8000);
INSERT INTO accounts (account_id, customer_id, account_type, balance) VALUES (4, 103, 'savings', 3000);

INSERT INTO employees (emp_id, emp_name, department_id, salary) VALUES (201, 'Aysha Ahmed', 10, 50000);
INSERT INTO employees (emp_id, emp_name, department_id, salary) VALUES (202, 'John Doe', 10, 48000);
INSERT INTO employees (emp_id, emp_name, department_id, salary) VALUES (203, 'Sara Khan', 20, 52000);
INSERT INTO employees (emp_id, emp_name, department_id, salary) VALUES (204, 'Liam Patel', 20, 47000);

COMMIT;

