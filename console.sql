create database session06;
use session06;

create table Books(
    id int primary key auto_increment,
    title varchar(100) not null,
    author varchar(50) ,
    category varchar(255) not null,
    quantity int check ( quantity > 0 )
);

create table User(
    id int primary key auto_increment,
    username varchar(100) not null,
    password varchar(255) not null,
    email varchar(255),
    phone char(10)
);

DELIMITER //
create procedure fildAllBook()
begin
    select * from Books;
end //
DELIMITER ;

DELIMITER //
create procedure addNewBook(
    title_in varchar(100),
    auther_in varchar(50),
    category_in varchar(255),
    quantity_in int
)
begin
    insert into Books (title, author, category, quantity)
    values (title_in,auther_in,category_in,quantity_in);
end //
DELIMITER ;

DELIMITER //
create procedure findById(
    id_in int
)
begin
    select * from Books where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure updateBook(
    id_in int,
    title_in varchar(100),
    auther_in varchar(50),
    category_in varchar(255),
    quantity_in int
)
begin
    update Books
        set title = title_in,
            author = auther_in,
            category = category_in,
            quantity = quantity_in
    where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure deleteBook(id_in int)
begin
    delete from Books where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure registerUser(
    username_in varchar(100),
    password_in varchar(255),
    email_in varchar(255),
    phone_in char(10)
)
begin
    insert into User(username, password, email, phone)
        values (username_in,password_in,email_in,phone_in);
end //
DELIMITER ;

DELIMITER //
create procedure loginUser(
    username_in varchar(100),
    password_in varchar(255)
)
begin
    select * from User where username = username_in and password = password_in;
end //
DELIMITER ;