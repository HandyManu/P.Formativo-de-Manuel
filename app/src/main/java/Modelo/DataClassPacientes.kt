package Modelo

data class DataClassPacientes(
    val UUID_Paciente:String,
    var Nombres:String,
    var Apellidos:String,
    var Edad : String,
    var Enfermedad: String,
    var NumeroDeHabitacion : String,
    var NumeroDeCama : String,
    var MedicamentosAsignados :String,
    var HoraDeAplicacion : String
)
