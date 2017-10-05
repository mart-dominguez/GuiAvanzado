package ar.edu.utn.frsf.isi.dam.guiavanzado;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdominguez on 05/10/17.
 */

public class AdaptadorPlatos extends RecyclerView.Adapter<AdaptadorPlatos.PlatosViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private List<Plato> datos;

    public static class PlatosViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitulo;
        private TextView txtSubtitulo;
        private TextView txtPrecio;

        public PlatosViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView)itemView.findViewById(R.id.LblTitulo);
            txtSubtitulo = (TextView)itemView.findViewById(R.id.LblSubTitulo);
            txtPrecio= (TextView)itemView.findViewById(R.id.lblPrecio);
        }

        public void bindPlato(Plato t) {
            txtTitulo.setText(t.getTitulo());
            txtSubtitulo.setText(t.getDescripcion());
            txtPrecio.setText("$"+(t.getPrecio()/1));
        }
    }

    public AdaptadorPlatos(List<Plato> datos) {
        this.datos = datos;
    }

    @Override
    public PlatosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_lista_plato, viewGroup, false);

        itemView.setOnClickListener(this);
        //android:background="?android:attr/selectableItemBackground"

        PlatosViewHolder tvh = new PlatosViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(PlatosViewHolder viewHolder, int pos) {
        Plato item = datos.get(pos);

        viewHolder.bindPlato(item);
    }

    @Override
        public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}