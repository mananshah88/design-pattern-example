use <database1>
create table customer (
    id integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstname text NOT NULL,
    lastname text NOT NULL,
    email text NOT NULL
);
insert into customer (firstname, lastname, email ) values ('Rohit', 'Gupta', 'sampleemail@google.com'), ('Ajay', 'Mishra', 'sampleemailid@google.com');

use <database2>
create table purchase (
    id integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customerId integer NOT NULL,
    itemId integer NOT NULL,
    quantity integer NOT NULL,
    amount double NOT NULL
);
insert into purchase (customerId, itemId, quantity, amount ) values (1, '61e42350813d19dc9f7842fc', 5, 50), (2, '61e42367813d19dc9f784308', 5, 75);

db.development_log.feedback.insertMany( [
	{"detail" : "Good Mobile"},
	{"detail" : "Nice TV" }
] );

