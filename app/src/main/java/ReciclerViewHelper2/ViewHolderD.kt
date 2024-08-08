package ReciclerViewHelper2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import manuel.ortega.proyecto_formativo.R

class ViewHolderD (view: View): RecyclerView.ViewHolder(view) {

        val textView: TextView =view.findViewById(R.id.txt_DatosCard)
        val imgEditar: ImageView =view.findViewById(R.id.img_editar)

}