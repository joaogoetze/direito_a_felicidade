package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

import modelDominio.PaginaWeb;
import modelDominio.Serie;

public class TelaSeries extends AppCompatActivity {

    RecyclerView rvSeries;
    SeriesAdapter seriesAdapter;
    ArrayList<Serie> listaSeries;
    String urlWebServicesDesenvolvimento = "http:192.168.0.105/direitoafelicidade/projetoAndroid/getSeries.php";
    StringRequest stringRequest;
    RequestQueue requestQueue;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_series);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvSeries = findViewById(R.id.rvSeries);
        requestQueue = Volley.newRequestQueue(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();
        listaSeries = new ArrayList();

        carregaSeries();

    }

    public void carregaSeries()
    {
        stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Busca Series", response);

                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);

                            Log.d("Busca Series", jsonObject.toString());

                            boolean isErro = jsonObject.getBoolean("erro");

                            if(isErro)
                            {
                                Toast.makeText(getApplicationContext(),"Dados inválidos",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                JsonController jsonController = new JsonController();
                                listaSeries = jsonController.obtemSeries(jsonObject,response);
                                Log.d("Teste"," Lista de Series depois de chamar a fução controller " + listaSeries);
                                // Nessa lista acima tem dados

                                if (listaSeries != null)
                                {
                                    Log.d("Teste se entrou no IF", "Lista de sites dentro do IF: " + listaSeries);
                                    seriesAdapter = new SeriesAdapter(listaSeries, trataCliqueItem);
                                    rvSeries.setLayoutManager(new LinearLayoutManager(TelaSeries.this));
                                    rvSeries.setItemAnimator(new DefaultItemAnimator());
                                    rvSeries.setAdapter(seriesAdapter);
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            Log.d("Teste","Exceção no método carregaSeries() " + e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LogLogin",error.getMessage());
            }
        }){
        };
        requestQueue.add(stringRequest);
    }

    SeriesAdapter.SerieOnClickListener trataCliqueItem = new SeriesAdapter.SerieOnClickListener() {
        @Override
        public void onClickSerie(View view, int position) {
            // Aqui o usuário deve ser redirecionado pra outra página que contem as informações do site clicado
            Serie serie = listaSeries.get(position);
            Log.d("Posição: ", listaSeries.get(position).toString());

            Intent it = new Intent(TelaSeries.this, SeriesDetalhadaActivity.class);
            it.putExtra("site",serie);
            startActivity(it);
        }
    };

}
