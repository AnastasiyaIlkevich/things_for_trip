-- -- Table: users
-- CREATE TABLE users
-- (
--     id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name     VARCHAR(255) NOT NULL,
--     password VARCHAR(500) NOT NULL,
--     email    VARCHAR(500) NOT NULL
-- )
--     ENGINE = InnoDB;
--
-- -- Table: roles
-- CREATE TABLE roles
-- (
--     id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255) NOT NULL
-- )
--     ENGINE = InnoDB;
--
-- -- Table user and roles (mapping): user_roles
-- CREATE TABLE user_roles
-- (
--     user_id INT NOT NULL,
--     role_id INT NOT NULL,
--
--     FOREIGN KEY (user_id) REFERENCES users (id),
--     FOREIGN KEY (role_id) REFERENCES roles (id),
--
--     UNIQUE (user_id, role_id)
-- )
--     ENGINE = InnoDB;


-- add data to tables

# INSERT INTO users
# VALUES (1, 'sirini@gmail.com','sirini' ,'$2a$10$ieLMl5jPYTNLoDvGwqJZie.vWVu5qX8thVp63aD/Ouj2ENLBaKeOS' );

# INSERT INTO roles
# VALUES (1, 'ROLE_USER');
# INSERT INTO roles
# VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles
VALUES (1, 2);