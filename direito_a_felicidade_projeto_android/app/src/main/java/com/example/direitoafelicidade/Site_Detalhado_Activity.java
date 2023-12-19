package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;

import com.example.direitoafelicidade.R;

import modelDominio.PaginaWeb;

public class Site_Detalhado_Activity extends AppCompatActivity {

    TextView tvNomeSite, tvAutorSite, tvDescricao, tvTematica, tvIndicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_detalhado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvNomeSite = findViewById(R.id.tvNomeSite);
        tvAutorSite = findViewById(R.id.tvAutorSite);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvTematica = findViewById(R.id.tvTematica);
        tvIndicacao = findViewById(R.id.tvIndicacao);

        Intent it = getIntent();

        if(it != null && it.hasExtra("site"))
        {
            PaginaWeb pw = (PaginaWeb) it.getSerializableExtra("site");
            tvNomeSite.setText(pw.getNomeConteudo());
            tvAutorSite.setText(pw.getAutorPagina());
            tvDescricao.setText(pw.getDescricaoConteudo());
            tvTematica.setText(String.valueOf(pw.getTematicaConteudo()));
            tvIndicacao.setText(pw.getDescricaoIndicacao());
        }

    }

}
    