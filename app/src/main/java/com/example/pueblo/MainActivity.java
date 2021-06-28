package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Titiribi titiribi;
    ImageView img;
    TextView titulo, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imagen);
        titulo = findViewById(R.id.titulo);
        texto = findViewById(R.id.texto);

        titiribi = (Titiribi) getIntent().getSerializableExtra("datos");

        Picasso.with(MainActivity.this)
                .load(titiribi.getFoto())
                .into(img);
        titulo.setText(titiribi.getTitulo());
        texto.setText(titiribi.getTexto());
    }
}