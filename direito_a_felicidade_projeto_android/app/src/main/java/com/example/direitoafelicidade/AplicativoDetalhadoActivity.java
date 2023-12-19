package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.direitoafelicidade.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import modelDominio.Aplicativo;
import modelDominio.PaginaWeb;

public class AplicativoDetalhadoActivity extends AppCompatActivity {

    TextView tvNomeApp, tvDesenvolvedores, tvDescricao, tvDescricaoIndicacao, tvTematica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicativo_detalhado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvNomeApp = findViewById(R.id.tvNomeApp);
        tvDesenvolvedores = findViewById(R.id.tvDesenvolvedores);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvDescricaoIndicacao = findViewById(R.id.tvDescricaoIndicacao);
        tvTematica = findViewById(R.id.tvTematica);

        Intent it = getIntent();

        if(it != null && it.hasExtra("aplicativo"))
        {
            Aplicativo app = (Aplicativo) it.getSerializableExtra("aplicativo");
            tvNomeApp.setText(app.getNomeConteudo());
            tvDesenvolvedores.setText(app.getDesenvolvedorAplicativo());
            tvDescricao.setText(app.getDescricaoConteudo());
            tvDescricaoIndicacao.setText(app.getDescricaoIndicacao());
            tvTematica.setText(String.valueOf(app.getTematicaConteudo()));

        }

    }


    }


