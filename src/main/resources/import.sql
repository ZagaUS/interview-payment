-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- INSERT INTO creditcard (id, name, customer_account_number,  card_number, expiry_date, cvv) VALUES (96, 'Surendhar', '12345674567845678', '122345678934567345', '10/23',566);
INSERT INTO upi (id, name, customer_account_number, upi_id) VALUES (1, 'Suren', '67345678456785677', 'suren@icici');
-- DROP TABLE paymentdetails