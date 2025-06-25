SET SERVEROUTPUT ON;

BEGIN
    FOR customer IN(SELECT customer_id FROM system.customers WHERE balance > 10000) LOOP
        DBMS_OUTPUT.PUT_LINE('Upgrading customer ' || customer.customer_id || 'to VIP status');
        UPDATE system.customers
        SET is_vip = 'Y'
        WHERE customer_id = customer.customer_id;
    END LOOP;

    COMMIT;
END;
/