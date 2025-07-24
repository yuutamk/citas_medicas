-- Crear la base de datos
CREATE DATABASE citas_medicas;

-- Usar la base de datos
USE citas_medicas;

-- Crear tabla de usuarios
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role ENUM('doctor', 'nurse', 'patient') NOT NULL
);

-- Crear tabla de doctores
CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Crear tabla de pacientes
CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    birth_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Crear tabla de citas
CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    reason TEXT,
    status ENUM('scheduled', 'rejected', 'rescheduled', 'attended') DEFAULT 'scheduled',
    rescheduled_date DATETIME NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);

-- Insertar usuarios
INSERT INTO users (name, email, password, role) VALUES
('Dr. Juan Pérez', 'juan.perez@hospital.com', 'password123', 'doctor'),
('Enfermera Ana López', 'ana.lopez@hospital.com', 'password123', 'nurse'),
('Carlos Gómez', 'carlos.gomez@gmail.com', 'password123', 'patient'),
('Dra. María Ruiz', 'maria.ruiz@hospital.com', 'password123', 'doctor'),
('Paciente Laura Torres', 'laura.torres@gmail.com', 'password123', 'patient');

-- Insertar doctores
INSERT INTO doctors (user_id, specialty) VALUES
(1, 'Cardiología'),
(4, 'Pediatría');

-- Insertar pacientes
INSERT INTO patients (user_id, birth_date) VALUES
(3, '1990-05-15'),
(5, '1985-09-22');

-- Insertar citas
INSERT INTO appointments (doctor_id, patient_id, appointment_date, reason, status) VALUES
(1, 1, '2024-07-01 09:00:00', 'Chequeo general', 'scheduled'),
(2, 2, '2024-07-02 10:30:00', 'Consulta pediátrica', 'scheduled'),
(1, 2, '2024-07-03 11:00:00', 'Revisión de resultados', 'rescheduled');