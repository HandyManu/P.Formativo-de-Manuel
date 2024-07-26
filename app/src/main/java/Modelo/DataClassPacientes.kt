package Modelo

data class DataClassPacientes(
    val UUID_Paciente:String,
    var Nombres:String,
    var Apellidos:String,
    var Edad : String,
    var UUID_Enfermedad: String,
    val UUID_Habitacion : String,
    var UUID_Medicamento :String
)
