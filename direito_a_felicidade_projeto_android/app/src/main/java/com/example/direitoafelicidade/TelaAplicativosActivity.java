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

import modelDominio.Aplicativo;

public class TelaAplicativosActivity extends AppCompatActivity {

    RecyclerView rvAplicativos;
    AplicativoAdapter aplicativoAdapter;
    ArrayList<Aplicativo> listaAplicativos;

    String urlWebServicesDesenvolvimento = "http://192.168.0.105/direitoafelicidade/projetoAndroid/getAplicativos.php"; // O número deve ser o IPV4 de cada um
    StringRequest stringRequest;
    RequestQueue requestQueue;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_aplicativos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvAplicativos = findViewById(R.id.rvAplicativos);
        requestQueue = Volley.newRequestQueue(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();
        listaAplicativos = new ArrayList<>();

        Log.d("Teste"," Chegou aqui!");
        carregaAplicativos();
    }

    public void carregaAplicativos()
    {
        stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Busca Aplicativos", response);

                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);

                            Log.d("Busca Aplicativos", jsonObject.toString());

                            boolean isErro = jsonObject.getBoolean("erro");

                            if(isErro)
                            {
                                Toast.makeText(getApplicationContext(),"Dados inválidos",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                JsonController jsonController = new JsonController();
                                listaAplicativos = jsonController.obtemAplicativos(jsonObject,response);
                                Log.d("Teste"," Lista de Aplicativos depois de chamar a fução controller " + listaAplicativos);
                                // Nessa lista acima tem dados

                                if (listaAplicativos != null)
                                {
                                    Log.d("Teste se entrou no IF", "Lista de aplicativos dentro do IF: " + listaAplicativos);
                                    aplicativoAdapter = new AplicativoAdapter(listaAplicativos, trataCliqueItem);
                                    rvAplicativos.setLayoutManager(new LinearLayoutManager(TelaAplicativosActivity.this));
                                    rvAplicativos.setItemAnimator(new DefaultItemAnimator());
                                    rvAplicativos.setAdapter(aplicativoAdapter);
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            Log.d("Teste","Exceção no método carregaSites() " + e.getMessage());


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


    AplicativoAdapter.AplicativoOnClickListener trataCliqueItem = new AplicativoAdapter.AplicativoOnClickListener() {
        @Override
        public void onClickAplicativo(View view, int position) {
            // Aqui o usuário deve ser redirecionado pra outra página que contem as informações do site clicado
            Aplicativo app = listaAplicativos.get(position);

            Intent it = new Intent(TelaAplicativosActivity.this, AplicativoDetalhadoActivity.class);
            it.putExtra("aplicativo",app);
            startActivity(it);

        }
    };
}
