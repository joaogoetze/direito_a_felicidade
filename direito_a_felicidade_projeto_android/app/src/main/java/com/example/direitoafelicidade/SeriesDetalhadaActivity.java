package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import modelDominio.Serie;

public class SeriesDetalhadaActivity extends AppCompatActivity {

    TextView tvNomeSerie, tvSinopse, tvDescricao, tvTematica, tvIndicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detalhada);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvNomeSerie = findViewById(R.id.tvNomeSerie);
        tvSinopse = findViewById(R.id.tvSinopse);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvTematica = findViewById(R.id.tvTematica);
        tvIndicacao = findViewById(R.id.tvIndicacao);

        Intent it = getIntent();

        if(it != null && it.hasExtra("serie"))
        {
            Serie serie = (Serie) it.getSerializableExtra("serie");
            tvNomeSerie.setText(serie.getNomeConteudo());
            tvSinopse.setText(serie.getSinopseSerie());
            tvDescricao.setText(serie.getDescricaoConteudo());
            tvTematica.setText(serie.getTematicaConteudo());
            tvIndicacao.setText(serie.getDescricaoIndicacao());
        }
    }

}
