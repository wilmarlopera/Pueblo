package com.example.pueblo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    ArrayList<Titiribi> listAtributos = new ArrayList<>();
    RecyclerView list;
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = findViewById(R.id.listCard);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        createList();


    }
    public void cambiarIdioma(String lenguaje)
    {
        Locale idioma = new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configurationTelefono = getResources().getConfiguration();
        configurationTelefono.locale = idioma;
        getBaseContext().getResources().updateConfiguration(configurationTelefono, getBaseContext().getResources().getDisplayMetrics());

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return (true);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id)
        {
            case (R.id.opcion1):

                Intent intent = new Intent(Home.this, Acercade.class);
                startActivity(intent);

                break;
            case (R.id.opcion2):

                cambiarIdioma("es");
                Intent intent2 = new Intent(Home.this, Home.class);
                startActivity(intent2);

                break;
            case (R.id.opcion3):
                cambiarIdioma("en");
                Intent intent3 = new Intent(Home.this, Home.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    public void createList()
    {
        baseDatos.collection("pueblo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String nombre, descripcion, imagen;
                                nombre = document.get("titulo").toString();
                                descripcion = document.get("descripcion").toString();
                                imagen = document.get("foto").toString();

                                listAtributos.add(new Titiribi(nombre, descripcion, imagen));
                                ListaAdaptador listaAdaptador = new ListaAdaptador(listAtributos);
                                list.setAdapter(listaAdaptador);
                            }


                        } else {
                            Toast.makeText(Home.this, "error", Toast.LENGTH_SHORT).show();
                        }

                    }

                });
    }
}