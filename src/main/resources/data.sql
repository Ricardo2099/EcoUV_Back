-- =============================================
-- FACULTADES
-- =============================================

INSERT INTO facultades (id, nombre, clave)
VALUES 
  (1, 'Facultad de Ingeniería Ixtaczoquitlán', 'FI-IX'),
  (2, 'Facultad de Ciencias Químicas Orizaba', 'FCQ-OR'),
  (3, 'Facultad de Arquitectura Córdoba-Orizaba', 'FA-CO'),
  (4, 'Facultad de Enfermería de Orizaba', 'FENF-OR'),
  (5, 'Facultad de Negocios y Tecnologías Ixtaczoquitlán', 'FNT-IX');


-- =============================================
-- CARRERAS
-- =============================================

-- Facultad 1
INSERT INTO carreras (id, nombre, clave, facultad_id) VALUES
  (1, 'Ingeniería Civil', 'ICIV', 1),
  (2, 'Ingeniería Industrial', 'IIND', 1),
  (3, 'Ingeniería Mecánica-Eléctrica', 'IME', 1),
  (4, 'Ingeniería Mecatrónica', 'IMEC', 1);

-- Facultad 2
INSERT INTO carreras (id, nombre, clave, facultad_id) VALUES
  (5, 'Licenciatura en Química Industrial', 'LQI', 2),
  (6, 'Licenciatura en Químico Farmacéutico Biólogo', 'QFB', 2);

-- Facultad 3
INSERT INTO carreras (id, nombre, clave, facultad_id) VALUES
  (7, 'Licenciatura en Arquitectura', 'ARQ', 3);

-- Facultad 4
INSERT INTO carreras (id, nombre, clave, facultad_id) VALUES
  (8, 'Licenciatura en Enfermería', 'LENF', 4);

-- Facultad 5
INSERT INTO carreras (id, nombre, clave, facultad_id) VALUES
  (9, 'Lic. en Gestión y Dirección de Negocios', 'LGDN', 5),
  (10, 'Licenciatura en Administración', 'LADM', 5),
  (11, 'Licenciatura en Ingeniería de Software', 'LIS', 5);


-- =============================================
-- PLANES DE ESTUDIO
-- =============================================

INSERT INTO planes (id, clave, nombre, carrera_id) VALUES
  (1, 'ICIV-2020', 'Plan 2020 - Ingeniería Civil', 1),
  (2, 'IIND-2020', 'Plan 2020 - Ingeniería Industrial', 2),
  (3, 'IME-2020', 'Plan 2020 - Ingeniería Mecánica-Eléctrica', 3),
  (4, 'IMEC-2020', 'Plan 2020 - Ingeniería Mecatrónica', 4),

  (5, 'LQI-2019', 'Plan 2019 - Lic. Química Industrial', 5),
  (6, 'QFB-2019', 'Plan 2019 - QFB', 6),

  (7, 'ARQ-2018', 'Plan 2018 - Arquitectura', 7),

  (8, 'LENF-2018', 'Plan 2018 - Enfermería', 8),

  (9, 'LGDN-2021', 'Plan 2021 - Gestión y Dirección de Negocios', 9),
  (10, 'LADM-2018', 'Plan 2018 - Administración', 10),
  (11, 'LIS-2023', 'Plan 2023 - Ingeniería de Software', 11);


-- =============================================
-- GRUPOS (TABLA: grupos)
-- Dos grupos por semestre: 01 matutino / 02 vespertino
-- Semestres: 1,2,3,4,5,6,7 => 101–701 y 102–702
-- =============================================

-- CHUNK GENERATOR
-- Para no repetir 11 veces, generamos un bloque por carrera, 14 grupos cada uno.


-- =============================================
-- Ingeniería Civil (1 / plan 1)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('ICIV-101','101',1,1), ('ICIV-102','102',1,1),
  ('ICIV-201','201',1,1), ('ICIV-202','202',1,1),
  ('ICIV-301','301',1,1), ('ICIV-302','302',1,1),
  ('ICIV-401','401',1,1), ('ICIV-402','402',1,1),
  ('ICIV-501','501',1,1), ('ICIV-502','502',1,1),
  ('ICIV-601','601',1,1), ('ICIV-602','602',1,1),
  ('ICIV-701','701',1,1), ('ICIV-702','702',1,1);


-- =============================================
-- Ingeniería Industrial (2 / plan 2)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('IIND-101','101',2,2), ('IIND-102','102',2,2),
  ('IIND-201','201',2,2), ('IIND-202','202',2,2),
  ('IIND-301','301',2,2), ('IIND-302','302',2,2),
  ('IIND-401','401',2,2), ('IIND-402','402',2,2),
  ('IIND-501','501',2,2), ('IIND-502','502',2,2),
  ('IIND-601','601',2,2), ('IIND-602','602',2,2),
  ('IIND-701','701',2,2), ('IIND-702','702',2,2);


-- =============================================
-- Ingeniería Mecánica-Eléctrica (3 / plan 3)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('IME-101','101',3,3), ('IME-102','102',3,3),
  ('IME-201','201',3,3), ('IME-202','202',3,3),
  ('IME-301','301',3,3), ('IME-302','302',3,3),
  ('IME-401','401',3,3), ('IME-402','402',3,3),
  ('IME-501','501',3,3), ('IME-502','502',3,3),
  ('IME-601','601',3,3), ('IME-602','602',3,3),
  ('IME-701','701',3,3), ('IME-702','702',3,3);


