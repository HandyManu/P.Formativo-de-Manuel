CREATE TABLE TB_Paciente (
UUID_Paciente INT PRIMARY KEY,
Nombres VARCHAR2(50),
Apellidos VARCHAR2(50),
Edad VARCHAR2(3)
);

CREATE TABLE TB_Enfermedad (
UUID_Enfermedad INT PRIMARY KEY,
ENFERMEDAD VARCHAR2(50)
);

CREATE TABLE TB_Habitacion (
UUID_Habitacion INT PRIMARY KEY,
NumeroDeHabitacion VARCHAR2(50)
);

CREATE TABLE TB_Cama (
UUID_Cama INT PRIMARY KEY,
Numero_De_Cama VARCHAR2(50)
);

CREATE TABLE TB_Medicamentos (
UUID_Medicamento INT PRIMARY KEY,
MedicamentosAsignados VARCHAR2(50),
HoraDeAplicacion VARCHAR2(10)
);

//tablas de relaciones
CREATE TABLE TB_EstadoPaciente (
UUIDEstadoPaciente INT PRIMARY KEY,
UUID_Enfermedad INT,
UUID_Paciente INT,
CONSTRAINT fk_enfermedadPaciente FOREIGN KEY (UUID_Enfermedad) REFERENCES TB_Enfermedad(UUID_Enfermedad),
CONSTRAINT fk_Paciente FOREIGN KEY (UUID_Paciente) REFERENCES TB_Paciente (UUID_Paciente)
);

CREATE TABLE TB_MedicamentoPaciente  (
UUIDMedicamentoPaciente INT PRIMARY KEY,
UUID_Paciente INT,
UUID_Medicamento INT,
CONSTRAINT fk_medicamentoPaciente FOREIGN KEY (UUID_Medicamento) REFERENCES TB_Medicamentos (UUID_Medicamento),
CONSTRAINT fk_Paciente1 FOREIGN KEY (UUID_Paciente) REFERENCES TB_Paciente (UUID_Paciente)
);

CREATE TABLE TB_HabitacionPaciente (
UUIDHabitacionPaciente INT PRIMARY KEY,
UUID_Habitacion INT,
UUID_Paciente INT,
CONSTRAINT fk_habitacionPaciente FOREIGN KEY (UUID_Habitacion) REFERENCES TB_Habitacion(UUID_Habitacion),
CONSTRAINT fk_Paciente2 FOREIGN KEY (UUID_Paciente) REFERENCES TB_Paciente (UUID_Paciente)
);

CREATE TABLE TB_CamaHabitacion (
UUIDCAMAHABITACION INT PRIMARY KEY ,
UUID_Habitacion INT,
UUID_Cama INT,
CONSTRAINT fk_camahabitacion FOREIGN KEY (UUID_Habitacion) REFERENCES TB_Habitacion(UUID_Habitacion),
CONSTRAINT fk_cama FOREIGN KEY (UUID_Cama)REFERENCES TB_Cama(UUID_Cama)
);
