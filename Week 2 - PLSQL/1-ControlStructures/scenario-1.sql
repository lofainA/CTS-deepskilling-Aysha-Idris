SET SERVEROUTPUT ON;

BEGIN
    FOR customer IN (SELECT CustomerID FROM Customers WHERE MONTHS_BETWEEN(SYSDATE, DOB) / 12 > 60) LOOP
        DBMS_OUTPUT.PUT_LINE('Updating interest rate for customer ID: ' || customer.CustomerID);

        UPDATE Loans
        SET InterestRate = InterestRate - 1.0
        WHERE CustomerID = customer.CustomerID;
    END LOOP;

    COMMIT;
END;
/