-- =============================================
-- Ingeniería Mecatrónica (4 / plan 4)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('IMEC-101','101',4,4), ('IMEC-102','102',4,4),
  ('IMEC-201','201',4,4), ('IMEC-202','202',4,4),
  ('IMEC-301','301',4,4), ('IMEC-302','302',4,4),
  ('IMEC-401','401',4,4), ('IMEC-402','402',4,4),
  ('IMEC-501','501',4,4), ('IMEC-502','502',4,4),
  ('IMEC-601','601',4,4), ('IMEC-602','602',4,4),
  ('IMEC-701','701',4,4), ('IMEC-702','702',4,4);


-- =============================================
-- Química Industrial (5 / plan 5)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('LQI-101','101',5,5), ('LQI-102','102',5,5),
  ('LQI-201','201',5,5), ('LQI-202','202',5,5),
  ('LQI-301','301',5,5), ('LQI-302','302',5,5),
  ('LQI-401','401',5,5), ('LQI-402','402',5,5),
  ('LQI-501','501',5,5), ('LQI-502','502',5,5),
  ('LQI-601','601',5,5), ('LQI-602','602',5,5),
  ('LQI-701','701',5,5), ('LQI-702','702',5,5);


-- =============================================
-- QFB (6 / plan 6)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('QFB-101','101',6,6), ('QFB-102','102',6,6),
  ('QFB-201','201',6,6), ('QFB-202','202',6,6),
  ('QFB-301','301',6,6), ('QFB-302','302',6,6),
  ('QFB-401','401',6,6), ('QFB-402','402',6,6),
  ('QFB-501','501',6,6), ('QFB-502','502',6,6),
  ('QFB-601','601',6,6), ('QFB-602','602',6,6),
  ('QFB-701','701',6,6), ('QFB-702','702',6,6);


-- =============================================
-- Arquitectura (7 / plan 7)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('ARQ-101','101',7,7), ('ARQ-102','102',7,7),
  ('ARQ-201','201',7,7), ('ARQ-202','202',7,7),
  ('ARQ-301','301',7,7), ('ARQ-302','302',7,7),
  ('ARQ-401','401',7,7), ('ARQ-402','402',7,7),
  ('ARQ-501','501',7,7), ('ARQ-502','502',7,7),
  ('ARQ-601','601',7,7), ('ARQ-602','602',7,7),
  ('ARQ-701','701',7,7), ('ARQ-702','702',7,7);


-- =============================================
-- Enfermería (8 / plan 8)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('LENF-101','101',8,8), ('LENF-102','102',8,8),
  ('LENF-201','201',8,8), ('LENF-202','202',8,8),
  ('LENF-301','301',8,8), ('LENF-302','302',8,8),
  ('LENF-401','401',8,8), ('LENF-402','402',8,8),
  ('LENF-501','501',8,8), ('LENF-502','502',8,8),
  ('LENF-601','601',8,8), ('LENF-602','602',8,8),
  ('LENF-701','701',8,8), ('LENF-702','702',8,8);


-- =============================================
-- Gestión y Dirección de Negocios (9 / plan 9)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('LGDN-101','101',9,9), ('LGDN-102','102',9,9),
  ('LGDN-201','201',9,9), ('LGDN-202','202',9,9),
  ('LGDN-301','301',9,9), ('LGDN-302','302',9,9),
  ('LGDN-401','401',9,9), ('LGDN-402','402',9,9),
  ('LGDN-501','501',9,9), ('LGDN-502','502',9,9),
  ('LGDN-601','601',9,9), ('LGDN-602','602',9,9),
  ('LGDN-701','701',9,9), ('LGDN-702','702',9,9);


-- =============================================
-- Administración (10 / plan 10)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('LADM-101','101',10,10), ('LADM-102','102',10,10),
  ('LADM-201','201',10,10), ('LADM-202','202',10,10),
  ('LADM-301','301',10,10), ('LADM-302','302',10,10),
  ('LADM-401','401',10,10), ('LADM-402','402',10,10),
  ('LADM-501','501',10,10), ('LADM-502','502',10,10),
  ('LADM-601','601',10,10), ('LADM-602','602',10,10),
  ('LADM-701','701',10,10), ('LADM-702','702',10,10);


-- =============================================
-- Ingeniería de Software (11 / plan 11)
-- =============================================
INSERT INTO grupos (clave, grupo, carrera_id, plan_id) VALUES
  ('LIS-101','101',11,11), ('LIS-102','102',11,11),
  ('LIS-201','201',11,11), ('LIS-202','202',11,11),
  ('LIS-301','301',11,11), ('LIS-302','302',11,11),
  ('LIS-401','401',11,11), ('LIS-402','402',11,11),
  ('LIS-501','501',11,11), ('LIS-502','502',11,11),
  ('LIS-601','601',11,11), ('LIS-602','602',11,11),
  ('LIS-701','701',11,11), ('LIS-702','702',11,11);
