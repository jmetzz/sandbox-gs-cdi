CREATE TABLE BOOK (ID BIGINT NOT NULL, DESCRIPTION VARCHAR(255), ISBN VARCHAR(255), NBOFPAGE INTEGER, PRICE FLOAT, TITLE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(15), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
