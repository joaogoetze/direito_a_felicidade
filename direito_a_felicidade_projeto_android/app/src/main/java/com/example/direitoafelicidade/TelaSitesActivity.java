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

public class TelaSitesActivity extends AppCompatActivity {

    RecyclerView rvSites;
    SiteAdapter siteAdapter;
    ArrayList<PaginaWeb> listaPaginasWeb;
    String urlWebServicesDesenvolvimento = "http://192.168.0.105/direitoafelicidade/projetoAndroid/getSites.php"; // O número deve ser o IPV4 de cada máquina
    StringRequest stringRequest;
    RequestQueue requestQueue;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sites);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvSites = findViewById(R.id.rvSites);
        requestQueue = Volley.newRequestQueue(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();
        listaPaginasWeb = new ArrayList<>();

        carregaSites();
    }

    public void carregaSites()
    {
        stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Busca Sites", response);

                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);

                            Log.d("Busca Sites", jsonObject.toString());

                            boolean isErro = jsonObject.getBoolean("erro");

                            if(isErro)
                            {
                                Toast.makeText(getApplicationContext(),"Dados inválidos",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                JsonController jsonController = new JsonController();
                                listaPaginasWeb = jsonController.obtemPaginasWeb(jsonObject,response);
                                Log.d("Teste"," Lista de Sites depois de chamar a fução controller " + listaPaginasWeb);
                                // Nessa lista acima tem dados

                                if (listaPaginasWeb != null)
                                {
                                    Log.d("Teste se entrou no IF", "Lista de sites dentro do IF: " + listaPaginasWeb);
                                    siteAdapter = new SiteAdapter(listaPaginasWeb, trataCliqueItem);
                                    rvSites.setLayoutManager(new LinearLayoutManager(TelaSitesActivity.this));
                                    rvSites.setItemAnimator(new DefaultItemAnimator());
                                    rvSites.setAdapter(siteAdapter);
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

    SiteAdapter.PaginaWebOnClickListener trataCliqueItem = new SiteAdapter.PaginaWebOnClickListener() {
        @Override
        public void onClickPaginaWeb(View view, int position) {
            // Aqui o usuário deve ser redirecionado pra outra página que contem as informações do site clicado
            PaginaWeb pw = listaPaginasWeb.get(position);
            Log.d("Posição: ", listaPaginasWeb.get(position).toString());

            Intent it = new Intent(TelaSitesActivity.this, Site_Detalhado_Activity.class);
            it.putExtra("site",pw);
            startActivity(it);
        }
    };
}