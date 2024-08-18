create table users(
    id serial primary key,
    username varchar(128) unique not null,
    firstname varchar(128) not null,
    lastname varchar(128) not null,
    birth_date date,
    age int
)