CREATE TABLE IF NOT EXISTS ORDERS (
   id INT NOT NULL,
   product_name VARCHAR(100) NOT NULL,
   order_date DATE NOT NULL,
   user_id INT NOT NULL,
   PRIMARY KEY (id)
);

DELETE from ORDERS;

INSERT INTO ORDERS (ID, PRODUCT_NAME, ORDER_DATE, USER_ID) VALUES (1, 'Book' , CURRENT_DATE, 1);
INSERT INTO ORDERS (ID, PRODUCT_NAME, ORDER_DATE, USER_ID) VALUES (2, 'Glasses' , CURRENT_DATE, 1);
INSERT INTO ORDERS (ID, PRODUCT_NAME, ORDER_DATE, USER_ID) VALUES (3, 'Table', CURRENT_DATE, 1);