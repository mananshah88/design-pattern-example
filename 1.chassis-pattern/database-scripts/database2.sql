use <database2>
create table purchase (
    id integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerId integer NOT NULL,
    itemId integer NOT NULL,
    quantity integer NOT NULL,
    amount double NOT NULL
);
insert into purchase (id, customerId, itemId, quantity, amount ) values 
(1, 1, '61e42350813d19dc9f7842fc', 5, 50), 
(2, 2, '61e42367813d19dc9f784308', 5, 75),
(3, 1, '61e42350813d19dc9f7842fc', 10, 500);

