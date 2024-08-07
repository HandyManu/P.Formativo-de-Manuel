package ReciclerViewHelper

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import manuel.ortega.proyecto_formativo.R

class ViewHolder (view: View): RecyclerView.ViewHolder(view){
    val textView: TextView =view.findViewById(R.id.txt_pacientesCard)
    val imgBorrar: ImageView =view.findViewById(R.id.img_borrar)
}