INSERT INTO coordinates (id, latitude, longitude) VALUES
(1, 48.8566, 2.3522),   -- Paris
(2, 43.2965, 5.3698),   -- Marseille
(3, 45.7640, 4.8357),   -- Lyon
(4, 43.6047, 1.4442),   -- Toulouse
(5, 43.7102, 7.2620),   -- Nice
(6, 47.2184, -1.5536),  -- Nantes
(7, 48.5734, 7.7521),   -- Strasbourg
(8, 43.6119, 3.8777),   -- Montpellier
(9, 44.8378, -0.5792),  -- Bordeaux
(10, 50.6292, 3.0573)   -- Lille
ON CONFLICT (id) DO NOTHING;

UPDATE cities
SET coordinates_id = id
WHERE coordinates_id IS NULL;