create table if not exists authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country varchar(255) not null
);

create table if not exists books(
    id INT AUTO_INCREMENT primary key,
    title varchar(255) not null,
    author_id int not null,
    price decimal(10,2),
    foreign key (author_id) references authors(id) on delete cascade

);

create table if not exists orders(
    id INT AUTO_INCREMENT primary key,
    book_id int not null,
    quantity int not null,
    order_date timestamp default current_timestamp,
    foreign key (book_id) references books(id) on delete cascade

);

