CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department_name IN VARCHAR2,
  p_bonus_percent   IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_percent / 100)
  WHERE Department = p_department_name;

  DBMS_OUTPUT.PUT_LINE('Bonus applied to department: ' || p_department_name);
  COMMIT;
  
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error applying bonus: ' || SQLERRM);
    ROLLBACK;
END;
/
