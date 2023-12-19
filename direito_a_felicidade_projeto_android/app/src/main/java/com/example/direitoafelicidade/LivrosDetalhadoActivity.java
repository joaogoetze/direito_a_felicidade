package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import modelDominio.Livro;

public class LivrosDetalhadoActivity extends AppCompatActivity {

    TextView tvNomeLivro, tvAutorLivro, tvAnoLivro, tvGeneroLivro, tvPaginasLivro, tvDescricao, tvTematica, tvIndicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_livros_detalhado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvNomeLivro = findViewById(R.id.tvNomeLivro);
        tvAutorLivro = findViewById(R.id.tvAutorLivro);
        tvAnoLivro = findViewById(R.id.tvAnoLivro);
        tvGeneroLivro = findViewById(R.id.tvGeneroLivro);
        tvPaginasLivro = findViewById(R.id.tvPaginasLivro);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvTematica = findViewById(R.id.tvTematica);
        tvIndicacao = findViewById(R.id.tvIndicacao);

        Intent it = getIntent();

        if(it != null && it.hasExtra("livro"))
        {
            Livro livro = (Livro) it.getSerializableExtra("livro");
            tvNomeLivro.setText(livro.getNomeConteudo());
            tvAutorLivro.setText(livro.getAutorLivro());
            tvAnoLivro.setText(String.valueOf(livro.getAnoLivro()));
            tvGeneroLivro.setText(livro.getGeneroLivro());
            tvPaginasLivro.setText(String.valueOf(livro.getPaginasLivro()));
            tvDescricao.setText(livro.getDescricaoConteudo());
            tvTematica.setText(String.valueOf(livro.getTematicaConteudo()));
            tvIndicacao.setText(livro.getDescricaoIndicacao());
        }
    }

}
