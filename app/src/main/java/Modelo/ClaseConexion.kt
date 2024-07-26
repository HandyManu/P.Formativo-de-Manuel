package Modelo

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): Connection?{
        try {
            val url="jdbc:oracle:thin:@169.254.143.97:1521:xe"
            val user="MANUEL_DEVELOPER"
            val password="20220416"
            val connection= DriverManager.getConnection(url, user, password)
            return connection
        }catch (e: Exception){
            println("este es el error:$e")
            return null
        }
    }
}