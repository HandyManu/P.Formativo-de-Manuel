
CREATE TABLE TB_Paciente (
UUID_Paciente VARCHAR2(50) PRIMARY KEY,
Nombres VARCHAR2(50),
Apellidos VARCHAR2(50),
Edad VARCHAR2(3),
ENFERMEDAD VARCHAR2(50),
NumeroDeHabitacion VARCHAR2(50),
Numero_De_Cama VARCHAR2(50),
MedicamentosAsignados VARCHAR2(50),
HoraDeAplicacion VARCHAR2(10)
);

UPDATE TB_Paciente SET UUID_Paciente= SYS_GUID()




