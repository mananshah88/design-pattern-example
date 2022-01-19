use <database1>
create table customer (
    id integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstname text NOT NULL,
    lastname text NOT NULL,
    email text NOT NULL
);
insert into customer (id, firstname, lastname, email ) values 
(1, 'Rohit', 'Gupta', 'sampleemail@google.com'), 
(2, 'Ajay', 'Mishra', 'sampleemailid@google.com');

