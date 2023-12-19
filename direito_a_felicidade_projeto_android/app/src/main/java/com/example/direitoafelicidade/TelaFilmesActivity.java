package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.direitoafelicidade.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import modelDominio.Filme;

public class TelaFilmesActivity extends AppCompatActivity {

    RecyclerView rvFilmes;
    FilmeAdapter filmeAdapter;
    ArrayList<Filme> listaFilmes;
    String urlWebServicesDesenvolvimento = "http://192.168.0.105/direitoafelicidade/projetoAndroid/getFilmes.php"; // O número deve ser o IPV4 de cada um
    StringRequest stringRequest;
    RequestQueue requestQueue;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_filmes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvFilmes = findViewById(R.id.rvFilmes);
        requestQueue = Volley.newRequestQueue(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();
        listaFilmes = new ArrayList<>();

        carregaFilmes();

    }

    public void carregaFilmes()
    {
        stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Busca Filmes", response);

                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);

                            Log.d("Busca Filmesss", jsonObject.toString());

                            boolean isErro = jsonObject.getBoolean("erro");

                            if(isErro)
                            {
                                Toast.makeText(getApplicationContext(),"Dados inválidos",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                JsonController jsonController = new JsonController();
                                listaFilmes = jsonController.obtemFilmes(jsonObject,response);
                                Log.d("Teste"," Lista de Filmes depois de chamar a fução controller " + listaFilmes);
                                // Nessa lista acima tem dados

                                if (listaFilmes != null)
                                {
                                    Log.d("Teste se entrou no IF", "Lista de sites dentro do IF: " + listaFilmes);
                                    filmeAdapter = new FilmeAdapter(listaFilmes, trataCliqueItem);
                                    rvFilmes.setLayoutManager(new LinearLayoutManager(TelaFilmesActivity.this));
                                    rvFilmes.setItemAnimator(new DefaultItemAnimator());
                                    rvFilmes.setAdapter(filmeAdapter);
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            Log.d("Teste","Exceção no método carregaFilmes() " + e.getMessage());


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


    FilmeAdapter.FilmeOnClickListener trataCliqueItem = new FilmeAdapter.FilmeOnClickListener() {
        @Override
        public void onClickFilme(View view, int position) {
            // Aqui o usuário deve ser redirecionado pra outra página que contem as informações do site clicado
            Filme filme = listaFilmes.get(position);
            Log.d("Posição: ", listaFilmes.get(position).toString());

            Intent it = new Intent(TelaFilmesActivity.this, FilmeDetalhadoActivity.class);
            it.putExtra("filmes",filme);
            startActivity(it);

        }
    };

}
