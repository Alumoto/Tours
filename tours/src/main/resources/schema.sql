CREATE TABLE If NOT EXISTS SPOTS(
    SPOT_ID INT PRIMARY KEY,
    SPOT_NAME VARCHAR(50) NOT NULL,
    SPOT_LAT FLOAT NOT NULL,
    SPOT_LNG FLOAT NOT NULL,    
);

CREATE TABLE If NOT EXISTS TOURS(
    TOUR_ID INT PRIMARY KEY,
    TOUR_NAME VARCHAR(50) NOT NULL,
);

CREATE TABLE If NOT EXISTS USERS (
    USERNAME VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY,
    ENCODED_PASSWORD VARCHAR_IGNORECASE(255) NOT NULL,
    ENABLED  BOOLEAN NOT NULL
);

CREATE TABLE If NOT EXISTS AUTHORITIES (
    USERNAME  VARCHAR_IGNORECASE(50) NOT NULL,
    AUTHORITY VARCHAR_IGNORECASE(50) NOT NULL,
    CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME),
    CONSTRAINT UK_AUTHORITIES UNIQUE (USERNAME, AUTHORITY)
);


create table If NOT EXISTS UserConnection (userId varchar(255) not null,
	providerId varchar(255) not null,
	providerUserId varchar(255),
	rank int not null,
	displayName varchar(255),
	profileUrl varchar(512),
	imageUrl varchar(512),
	accessToken varchar(512) not null,
	secret varchar(512),
	refreshToken varchar(512),
	expireTime bigint,
	primary key (userId, providerId, providerUserId));

create unique index  if not exists UserConnectionRank on UserConnection(userId, providerId, rank);