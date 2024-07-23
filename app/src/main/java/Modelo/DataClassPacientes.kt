package Modelo

data class DataClassPacientes(
    val uuidNumero:String,
    var titulo:String,
    var descripcion:String,
    var autor : String,
    var email: String,
    val fechaCreacion : String,
    var estado :String,
    var fechaFinalizacion:String
)
