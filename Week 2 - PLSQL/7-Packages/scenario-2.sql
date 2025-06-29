CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_emp_id     IN NUMBER,
    p_name       IN VARCHAR2,
    p_position   IN VARCHAR2,
    p_salary     IN NUMBER,
    p_department IN VARCHAR2,
    p_hire_date  IN DATE
  );

  PROCEDURE UpdateEmployee(
    p_emp_id     IN NUMBER,
    p_name       IN VARCHAR2,
    p_position   IN VARCHAR2,
    p_department IN VARCHAR2
  );

  FUNCTION GetAnnualSalary(
    p_emp_id IN NUMBER
  ) RETURN NUMBER;
END EmployeeManagement;
/


CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee(
    p_emp_id     IN NUMBER,
    p_name       IN VARCHAR2,
    p_position   IN VARCHAR2,
    p_salary     IN NUMBER,
    p_department IN VARCHAR2,
    p_hire_date  IN DATE
  ) IS
  BEGIN
    INSERT INTO Employees (
      EmployeeID, Name, Position, Salary, Department, HireDate
    )
    VALUES (
      p_emp_id, p_name, p_position, p_salary, p_department, p_hire_date
    );

    DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Error: Employee ID already exists.');
  END HireEmployee;

  PROCEDURE UpdateEmployee(
    p_emp_id     IN NUMBER,
    p_name       IN VARCHAR2,
    p_position   IN VARCHAR2,
    p_department IN VARCHAR2
  ) IS
  BEGIN
    UPDATE Employees
    SET Name = p_name,
        Position = p_position,
        Department = p_department
    WHERE EmployeeID = p_emp_id;

    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No employee found with ID: ' || p_emp_id);
    ELSE
      DBMS_OUTPUT.PUT_LINE('Employee updated: ' || p_emp_id);
    END IF;
  END UpdateEmployee;

  FUNCTION GetAnnualSalary(
    p_emp_id IN NUMBER
  ) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary
    FROM Employees
    WHERE EmployeeID = p_emp_id;

    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END GetAnnualSalary;

END EmployeeManagement;
/

