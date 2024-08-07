package ReciclerViewHelper

import Modelo.ClaseConexion
import Modelo.DataClassPacientes
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import manuel.ortega.proyecto_formativo.Activity_DetallePaciente
import manuel.ortega.proyecto_formativo.R

class Adaptador (var Datos: List<DataClassPacientes>) : RecyclerView.Adapter<ViewHolder>() {

    fun actualizarLista(nuevaLista: List<DataClassPacientes>) {
        Datos = nuevaLista
        notifyDataSetChanged()
    }


    fun eliminarRegistro(Nombres: String, position: Int) {
        val listaDatos = Datos.toMutableList()
        listaDatos.removeAt(position)

        GlobalScope.launch(Dispatchers.IO) {
            val objConexion = ClaseConexion().cadenaConexion()
            val deleteProducto = objConexion?.prepareStatement("DELETE FROM TB_Paciente WHERE UUID_Paciente = ?")!!
            deleteProducto.setString(1, Nombres)
            deleteProducto.executeUpdate()
            val commit = objConexion.prepareStatement("COMMIT")!!
            commit.executeUpdate()
        }
        Datos = listaDatos.toList()
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_pacietes_card, parent, false)
        return ViewHolder(vista)
    }

    override fun getItemCount()= Datos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Datos[position]
        holder.textView.text = item.Nombres

        holder.imgBorrar.setOnClickListener {
            val context = holder.itemView.context
            val builder = AlertDialog.Builder(context)
            builder.setTitle("¿Estás seguro?")
            builder.setMessage("¿Deseas en verdad eliminar el registro?")
            builder.setPositiveButton("Sí") { dialog, which ->
                eliminarRegistro(item.Nombres, position)
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        }
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val pantallaDetalles = Intent(context, Activity_DetallePaciente::class.java)
            pantallaDetalles.putExtra("uuidNumero", item.UUID_Paciente)
            pantallaDetalles.putExtra("estado", item.Nombres)
            context.startActivity(pantallaDetalles)
        }
    }
}