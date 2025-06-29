SET SERVEROUTPUT ON;

DECLARE
  CURSOR loan_cursor IS
    SELECT LoanID, LoanAmount, InterestRate FROM Loans;

  v_loan_id     Loans.LoanID%TYPE;
  v_amount      Loans.LoanAmount%TYPE;
  v_rate        Loans.InterestRate%TYPE;
BEGIN
  OPEN loan_cursor;
  LOOP
    FETCH loan_cursor INTO v_loan_id, v_amount, v_rate;
    EXIT WHEN loan_cursor%NOTFOUND;

    IF v_amount < 100000 THEN
      UPDATE Loans
      SET InterestRate = v_rate + 1
      WHERE LoanID = v_loan_id;
      DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan_id || ': Interest rate increased to ' || (v_rate + 1));
      
    ELSIF v_amount > 500000 THEN
      UPDATE Loans
      SET InterestRate = v_rate - 0.5
      WHERE LoanID = v_loan_id;
      DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan_id || ': Interest rate reduced to ' || (v_rate - 0.5));
      
    ELSE
      DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan_id || ': No change to interest rate.');
    END IF;
  END LOOP;
  CLOSE loan_cursor;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Loan interest rate updates completed.');
END;
/
