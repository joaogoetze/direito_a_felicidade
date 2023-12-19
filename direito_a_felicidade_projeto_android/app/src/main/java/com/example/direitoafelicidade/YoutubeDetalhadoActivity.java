package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import modelDominio.CanalYoutube;

public class YoutubeDetalhadoActivity extends AppCompatActivity {

    TextView tvNomeCanal, tvDescricaoCanal, tvIndicacaoCanal, tvTematicaCanal, tvLinkCanal;
    ImageView ivCapaCanal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_youtube_detalhado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvNomeCanal = findViewById(R.id.tvNomeCanal);
        tvDescricaoCanal = findViewById(R.id.tvDescricaoCanal);
        tvIndicacaoCanal = findViewById(R.id.tvIndicacaoCanal);
        tvTematicaCanal = findViewById(R.id.tvTematicaCanal);
        tvLinkCanal = findViewById(R.id.tvLinkCanal);
        ivCapaCanal = (ImageView) findViewById(R.id.ivCapaCanal);

        Intent it = getIntent();

        if(it != null && it.hasExtra("canal"))
        {
            CanalYoutube canalYoutube = (CanalYoutube) it.getSerializableExtra("canal");
            tvNomeCanal.setText(canalYoutube.getNomeConteudo());
            Log.d("DentroDetalhado", canalYoutube.getLinkCanal());
            tvDescricaoCanal.setText(canalYoutube.getDescricaoConteudo());
            tvIndicacaoCanal.setText(canalYoutube.getDescricaoIndicacao());
            tvTematicaCanal.setText(String.valueOf(canalYoutube.getTematicaConteudo()));
            tvLinkCanal.setText(canalYoutube.getLinkCanal());
            //ivCapaCanal.setImageBitmap(canalYoutube.getCapaCanal());
            /*ivCapaCanal.setText(canalYoutube.getCapaCanal());*/
        }

    }

}
