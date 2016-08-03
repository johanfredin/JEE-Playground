DROP DATABASE `playground`;
DROP DATABASE `playground-test`;
CREATE SCHEMA `playground`;
CREATE SCHEMA `playground-test`;

select * from playground.PERSON where FIRST_NAME like 'J%';

select * from playground.PERSON;