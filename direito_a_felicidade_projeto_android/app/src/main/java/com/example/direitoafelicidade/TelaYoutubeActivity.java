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
import modelDominio.CanalYoutube;

public class TelaYoutubeActivity extends AppCompatActivity {

    RecyclerView rvYoutube;
    YoutubeAdapter youtubeAdapter;
    ArrayList<CanalYoutube> listaYoutube;
    String urlWebServicesDesenvolvimento = "http://192.168.0.102/direitoafelicidade/projetoAndroid/getCanal.php"; // O número deve ser o IPV4 de cada um
    StringRequest stringRequest;
    RequestQueue requestQueue;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_youtube);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvYoutube = findViewById(R.id.rvYoutube);
        requestQueue = Volley.newRequestQueue(this);

        informacoesApp = (InformacoesApp) getApplicationContext();
        listaYoutube = new ArrayList<>();

        carregaCanais();
    }

    public void carregaCanais()
    {
        stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Busca Canais", response);

                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);

                            Log.d("Busca Canais", jsonObject.toString());

                            boolean isErro = jsonObject.getBoolean("erro");

                            if(isErro)
                            {
                                Toast.makeText(getApplicationContext(),"Dados inválidos",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                JsonController jsonController = new JsonController();
                                listaYoutube = jsonController.obtemCanaisYoutube(jsonObject,response);
                                Log.d("Teste"," Lista de Canais depois de chamar a fução controller " + listaYoutube);
                                // Nessa lista acima tem dados

                                if (listaYoutube != null)
                                {
                                    Log.d("Teste se entrou no IF", "Lista de canais dentro do IF: " + listaYoutube);
                                    youtubeAdapter = new YoutubeAdapter(listaYoutube, trataCliqueItem);
                                    rvYoutube.setLayoutManager(new LinearLayoutManager(TelaYoutubeActivity.this));
                                    rvYoutube.setItemAnimator(new DefaultItemAnimator());
                                    rvYoutube.setAdapter(youtubeAdapter);
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            Log.d("Teste","Exceção no método carregaCanais() " + e.getMessage());

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

    YoutubeAdapter.YoutubeOnClickListener trataCliqueItem = new YoutubeAdapter.YoutubeOnClickListener() {
        @Override
        public void onClickYoutube(View view, int position) {
            // Aqui o usuário deve ser redirecionado pra outra página que contem as informações do site clicado
            CanalYoutube canalYoutube = listaYoutube.get(position);
            Log.d("Posição: ", listaYoutube.get(position).toString());

            Intent it = new Intent(TelaYoutubeActivity.this, YoutubeDetalhadoActivity.class);
            it.putExtra("canal",canalYoutube);
            startActivity(it);
        }
    };
}
