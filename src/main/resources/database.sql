-- Table: user
CREATE TABLE user
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
)
    ENGINE = InnoDB;

-- Table: role
CREATE TABLE role
(
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)
    ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (role_id) REFERENCES role (id),

    UNIQUE (user_id, role_id)
)
    ENGINE = InnoDB;

-- Insert data

INSERT INTO user
VALUES (1, 'alex', '123');
INSERT INTO user
VALUES (2, 'victor', '456');

INSERT INTO role
VALUES (1, 'ADMIN');
INSERT INTO role
VALUES (2, 'USER');

INSERT INTO user_roles
VALUES (1, 1);
INSERT INTO user_roles
VALUES (2, 2);