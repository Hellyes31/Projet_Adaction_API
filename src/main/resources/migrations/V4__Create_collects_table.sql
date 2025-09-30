CREATE TABLE IF NOT EXISTS collects (
    id BIGSERIAL PRIMARY KEY,
    date DATE NOT NULL,
    city VARCHAR(255) NOT NULL,
    glass_nb INT NOT NULL,
    butt_nb INT NOT NULL,
    plastic_nb INT NOT NULL,
    electronics_nb INT NOT NULL,
    others_nb INT NOT NULL,
    volunteer_id INT NOT NULL
);