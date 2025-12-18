-- =============================================
-- FACULTADES
-- =============================================

INSERT INTO facultades (id, nombre, clave) VALUES
  (1, 'Facultad de Ingeniería Ixtaczoquitlán', 'FI-IX'),
  (2, 'Facultad de Ciencias Químicas Orizaba', 'FCQ-OR'),
  (3, 'Facultad de Arquitectura Córdoba-Orizaba', 'FA-CO'),
  (4, 'Facultad de Enfermería de Orizaba', 'FENF-OR'),
  (5, 'Facultad de Negocios y Tecnologías Ixtaczoquitlán', 'FNT-IX')
ON CONFLICT (id) DO NOTHING;


-- =============================================
-- CARRERAS
-- =============================================

INSERT INTO carreras (id, nombre, clave, facultad_id) VALUES
  (1, 'Ingeniería Civil', 'ICIV', 1),
  (2, 'Ingeniería Industrial', 'IIND', 1),
  (3, 'Ingeniería Mecánica-Eléctrica', 'IME', 1),
  (4, 'Ingeniería Mecatrónica', 'IMEC', 1),
  (5, 'Licenciatura en Química Industrial', 'LQI', 2),
  (6, 'Licenciatura en Químico Farmacéutico Biólogo', 'QFB', 2),
  (7, 'Licenciatura en Arquitectura', 'ARQ', 3),
  (8, 'Licenciatura en Enfermería', 'LENF', 4),
  (9, 'Lic. en Gestión y Dirección de Negocios', 'LGDN', 5),
  (10, 'Licenciatura en Administración', 'LADM', 5),
  (11, 'Licenciatura en Ingeniería de Software', 'LIS', 5)
ON CONFLICT (id) DO NOTHING;


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
  (11, 'LIS-2023', 'Plan 2023 - Ingeniería de Software', 11)
ON CONFLICT (id) DO NOTHING;


-- =============================================
-- GRUPOS
-- (IMPORTANTE: grupo Y nombre son NOT NULL)
-- =============================================

