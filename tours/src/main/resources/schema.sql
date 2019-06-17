CREATE TABLE If NOT EXISTS SPOTS(
    SPOT_ID INT PRIMARY KEY AUTO_INCREMENT,
    SPOT_NAME VARCHAR(50) NOT NULL,
    SPOT_LAT FLOAT NOT NULL,
    SPOT_LNG FLOAT NOT NULL,
);

CREATE TABLE IF NOT EXISTS USERS (
    user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    encoded_password VARCHAR(255),
    updated_at timestamp not null default current_timestamp,
    created_at timestamp not null default current_timestamp
);
