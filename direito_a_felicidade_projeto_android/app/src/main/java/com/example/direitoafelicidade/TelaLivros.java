package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
import modelDominio.Livro;

public class TelaLivros extends AppCompatActivity {

    RecyclerView rvLivros;
    LivroAdapter livroAdapter;
    InformacoesApp informacoesApp;
    ArrayList<Livro> listaLivros;
    String urlWebServicesDesenvolvimento = "http://192.168.0.105/direitoafelicidade/projetoAndroid/getLivros.php";
    StringRequest stringRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_livros);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvLivros = findViewById(R.id.rvLivros);
        requestQueue = Volley.newRequestQueue(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();
        listaLivros = new ArrayList<>();

        carregaLivros();
    }

    public void carregaLivros()
    {
        stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Busca Livros", response);

                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);

                            Log.d("Busca Livros", jsonObject.toString());

                            boolean isErro = jsonObject.getBoolean("erro");

                            if(isErro)
                            {
                                Toast.makeText(getApplicationContext(),"Dados inválidos",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                JsonController jsonController = new JsonController();
                                listaLivros = jsonController.obtemLivros(jsonObject,response);
                                Log.d("Teste"," Lista de Livros depois de chamar a fução controller " + listaLivros);
                                // Nessa lista acima tem dados

                                if (listaLivros != null)
                                {
                                    Log.d("Teste se entrou no IF", "Lista de livros dentro do IF: " + listaLivros);
                                    livroAdapter = new LivroAdapter(listaLivros, trataCliqueItem);
                                    rvLivros.setLayoutManager(new LinearLayoutManager(TelaLivros.this));
                                    rvLivros.setItemAnimator(new DefaultItemAnimator());
                                    rvLivros.setAdapter(livroAdapter);
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            Log.d("Teste","Exceção no método carregaLivros() " + e.getMessage());


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

    LivroAdapter.LivroOnClickListener trataCliqueItem = new LivroAdapter.LivroOnClickListener() {

        @Override
        public void onClickLivro(View view, int position) {
            // Aqui o usuário deve ser redirecionado pra outra página que contem as informações do site clicado
            Livro livro = listaLivros.get(position);

            Intent it = new Intent(TelaLivros.this, LivrosDetalhadoActivity.class);
            it.putExtra("livro",livro);
            startActivity(it);

        }
    };



}
