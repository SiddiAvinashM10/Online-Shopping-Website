 create table category(
	id int auto_increment,
    name varchar(50),
    description varchar(255),
    image_url varchar(255),
    is_active boolean,
    
    primary key(id)
 );