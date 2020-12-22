USE my_db;

CREATE TABLE products (
  id int,
  product_name varchar(100),
  company_name varchar(100),
  description varchar(999),
  price_usd int,
  PRIMARY KEY (id)
) ;

INSERT INTO my_db.products (id, product_name, company_name, description, price_usd)
VALUES
	(1, 'Windows 10', 'Microsoft', 'OS for personal or business use', 140),
	(2, 'MS Office 2019', 'Microsoft', 'Office software package: MS Word, MS Excel, MS Powerpoint and others', 100),
	(3, 'IntelliJ IDEA Ultimate', 'JET BRAINS', 'Integrated software development environment for programming languages', 500),
    (4, 'Adobe Photoshop', 'Adobe', 'Photo and design editor', 21);
