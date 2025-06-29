CREATE OR REPLACE PROCEDURE UpdateSalary (
  p_emp_id IN NUMBER,
  p_percent IN NUMBER
) AS
  v_old_salary NUMBER;
BEGIN
  SELECT Salary INTO v_old_salary FROM Employees WHERE EmployeeID = p_emp_id;

  UPDATE Employees
  SET Salary = v_old_salary + (v_old_salary * p_percent / 100)
  WHERE EmployeeID = p_emp_id;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Salary updated successfully for employee ID ' || p_emp_id);
  
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' does not exist.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/
