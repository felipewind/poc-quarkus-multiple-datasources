CREATE TABLE IF NOT EXISTS USERS (
   id INT NOT NULL,
   name VARCHAR(100) NOT NULL,
   birth_date DATE NOT NULL,
   PRIMARY KEY (id)
);

DELETE from USERS;

INSERT INTO USERS (ID, NAME, BIRTH_DATE) VALUES (1, 'John' , CURRENT_DATE);
INSERT INTO USERS (ID, NAME, BIRTH_DATE) VALUES (2, 'Felipe' , CURRENT_DATE);
INSERT INTO USERS (ID, NAME, BIRTH_DATE) VALUES (3, 'Robert', CURRENT_DATE);