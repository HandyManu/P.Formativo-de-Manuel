package manuel.ortega.proyecto_formativo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
    }
}