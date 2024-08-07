package Modelo

data class DataClassPacientes(
    val UUID_Paciente:String,
    var Nombres:String,
    var Apellidos:String,
    var Edad : String,
    var Enfermedad: String,
    val NumeroDeHabitacion : String,
    val NumeroDeCama : String,
    var MedicamentosAsignados :String,
    val HoraDeAplicacion : String
)
