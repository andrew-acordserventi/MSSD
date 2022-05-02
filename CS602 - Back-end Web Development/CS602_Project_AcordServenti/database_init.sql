-- initial SQL database to import

-- create the tables
CREATE TABLE sellable_products (
  UPC           VARCHAR(30)    NOT NULL,
  productName   VARCHAR(255)   NOT NULL,
  productDescription   VARCHAR(255)   NOT NULL,
  size          VARCHAR(255)   NOT NULL,
  price         DECIMAL(10,2)   NOT NULL,
  stockQuantity INT(255)       NOT NULL,
  PRIMARY KEY (UPC)
);

CREATE TABLE customer_orders (
  orderNumber   INT(11)        NOT NULL AUTO_INCREMENT,
  UPC           VARCHAR(30)    NOT NULL,
  quantity      INT(11)        NOT NULL,
  orderPrice    DECIMAL(10,2)   NOT NULL,
  dateOrdered   VARCHAR(255)   NOT NULL,
  PRIMARY KEY (orderNumber)
);

CREATE TABLE admin_login (
  username      VARCHAR(255)   NOT NULL,
  admin_pass    VARCHAR(255)   NOT NULL,
  PRIMARY KEY (username)
);


-- insert data into the database
INSERT INTO sellable_products VALUES
('1', 'Metformin', 'Metformin 500mg', '500mg', 0.08, 5000),
('2', 'Atorvastatin', 'Atorvastatin 40mg', '40mg', 0.12, 6000),
('3', 'Levothyroxine', 'Levothyroxine 50mcg', '50mcg', 0.25, 4000),
('4', 'Lisinopril', 'Lisinopril 20mg', '20mg', 0.08, 7000);


INSERT INTO customer_orders VALUES
(1, '2', 60, 7.2, '2/21/2022'),
(2, '4', 30, 2.4, '2/18/2022'),
(3, '1', 45, 3.6, '2/18/2022');

INSERT INTO admin_login VALUES
('admin', 'password');