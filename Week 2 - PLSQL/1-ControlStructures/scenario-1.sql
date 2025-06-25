SET SERVEROUTPUT ON;

BEGIN
    FOR customer IN (SELECT customer_id FROM system.customers WHERE age > 60) LOOP
        DBMS_OUTPUT.PUT_LINE('Updating interest rate for customer ID: ' || customer.customer_id);
        UPDATE system.loans
        SET interest_rate = interest_rate - 1.0
        WHERE customer_id = customer.customer_id;
    END LOOP;

    COMMIT;
END;
/