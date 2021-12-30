CREATE DATABASE addressbook;

USE addressbook;

CREATE TABLE addressBook (
		firstname varchar(20) NOT NULL, 
        lastname varchar(20) NOT NULL,
        address varchar(100),
        city varchar(20) NOT NULL,
        state varchar(20) NOT NULL,
        zipcode int(6),
        phonenumber varchar(10) NOT NULL UNIQUE,
        email varchar(20) NOT NULL UNIQUE,
        UNIQUE KEY name (firstname,lastname)
);