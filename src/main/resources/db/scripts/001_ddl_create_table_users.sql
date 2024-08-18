create table users(
    id serial primary key,
    username varchar(128) unique not null,
    firstname varchar(128) not null,
    lastname varchar(128) not null,
    role varchar(32),
    birth_date date
)