INSERT INTO grupos (clave, grupo, nombre, carrera_id, plan_id) VALUES
  ('ICIV-101','101','Grupo 101',1,1), ('ICIV-102','102','Grupo 102',1,1),
  ('ICIV-201','201','Grupo 201',1,1), ('ICIV-202','202','Grupo 202',1,1),
  ('ICIV-301','301','Grupo 301',1,1), ('ICIV-302','302','Grupo 302',1,1),
  ('ICIV-401','401','Grupo 401',1,1), ('ICIV-402','402','Grupo 402',1,1),
  ('ICIV-501','501','Grupo 501',1,1), ('ICIV-502','502','Grupo 502',1,1),
  ('ICIV-601','601','Grupo 601',1,1), ('ICIV-602','602','Grupo 602',1,1),
  ('ICIV-701','701','Grupo 701',1,1), ('ICIV-702','702','Grupo 702',1,1),

  ('IIND-101','101','Grupo 101',2,2), ('IIND-102','102','Grupo 102',2,2),
  ('IIND-201','201','Grupo 201',2,2), ('IIND-202','202','Grupo 202',2,2),
  ('IIND-301','301','Grupo 301',2,2), ('IIND-302','302','Grupo 302',2,2),
  ('IIND-401','401','Grupo 401',2,2), ('IIND-402','402','Grupo 402',2,2),
  ('IIND-501','501','Grupo 501',2,2), ('IIND-502','502','Grupo 502',2,2),
  ('IIND-601','601','Grupo 601',2,2), ('IIND-602','602','Grupo 602',2,2),
  ('IIND-701','701','Grupo 701',2,2), ('IIND-702','702','Grupo 702',2,2),

  ('IME-101','101','Grupo 101',3,3), ('IME-102','102','Grupo 102',3,3),
  ('IME-201','201','Grupo 201',3,3), ('IME-202','202','Grupo 202',3,3),
  ('IME-301','301','Grupo 301',3,3), ('IME-302','302','Grupo 302',3,3),
  ('IME-401','401','Grupo 401',3,3), ('IME-402','402','Grupo 402',3,3),
  ('IME-501','501','Grupo 501',3,3), ('IME-502','502','Grupo 502',3,3),
  ('IME-601','601','Grupo 601',3,3), ('IME-602','602','Grupo 602',3,3),
  ('IME-701','701','Grupo 701',3,3), ('IME-702','702','Grupo 702',3,3),

  ('IMEC-101','101','Grupo 101',4,4), ('IMEC-102','102','Grupo 102',4,4),
  ('IMEC-201','201','Grupo 201',4,4), ('IMEC-202','202','Grupo 202',4,4),
  ('IMEC-301','301','Grupo 301',4,4), ('IMEC-302','302','Grupo 302',4,4),
  ('IMEC-401','401','Grupo 401',4,4), ('IMEC-402','402','Grupo 402',4,4),
  ('IMEC-501','501','Grupo 501',4,4), ('IMEC-502','502','Grupo 502',4,4),
  ('IMEC-601','601','Grupo 601',4,4), ('IMEC-602','602','Grupo 602',4,4),
  ('IMEC-701','701','Grupo 701',4,4), ('IMEC-702','702','Grupo 702',4,4),

  ('LQI-101','101','Grupo 101',5,5), ('LQI-102','102','Grupo 102',5,5),
  ('LQI-201','201','Grupo 201',5,5), ('LQI-202','202','Grupo 202',5,5),
  ('LQI-301','301','Grupo 301',5,5), ('LQI-302','302','Grupo 302',5,5),
  ('LQI-401','401','Grupo 401',5,5), ('LQI-402','402','Grupo 402',5,5),
  ('LQI-501','501','Grupo 501',5,5), ('LQI-502','502','Grupo 502',5,5),
  ('LQI-601','601','Grupo 601',5,5), ('LQI-602','602','Grupo 602',5,5),
  ('LQI-701','701','Grupo 701',5,5), ('LQI-702','702','Grupo 702',5,5),

  ('QFB-101','101','Grupo 101',6,6), ('QFB-102','102','Grupo 102',6,6),
  ('QFB-201','201','Grupo 201',6,6), ('QFB-202','202','Grupo 202',6,6),
  ('QFB-301','301','Grupo 301',6,6), ('QFB-302','302','Grupo 302',6,6),
  ('QFB-401','401','Grupo 401',6,6), ('QFB-402','402','Grupo 402',6,6),
  ('QFB-501','501','Grupo 501',6,6), ('QFB-502','502','Grupo 502',6,6),
  ('QFB-601','601','Grupo 601',6,6), ('QFB-602','602','Grupo 602',6,6),
  ('QFB-701','701','Grupo 701',6,6), ('QFB-702','702','Grupo 702',6,6),

  ('ARQ-101','101','Grupo 101',7,7), ('ARQ-102','102','Grupo 102',7,7),
  ('ARQ-201','201','Grupo 201',7,7), ('ARQ-202','202','Grupo 202',7,7),
  ('ARQ-301','301','Grupo 301',7,7), ('ARQ-302','302','Grupo 302',7,7),
  ('ARQ-401','401','Grupo 401',7,7), ('ARQ-402','402','Grupo 402',7,7),
  ('ARQ-501','501','Grupo 501',7,7), ('ARQ-502','502','Grupo 502',7,7),
  ('ARQ-601','601','Grupo 601',7,7), ('ARQ-602','602','Grupo 602',7,7),
  ('ARQ-701','701','Grupo 701',7,7), ('ARQ-702','702','Grupo 702',7,7),

  ('LENF-101','101','Grupo 101',8,8), ('LENF-102','102','Grupo 102',8,8),
  ('LENF-201','201','Grupo 201',8,8), ('LENF-202','202','Grupo 202',8,8),
  ('LENF-301','301','Grupo 301',8,8), ('LENF-302','302','Grupo 302',8,8),
  ('LENF-401','401','Grupo 401',8,8), ('LENF-402','402','Grupo 402',8,8),
  ('LENF-501','501','Grupo 501',8,8), ('LENF-502','502','Grupo 502',8,8),
  ('LENF-601','601','Grupo 601',8,8), ('LENF-602','602','Grupo 602',8,8),
  ('LENF-701','701','Grupo 701',8,8), ('LENF-702','702','Grupo 702',8,8),

  ('LGDN-101','101','Grupo 101',9,9), ('LGDN-102','102','Grupo 102',9,9),
  ('LGDN-201','201','Grupo 201',9,9), ('LGDN-202','202','Grupo 202',9,9),
  ('LGDN-301','301','Grupo 301',9,9), ('LGDN-302','302','Grupo 302',9,9),
  ('LGDN-401','401','Grupo 401',9,9), ('LGDN-402','402','Grupo 402',9,9),
  ('LGDN-501','501','Grupo 501',9,9), ('LGDN-502','502','Grupo 502',9,9),
  ('LGDN-601','601','Grupo 601',9,9), ('LGDN-602','602','Grupo 602',9,9),
  ('LGDN-701','701','Grupo 701',9,9), ('LGDN-702','702','Grupo 702',9,9),

  ('LADM-101','101','Grupo 101',10,10), ('LADM-102','102','Grupo 102',10,10),
  ('LADM-201','201','Grupo 201',10,10), ('LADM-202','202','Grupo 202',10,10),
  ('LADM-301','301','Grupo 301',10,10), ('LADM-302','302','Grupo 302',10,10),
  ('LADM-401','401','Grupo 401',10,10), ('LADM-402','402','Grupo 402',10,10),
  ('LADM-501','501','Grupo 501',10,10), ('LADM-502','502','Grupo 502',10,10),
  ('LADM-601','601','Grupo 601',10,10), ('LADM-602','602','Grupo 602',10,10),
  ('LADM-701','701','Grupo 701',10,10), ('LADM-702','702','Grupo 702',10,10),

  ('LIS-101','101','Grupo 101',11,11), ('LIS-102','102','Grupo 102',11,11),
  ('LIS-201','201','Grupo 201',11,11), ('LIS-202','202','Grupo 202',11,11),
  ('LIS-301','301','Grupo 301',11,11), ('LIS-302','302','Grupo 302',11,11),
  ('LIS-401','401','Grupo 401',11,11), ('LIS-402','402','Grupo 402',11,11),
  ('LIS-501','501','Grupo 501',11,11), ('LIS-502','502','Grupo 502',11,11),
  ('LIS-601','601','Grupo 601',11,11), ('LIS-602','602','Grupo 602',11,11),
  ('LIS-701','701','Grupo 701',11,11), ('LIS-702','702','Grupo 702',11,11)
ON CONFLICT (clave) DO NOTHING;
