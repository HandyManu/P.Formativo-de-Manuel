package manuel.ortega.proyecto_formativo

import Modelo.ClaseConexion
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        btnGuardar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val claseConexion = ClaseConexion().cadenaConexion()

                // Inserción en TB_Enfermedad
                val addEnfermedad = claseConexion?.prepareStatement("INSERT INTO TB_Enfermedad(UUID_Enfermedad, ENFERMEDAD) VALUES(?, ?)")!!
                val uuidEnfermedad = UUID.randomUUID().toString()
                addEnfermedad.setString(1, uuidEnfermedad)
                addEnfermedad.setString(2, enfermedad.text.toString())
                addEnfermedad.executeUpdate()

                // Inserción en TB_Cama
                val addCama = claseConexion?.prepareStatement("INSERT INTO TB_Cama(UUID_Cama, Numero_De_Cama) VALUES(?, ?)")!!
                val uuidCama = UUID.randomUUID().toString()
                addCama.setString(1, uuidCama)
                addCama.setString(2, numeroCama.text.toString())
                addCama.executeUpdate()

                // Inserción en TB_Habitacion
                val addHabitacion = claseConexion?.prepareStatement("INSERT INTO TB_Habitacion(UUID_Habitacion, NumeroDeHabitacion, UUID_Cama) VALUES(?, ?, ?)")!!
                val uuidHabitacion = UUID.randomUUID().toString()
                addHabitacion.setString(1, uuidHabitacion)
                addHabitacion.setString(2, numeroHabitacion.text.toString())
                addHabitacion.setString(3, uuidCama)
                addHabitacion.executeUpdate()

                // Inserción en TB_Medicamentos
                val addMedicamento = claseConexion?.prepareStatement("INSERT INTO TB_Medicamentos(UUID_Medicamento, MedicamentosAsignados, HoraDeAplicacion) VALUES(?, ?, ?)")!!
                val uuidMedicamento = UUID.randomUUID().toString()
                addMedicamento.setString(1, uuidMedicamento)
                addMedicamento.setString(2, medicamentos.text.toString())
                addMedicamento.setString(3, horaAplicacion.text.toString())
                addMedicamento.executeUpdate()

                // Inserción en TB_Paciente
                val addPaciente = claseConexion?.prepareStatement("INSERT INTO TB_Paciente(UUID_Paciente, Nombres, Apellidos, Edad, UUID_Enfermedad, UUID_Habitacion, UUID_Medicamento) VALUES(?, ?, ?, ?, ?, ?, ?)")!!
                val uuidPaciente = UUID.randomUUID().toString()
                addPaciente.setString(1, uuidPaciente)
                addPaciente.setString(2, nombre.text.toString())
                addPaciente.setString(3, apellido.text.toString())
                addPaciente.setString(4, edad.text.toString())
                addPaciente.setString(5, uuidEnfermedad)
                addPaciente.setString(6, uuidHabitacion)
                addPaciente.setString(7, uuidMedicamento)
                addPaciente.executeUpdate()

                // Actualiza la UI con los nuevos datos si es necesario
                withContext(Dispatchers.Main) {
                    // Aquí puedes actualizar tu RecyclerView o cualquier otra vista
                }
            }
        }
    }
}