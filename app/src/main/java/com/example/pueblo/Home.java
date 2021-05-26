package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Titiribi> listAtributos = new ArrayList<>();
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = findViewById(R.id.listCard);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        createList();
        ListaAdaptador adaptador = new ListaAdaptador(listAtributos);
        list.setAdapter(adaptador);

    }

    public void createList()
    {
        listAtributos.add(new Titiribi("Circo teatro girardot", "Se podría pensar que fue entre los años 1917 y 1920 que se construyó. \n" +
                "Y empieza a prestar su servicio el 25 de diciembre de 1929 con una corrida de toros, parece que para 1936 el teatro empezó a prestar sus servicios como sala de cine, las corridas de toro, que es el espectaculo que más recuerda los habitantes. Por lo general el ganado de las corridas eran prestados o alquilados para las funciones.", R.drawable.circo));
        listAtributos.add(new Titiribi("Hotel el gurmet de la abuela inez", "\n" +
                "Se encuentra estrategicamente ubicado en la centralidad del municipio, presta servicios de alojamiento, restaurante y descando. En el restaurante podrás encontrar: desayunos, almuerzos del día y a la carta, como también diferentes refigerios, jugos, gaseosas y demás.", R.drawable.hotel));
        listAtributos.add(new Titiribi("Parroquia nuestra señora de los dolores", "\n" +
                "Fue construida en el año 1980, allí se encuentra un cuadro de la patrona de los dolores, el cual fue pintado al oleo por el maestro español Benicio Muñoz al parecer de la escuela de los pintores.", R.drawable.parroquia));
    }
}