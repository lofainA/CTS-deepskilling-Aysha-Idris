SET SERVEROUTPUT ON;

BEGIN
    FOR customer IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
        DBMS_OUTPUT.PUT_LINE('Upgrading customer ' || customer.CustomerID || ' to VIP status');
        UPDATE Customers
        SET LastModified = SYSDATE
        WHERE CustomerID = customer.CustomerID;
    END LOOP;

    COMMIT;
END;
/
