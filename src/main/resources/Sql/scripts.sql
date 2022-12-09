create database Agriculture;
use Agriculture;

CREATE TABLE `farmers` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(255) NOT NULL,
`phone` VARCHAR(255) NOT NULL,
`address` VARCHAR(255) NOT NULL,
`email` VARCHAR(255) NOT NULL,
`product` VARCHAR(255) NOT NULL,
`pwd` VARCHAR(500) NOT NULL,
PRIMARY KEY (`id`));
  
INSERT INTO `farmers` (`username`, `phone`, `address` ,`email`, `product` ,`pwd`)
 VALUES ('Pavani','1234567890','Hyderabad','pavani@gmail.com', 'Corn', '12345');

CREATE TABLE `authorities` (`id` int NOT NULL AUTO_INCREMENT,`farmer_id` int NOT NULL,
`name` varchar(50) NOT NULL,PRIMARY KEY (`id`),
FOREIGN KEY (`farmer_id`) REFERENCES `farmers` (`id`)
 
INSERT INTO `authorities` (`farmer_id`, `name`) 
values (3, 'ViewAccount');

select * from authorities;