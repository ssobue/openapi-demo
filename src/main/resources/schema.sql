-- Department Table
CREATE TABLE IF NOT EXISTS department
(
    id         INTEGER AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100)                        NOT NULL,
    updated_by VARCHAR(100)                        NOT NULL,
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted    TINYINT(1) DEFAULT '0' NOT NULL
);

-- Employee Table
CREATE TABLE IF NOT EXISTS employee
(
    id            INTEGER AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(100)                        NOT NULL,
    email         VARCHAR(300) UNIQUE                 NOT NULL,
    department_id INTEGER                             NOT NULL,
    updated_by    VARCHAR(100)                        NOT NULL,
    updated_on    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted       TINYINT(1) DEFAULT '0' NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (id)
);
