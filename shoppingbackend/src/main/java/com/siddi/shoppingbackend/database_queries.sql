 create table category(
	id int auto_increment,
    name varchar(50),
    description varchar(255),
    image_url varchar(255),
    is_active boolean,
    
    primary key(id)
 );
 
 CREATE TABLE user_detail (
	id int auto_increment,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	PRIMARY KEY(id)
);

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Lionel', 'Messi', 'ADMIN', true, 'admin', 'LM10@gmail.com', '1010101010');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Cristiano', 'Ronaldo', 'SUPPLIER', true, '12345', 'CR7@gmail.com', '7777777777');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Neymar', 'Jr', 'SUPPLIER', true, '12345', 'N10@gmail.com', '1111111111');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Siddi Avinash', 'Chenmilla', 'USER', true, '12345', 'S10@gmail.com', '1234567890');

CREATE TABLE product (
	id int auto_increment,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	PRIMARY KEY (id),
 	FOREIGN KEY (category_id) REFERENCES category (id),
	FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone X', 'apple', 'This is one of the best phone available in the market right now!', 1000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s10', 'samsung', 'A smart phone by samsung!', 1000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 800, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 2000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude', 'dell', 'This is one of the best laptop series from dell that can be used!', 1000, 5, true, 1, 3, 0, 0 );

