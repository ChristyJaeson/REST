CREATE USER 'airdb'@'localhost' IDENTIFIED BY 'test';

GRANT ALL PRIVILEGES ON airdb.* TO 'airdb'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'airdb'@'localhost';