package manuel.ortega.proyecto_formativo

import Modelo.ClaseConexion
import Modelo.DataClassPacientes
import ReciclerViewHelper.Adaptador
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

class Activity_Nuevo_Paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_paciente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

             val nombre = findViewById<TextView>(R.id.txt_nombre)
             val apellido = findViewById<TextView>(R.id.txt_Apellidos)
             val edad = findViewById<TextView>(R.id.txt_edad)
             val enfermedad = findViewById<TextView>(R.id.txt_enfermedad)
             val numeroHabitacion = findViewById<TextView>(R.id.txt_habitacion)
             val numeroCama = findViewById<TextView>(R.id.txt_cama)
             val medicamentos = findViewById<TextView>(R.id.txt_medicamento)
             val horaAplicacion = findViewById<TextView>(R.id.txt_hora)
             val btnGuardar = findViewById<Button>(R.id.btn_guardar)
        val rcvPacientes = findViewById<RecyclerView>(R.id.rcvPacientes)

        rcvPacientes.layoutManager = LinearLayoutManager(this)




        fun obtenerPacientes(): List<DataClassPacientes> {
            val objConexion = ClaseConexion().cadenaConexion()
            val statement = objConexion?.createStatement()
            val resultSet = statement?.executeQuery("SELECT * FROM TB_Paciente")!!

            val listaPacientes = mutableListOf<DataClassPacientes>()
            while (resultSet.next()) {
                val UUIDPaciente = resultSet.getString("UUID_Paciente")
                val Nombre = resultSet.getString("Nombres")
                val Apellido = resultSet.getString("Apellidos")
                val Edad = resultSet.getString("Edad")
                val Enfermedad = resultSet.getString("ENFERMEDAD")
                val NumeroHabitacion = resultSet.getString("NumeroDeHabitacion")
                val NumeroCama = resultSet.getString("Numero_De_Cama")
                val MedicamentosAsignados = resultSet.getString("MedicamentosAsignados")
                val HoraDeAplicacion = resultSet.getString("HoraDeAplicacion")


                val valorPacientes = DataClassPacientes(UUIDPaciente, Nombre, Apellido, Edad, Enfermedad, NumeroHabitacion, NumeroCama, MedicamentosAsignados , HoraDeAplicacion)
                listaPacientes.add(valorPacientes)
            }
            return listaPacientes
        }

        CoroutineScope(Dispatchers.IO).launch {
            val tiketsDatos = obtenerPacientes()
            withContext(Dispatchers.Main) {
                val adapter = Adaptador(tiketsDatos)
                rcvPacientes.adapter = adapter
            }
        }

        btnGuardar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val claseConexion = ClaseConexion().cadenaConexion()
                val addPaciente = claseConexion?.prepareStatement("INSERT INTO TB_Paciente(UUID_Paciente, Nombres , Apellidos , Edad , ENFERMEDAD , NumeroDeHabitacion , Numero_De_Cama , MedicamentosAsignados , HoraDeAplicacion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)")!!

                addPaciente.setString(1, UUID.randomUUID().toString())
                addPaciente.setString(2, nombre.text.toString())
                addPaciente.setString(3, apellido.text.toString())
                addPaciente.setString(4, edad.text.toString())
                addPaciente.setString(5, enfermedad.text.toString())
                addPaciente.setString(6, numeroHabitacion.text.toString())
                addPaciente.setString(7, numeroCama.text.toString())
                addPaciente.setString(8, medicamentos.text.toString())
                addPaciente.setString(9, horaAplicacion.text.toString())
                addPaciente.executeUpdate()

                val nuevosPacientes = obtenerPacientes()
                withContext(Dispatchers.Main) {
                    (rcvPacientes.adapter as? Adaptador)?.actualizarLista(nuevosPacientes)



                }
            }
        }
    }
}