-- Drop table if exists (idempotent for H2)
DROP TABLE IF EXISTS patient;

-- Create Table
CREATE TABLE patient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    diagnosis VARCHAR(200)
);

-- ============================
-- INSERT (Create)
-- ============================

INSERT INTO patient (name, age, diagnosis) VALUES
('John Doe', 30, 'Flu'),
('Alice Smith', 25, 'Allergy'),
('Robert Brown', 40, 'Diabetes'),
('Emily Clark', 32, 'Migraine');

-- ============================
-- READ (Select)
-- ============================

-- Get all patients
SELECT * FROM patient;

-- Get patient by ID
SELECT * FROM patient WHERE id = 1;

-- Get patients older than 30
SELECT * FROM patient WHERE age > 30;

-- ============================
-- UPDATE
-- ============================

-- Update patient diagnosis
UPDATE patient
SET diagnosis = 'Recovered'
WHERE id = 1;

-- Update patient age
UPDATE patient
SET age = 29
WHERE name = 'Alice Smith';

-- ============================
-- DELETE
-- ============================

-- Delete a specific patient
DELETE FROM patient WHERE id = 3;

-- Delete based on condition
DELETE FROM patient WHERE age < 27;


-- ============================
-- FINAL DATA CHECK
-- ============================
SELECT * FROM patient;
