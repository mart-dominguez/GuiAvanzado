package ar.edu.utn.frsf.isi.dam.guiavanzado;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragmento1.OnFragmentInteractionListener {


    @Override
    public void onFragmentInteraction(Integer valor) {

    }

    private String[] opciones;
    private ListView listaMenu;
    private DrawerLayout miDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opciones = getResources().getStringArray(R.array.opcionesMnu);
        listaMenu = (ListView) findViewById(R.id.left_drawer);
        miDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Set the adapter for the list view
        listaMenu.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item
                , opciones));
        // Set the list's click listener
        listaMenu.setOnItemClickListener(clickMenu);
    }
    private ListView.OnItemClickListener clickMenu = new ListView.OnItemClickListener (){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            elegirFragmento(position);
        }
    };


    /** Swaps fragments in the main content view */
    private void elegirFragmento(int position) {

        Fragment fragment =null;
        // Create a new fragment and specify the planet to show based on position
       if(position%2==0) fragment = new Fragmento1();
        else fragment = new Fragmento2();
        Bundle args = new Bundle();
        args.putInt("valor", position);
        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
        listaMenu.setItemChecked(position, true);
        setTitle(opciones[position]);
        miDrawerLayout.closeDrawer(listaMenu);
    }

}
