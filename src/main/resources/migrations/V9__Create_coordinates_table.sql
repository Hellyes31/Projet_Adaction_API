CREATE TABLE IF NOT EXISTS coordinates (
    id BIGSERIAL PRIMARY KEY,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL
);