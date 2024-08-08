package ReciclerViewHelper2

import Modelo.ClaseConexion
import Modelo.DataClassPacientes
import ReciclerViewHelper.ViewHolder
import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import manuel.ortega.proyecto_formativo.Activity_DetallePaciente
import manuel.ortega.proyecto_formativo.R

class AdaptadorD (var Datos: List<DataClassPacientes>) : RecyclerView.Adapter<ViewHolderD>() {

    fun actualizarLista(nuevaLista: List<DataClassPacientes>) {
        Datos = nuevaLista
        notifyDataSetChanged()
    }

    fun actualizarListaDespuesDeActualizarNombre(uuid: String, nuevoNombre: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].Nombres = nuevoNombre
        notifyItemChanged(index)
    }

    fun actualizarListaDespuesDeActualizarApellido(uuid: String, nuevoApellido: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].Apellidos = nuevoApellido
        notifyItemChanged(index)
    }

    fun actualizarListaDespuesDeActualizarEdad(uuid: String, nuevaEdad: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].Edad = nuevaEdad
        notifyItemChanged(index)
    }

    fun actualizarListaDespuesDeActualizarEnfermedad(uuid: String, nuevaEnfermedad: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].Enfermedad = nuevaEnfermedad
        notifyItemChanged(index)
    }

    fun actualizarListaDespuesDeActualizarHabitacion(uuid: String, nuevaHabitacion: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].NumeroDeHabitacion = nuevaHabitacion
        notifyItemChanged(index)
    }

    fun actualizarListaDespuesDeActualizarCama(uuid: String, nuevaCama: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].NumeroDeCama = nuevaCama
        notifyItemChanged(index)
    }

    fun actualizarListaDespuesDeActualizarMedicamentos(uuid: String, nuevoMedicamento: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].MedicamentosAsignados = nuevoMedicamento
        notifyItemChanged(index)
    }

    fun actualizarListaDespuesDeActualizarHora(uuid: String, nuevaHora: String) {
        val index = Datos.indexOfFirst { it.UUID_Paciente == uuid }
        Datos[index].HoraDeAplicacion = nuevaHora
        notifyItemChanged(index)
    }

    fun actualizarNombre(Nombres: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET Nombres = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Nombres)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Nombres)
            }
        }
    }

    fun actualizarApellido(Apellidos: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET Apellidos = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Apellidos)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Apellidos)
            }
        }
    }

    fun actualizarEdad(Edad: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET Edad = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Edad)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Edad)
            }
        }
    }

    fun actualizarEnfermedad(Enfermedad: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET Enfermedad = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Enfermedad)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Enfermedad)
            }
        }
    }

    fun actualizarHabitacion(Habitacion: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET NumeroDeHabitacion = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Habitacion)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Habitacion)
            }
        }
    }

    fun actualizarCama(Cama: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET Numero_De_Cama = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Cama)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Cama)
            }
        }
    }

    fun actualizarMedicamentos(Medicamentos: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET MedicamentosAsignados = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Medicamentos)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Medicamentos)
            }
        }
    }

    fun actualizarHora(Hora: String, uuid: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val updateNombre = objConexion?.prepareStatement("UPDATE Tb_Paciente SET HoraDeAplicacion = ? WHERE UUID_Paciente = ?")!!
            updateNombre.setString(1, Hora)
            updateNombre.setString(2, uuid)
            updateNombre.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")
            commit.executeUpdate()
            withContext(Dispatchers.Main) {
                actualizarListaDespuesDeActualizarNombre(uuid, Hora)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderD {
        val vistas = LayoutInflater.from(parent.context).inflate(R.layout.activity_datos_card, parent, false)
        return ViewHolderD(vistas)
    }

    override fun getItemCount()= Datos.size


    override fun onBindViewHolder(holder: ViewHolderD, position: Int) {
        val item = Datos[position]
        holder.textView.text = item.Nombres

        holder.imgEditar.setOnClickListener {
            val context = holder.itemView.context
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Editar Nombre")
            val cuadritoNuevoNombre = EditText(context)
            cuadritoNuevoNombre.setHint(item.Nombres)
            builder.setView(cuadritoNuevoNombre)
            builder.setPositiveButton("Actualizar") { dialog, which ->
                actualizarNombre(cuadritoNuevoNombre.text.toString(), item.UUID_Paciente)
            }
            builder.setNegativeButton("Cancelar") { dialog, which ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val pantallaDetalles = Intent(context, Activity_DetallePaciente ::class.java)
            pantallaDetalles.putExtra("UUID_Paciente", item.UUID_Paciente)
            pantallaDetalles.putExtra("Nombres", item.Nombres)
            context.startActivity(pantallaDetalles)
    }
        }

    

}