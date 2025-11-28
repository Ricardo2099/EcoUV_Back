-- =========================
-- FACULTADES (Región Orizaba - Córdoba)
-- =========================
INSERT INTO facultades (id, nombre, clave)
VALUES 
  (1, 'Facultad de Ingeniería Ixtaczoquitlán', 'FI-IX'),
  (2, 'Facultad de Ciencias Químicas Orizaba', 'FCQ-OR'),
  (3, 'Facultad de Arquitectura Córdoba-Orizaba', 'FA-CO'),
  (4, 'Facultad de Enfermería de Orizaba', 'FENF-OR'),
  (5, 'Facultad de Negocios y Tecnologías Ixtaczoquitlán', 'FNT-IX');

-- =========================
-- CARRERAS POR FACULTAD
-- (Nombres reales o muy cercanos a la oferta de la UV en Orizaba-Córdoba)
-- =========================

-- Facultad de Ingeniería Ixtaczoquitlán (FI-IX)
INSERT INTO carreras (id, nombre, clave, facultad_id)
VALUES
  (1, 'Ingeniería Civil', 'ICIV', 1),
  (2, 'Ingeniería Industrial', 'IIND', 1),
  (3, 'Ingeniería Mecánica-Eléctrica', 'IME', 1),
  (4, 'Ingeniería Mecatrónica', 'IMEC', 1);

-- Facultad de Ciencias Químicas Orizaba (FCQ-OR)
INSERT INTO carreras (id, nombre, clave, facultad_id)
VALUES
  (5, 'Licenciatura en Química Industrial', 'LQI', 2),
  (6, 'Licenciatura en Químico Farmacéutico Biólogo', 'QFB', 2);

-- Facultad de Arquitectura Córdoba-Orizaba (FA-CO)
INSERT INTO carreras (id, nombre, clave, facultad_id)
VALUES
  (7, 'Licenciatura en Arquitectura', 'ARQ', 3);

-- Facultad de Enfermería de Orizaba (FENF-OR)
INSERT INTO carreras (id, nombre, clave, facultad_id)
VALUES
  (8, 'Licenciatura en Enfermería', 'LENF', 4);

-- Facultad de Negocios y Tecnologías Ixtaczoquitlán (FNT-IX)
INSERT INTO carreras (id, nombre, clave, facultad_id)
VALUES
  (9, 'Licenciatura en Gestión y Dirección de Negocios', 'LGDN', 5),
  (10, 'Licenciatura en Administración', 'LADM', 5),
  (11, 'Licenciatura en Ingeniería de Software', 'LIS', 5);

-- =========================
-- PLANES DE ESTUDIO POR CARRERA
-- (Claves y nombres realistas por año)
-- =========================
INSERT INTO planes (id, clave, nombre, carrera_id)
VALUES
  (1, 'ICIV-2020', 'Plan 2020 - Ingeniería Civil', 1),
  (2, 'IIND-2020', 'Plan 2020 - Ingeniería Industrial', 2),
  (3, 'IME-2020', 'Plan 2020 - Ingeniería Mecánica-Eléctrica', 3),
  (4, 'IMEC-2020', 'Plan 2020 - Ingeniería Mecatrónica', 4),

  (5, 'LQI-2019', 'Plan 2019 - Licenciatura en Química Industrial', 5),
  (6, 'QFB-2019', 'Plan 2019 - Químico Farmacéutico Biólogo', 6),

  (7, 'ARQ-2018', 'Plan 2018 - Licenciatura en Arquitectura', 7),

  (8, 'LENF-2018', 'Plan 2018 - Licenciatura en Enfermería', 8),

  (9, 'LGDN-2021', 'Plan 2021 - Licenciatura en Gestión y Dirección de Negocios', 9),
  (10, 'LADM-2018', 'Plan 2018 - Licenciatura en Administración', 10),
  (11, 'LIS-2023', 'Plan 2023 - Licenciatura en Ingeniería de Software', 11);

-- =========================
-- GRUPOS ACADÉMICOS
-- Supongamos ciclo 2025-1, algunos semestres y grupos por carrera.
-- =========================

-- Ingeniería Civil (ICIV)
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (1, 1, 1, 'ICIV-101', '2025-1', true),
  (2, 1, 3, 'ICIV-301', '2025-1', true);

-- Ingeniería Industrial (IIND)
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (3, 2, 1, 'IIND-101', '2025-1', true),
  (4, 2, 3, 'IIND-301', '2025-1', true);

-- Ingeniería Mecánica-Eléctrica (IME)
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (5, 3, 1, 'IME-101', '2025-1', true);

-- Ingeniería Mecatrónica (IMEC)
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (6, 4, 1, 'IMEC-101', '2025-1', true);

-- Química Industrial (LQI)
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (7, 5, 1, 'LQI-101', '2025-1', true);

-- QFB
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (8, 6, 1, 'QFB-101', '2025-1', true);

-- Arquitectura
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (9, 7, 1, 'ARQ-101', '2025-1', true),
  (10, 7, 3, 'ARQ-301', '2025-1', true);

-- Enfermería
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (11, 8, 1, 'LENF-101', '2025-1', true);

-- Gestión y Dirección de Negocios
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (12, 9, 1, 'LGDN-101', '2025-1', true),
  (13, 9, 3, 'LGDN-301', '2025-1', true);

-- Administración
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (14, 10, 1, 'LADM-101', '2025-1', true);

-- Ingeniería de Software
INSERT INTO grupos_academicos (id, carrera_id, semestre, grupo, ciclo, activo)
VALUES
  (15, 11, 1, 'LIS-101', '2025-1', true),
  (16, 11, 3, 'LIS-301', '2025-1', true);
