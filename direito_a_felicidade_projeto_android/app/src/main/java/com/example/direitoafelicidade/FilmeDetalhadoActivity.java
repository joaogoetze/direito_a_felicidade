package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;
import modelDominio.Filme;

public class FilmeDetalhadoActivity extends AppCompatActivity {

    TextView tvTituloFilme, tvAnoFilme, tvDuracaoFilme, tvSinopse, tvTematica, tvIndicacao, tvPlataformas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_filme_detalhado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTituloFilme = findViewById(R.id.tvTituloFilme);
        tvAnoFilme = findViewById(R.id.tvAnoFilme);
        tvDuracaoFilme = findViewById(R.id.tvDuracaoFilme);
        tvSinopse = findViewById(R.id.tvSinopse);
        tvTematica = findViewById(R.id.tvTematica);
        tvIndicacao = findViewById(R.id.tvIndicacao);
        tvPlataformas = findViewById(R.id.tvPlataformas);

        Intent it = getIntent();

        if(it != null && it.hasExtra("filmes"))
        {
            Filme filme = (Filme) it.getSerializableExtra("filmes");
            tvTituloFilme.setText(filme.getNomeConteudo());
            tvAnoFilme.setText(String.valueOf(filme.getAnoLancamentoFilme()));
            tvDuracaoFilme.setText(String.valueOf(filme.getDuracaoFilme()));
            tvSinopse.setText(filme.getSinopseFilme());
            tvTematica.setText(String.valueOf(filme.getTematicaConteudo()));
            tvIndicacao.setText(filme.getDescricaoIndicacao());
            tvPlataformas.setText(filme.getPlataformaFilme());
        }

    }

}
