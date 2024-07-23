
CREATE TABLE TB_Enfermedad (
UUID_Enfermedad VARCHAR2(50) PRIMARY KEY,
ENFERMEDAD VARCHAR2(50)
);

UPDATE TB_Enfermedad SET UUID_Enfermedad= SYS_GUID()

CREATE TABLE TB_Cama (
UUID_Cama VARCHAR2(50) PRIMARY KEY,
Numero_De_Cama VARCHAR2(50)
);

UPDATE TB_Cama SET UUID_Cama= SYS_GUID()

CREATE TABLE TB_Habitacion (
UUID_Habitacion VARCHAR2(50) PRIMARY KEY,
NumeroDeHabitacion VARCHAR2(50),
UUID_Cama VARCHAR2(50),
constraint fk_cama foreign key (UUID_Cama) references TB_Cama(UUID_Cama)
);

UPDATE TB_Habitacion SET UUID_Habitacion= SYS_GUID()


CREATE TABLE TB_Medicamentos (
UUID_Medicamento VARCHAR2(50) PRIMARY KEY,
MedicamentosAsignados VARCHAR2(50),
HoraDeAplicacion VARCHAR2(10)
);

UPDATE TB_Medicamentos SET UUID_Medicamento= SYS_GUID()

CREATE TABLE TB_Paciente (
UUID_Paciente VARCHAR2(50) PRIMARY KEY,
Nombres VARCHAR2(50),
Apellidos VARCHAR2(50),
Edad VARCHAR2(3),
UUID_Enfermedad VARCHAR2(50) ,
UUID_Habitacion VARCHAR2(50),
UUID_Medicamento VARCHAR2(50), 
constraint fk_enferemedad foreign key (UUID_Enfermedad)references TB_Enfermedad(UUID_Enfermedad),
constraint fk_habitacion foreign key (UUID_Habitacion) references TB_Habitacion(UUID_Habitacion),
CONSTRAINT fk_medicamento foreign key (UUID_Medicamento) references TB_Medicamentos (UUID_Medicamento)
);

UPDATE TB_Paciente SET UUID_Paciente= SYS_GUID()



