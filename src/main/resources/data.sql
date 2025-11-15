----------------------------------------------------
-- 1️⃣ CREATE (INSERT records)
----------------------------------------------------

INSERT INTO patients (name, age, disease) VALUES ('Ravi Kumar', 30, 'Fever');
INSERT INTO patients (name, age, disease) VALUES ('Priya Sharma', 25, 'Cold');
INSERT INTO patients (name, age, disease) VALUES ('Anil Rao', 45, 'Diabetes');
INSERT INTO patients (name, age, disease) VALUES ('Meena Patel', 52, 'Hypertension');

----------------------------------------------------
-- 2️⃣ READ (SELECT records)
-- (This will execute but results are not stored; it's only for log visibility)
----------------------------------------------------

SELECT * FROM patients;

----------------------------------------------------
-- 3️⃣ UPDATE (Modify existing records)
----------------------------------------------------

-- Update disease
UPDATE patients SET disease = 'Recovered - Observation' WHERE name = 'Ravi Kumar';

-- Update age
UPDATE patients SET age = 26 WHERE name = 'Priya Sharma';

-- Update disease field
UPDATE patients SET disease = 'Controlled Diabetes' WHERE name = 'Anil Rao';

----------------------------------------------------
-- 4️⃣ DELETE (Soft delete: deleting 1 record)
----------------------------------------------------

DELETE FROM patients WHERE name = 'Meena Patel';

----------------------------------------------------
-- 5️⃣ FINAL READ (To verify final dataset in logs)
----------------------------------------------------

SELECT * FROM patients;
