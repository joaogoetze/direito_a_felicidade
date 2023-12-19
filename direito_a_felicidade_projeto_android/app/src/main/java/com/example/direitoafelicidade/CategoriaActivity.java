package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CategoriaActivity extends AppCompatActivity {
    Button bYoutube, bAplicativos, bSeries, bFilmes, bLivros, bArtigos, bPaginaWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bYoutube = findViewById(R.id.bYoutube);
        bSeries = findViewById(R.id.bSeries);
        bFilmes = findViewById(R.id.bFilmes);
        bLivros = findViewById(R.id.bLivros);
        bArtigos = findViewById(R.id.bArtigos);
        bAplicativos = findViewById(R.id.bAplicativos);
        bPaginaWeb = findViewById(R.id.bPaginaWeb);



        bYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent novaTela = new Intent(CategoriaActivity.this, TelaYoutubeActivity.class);
                startActivity(novaTela);
            }
        });

        bSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent novaTela = new Intent(CategoriaActivity.this, TelaSeries.class);
                startActivity(novaTela);
            }
        });

        bFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent novaTela = new Intent(CategoriaActivity.this, TelaFilmesActivity.class);
                startActivity(novaTela);
            }
        });

        bLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent novaTela = new Intent(CategoriaActivity.this, TelaLivros.class);
                startActivity(novaTela);
            }
        });

        bArtigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent novaTela = new Intent(CategoriaActivity.this, TelaArtigos.class);
                startActivity(novaTela);
            }
        });

        bAplicativos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent novaTela = new Intent(CategoriaActivity.this, TelaAplicativosActivity.class);
                startActivity(novaTela);
            }
        });

        bPaginaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent novaTela = new Intent (CategoriaActivity.this, TelaSitesActivity.class);
                startActivity(novaTela);
            }
        }
        );


    }


}
