CREATE TABLE IF NOT EXISTS SPOT0_(
    spot_id INT NOT NULL IDENTITY(1,1),
    spot_name nchar(50) not null,
    spot_lnt float not null,
    spot_lng float not null,
);
