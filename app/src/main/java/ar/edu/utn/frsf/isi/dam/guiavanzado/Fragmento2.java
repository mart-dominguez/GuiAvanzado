package ar.edu.utn.frsf.isi.dam.guiavanzado;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento2 extends Fragment {
    private RecyclerView myRecyclerView;

    public Fragmento2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        Log.d("APP::FRAGMENTO","EL FRAGMENTO ON VIEW CREATED!!!");
        myRecyclerView = (RecyclerView) getView().findViewById(R.id.RecView);
        final AdaptadorPlatos adaptador = new AdaptadorPlatos(this.generarLista());
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento " + myRecyclerView.getChildPosition(v));
            }
        });

        myRecyclerView.setAdapter(adaptador);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));

        //myRecyclerView.addItemDecoration(
        // new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private List<Plato> generarLista(){
        Random r = new Random();
        List<Plato> datos = new ArrayList<>();
        for(int i=0; i<50; i++){
            Plato p = new Plato("Plato" + i, "Detalle de plato" + i,r.nextDouble()*100);
            datos.add(p);
            Log.d("APP::FRAGMENTO",p.toString());

        }

        return datos;
    }
}
