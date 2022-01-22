CREATE TABLE item (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(200) NOT NULL,
    finished TINYINT DEFAULT 0,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)