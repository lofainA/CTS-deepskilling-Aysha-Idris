BEGIN EXECUTE IMMEDIATE 'DROP TABLE accounts'; 
EXCEPTION WHEN OTHERS THEN NULL; 
END;
/

CREATE TABLE accounts (
  account_id NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER(10, 2)
);

INSERT INTO accounts VALUES (1, 'Samuel Jackson', 50000);
INSERT INTO accounts VALUES (2, 'Emma Watson', 37000);
COMMIT;
