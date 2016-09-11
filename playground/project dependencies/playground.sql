DROP DATABASE `playground`;
DROP DATABASE `playground-test`;
CREATE SCHEMA `playground`;
CREATE SCHEMA `playground-test`;

select * from playground.PERSON where FIRST_NAME like 'J%';

select * from PERSON;

select FIRST_NAME from playground.PERSON where FIRST_NAME like 'J%';

select * from playground.PERSON;

insert into PERSON(PERSON_ID, EMAIL, FIRST_NAME, LAST_NAME, PHONE_NR) values(1, "johanfredin205@gmail.com", "Klas", "Månsson", "0761253033");

insert into PERSON(PERSON_ID, EMAIL, FIRST_NAME, LAST_NAME, PHONE_NR) values(2, "johanfredin205@gmail.com", "Klas", "Månsson", "0761253033");

