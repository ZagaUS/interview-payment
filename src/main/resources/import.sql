-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO creditcard (id, name, customer_account_number,  card_number, expiry_date, cvv) VALUES (86, 'Suren', '345674567845678', '2345678934567345', '10/23',566);
INSERT INTO creditcard (id, name, customer_account_number,  card_number, expiry_date, cvv) VALUES (89, 'Rahul', '345678456785677', '54779877443544789','10/25',677);
-- DROP TABLE paymentdetails