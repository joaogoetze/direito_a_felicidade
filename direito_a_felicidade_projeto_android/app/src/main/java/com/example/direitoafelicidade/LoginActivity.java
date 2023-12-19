package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import modelDominio.Usuario;


public class LoginActivity extends AppCompatActivity {
    Button btnEntrar;
    EditText edtUsuario, edtSenha;
    TextView tvCadastrese, tvEsqueciSenha;
    String urlWebServicesDesenvolvimento = "http://192.168.0.102/direitoafelicidade/projetoAndroid/getUsuarios.php";// O número deve ser o IPV4 de cada um
    StringRequest stringRequest;
    RequestQueue requestQueue;
    InformacoesApp informacoesApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnEntrar = findViewById(R.id.btnEntrar);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        tvEsqueciSenha = findViewById(R.id.tvEsqueciSenha);
        tvCadastrese = findViewById(R.id.tvCadastrese);

        informacoesApp = (InformacoesApp) getApplicationContext();


            requestQueue = Volley.newRequestQueue(this);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean validado = true; //Testa se dados foram digitados

                if (edtUsuario.getText().length()==0)
                {
                    edtUsuario.setError("Campo Usuario Obrigatório");
                    edtUsuario.requestFocus();
                    validado = false;
                }
                if (edtSenha.getText().length()==0)
                {
                    edtSenha.setError("Campo Senha Obrigatório");
                    edtSenha.requestFocus();
                    validado = false;
                } if (validado)
                {
                    Toast.makeText(getApplicationContext(),"Validando seus dados, espere...", Toast.LENGTH_SHORT).show();
                    validarLogin(); //Chama a função que pega o web service
                }

            }
        });
    }
    private void validarLogin()
    {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("LogLogin", response);
                        Log.d("Response + ", response);
                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);
                            Log.d("Objeto: ", jsonObject.toString() );
                            boolean isErro = jsonObject.getBoolean("erro");

                            if (isErro)
                            {
                                Toast.makeText(getApplicationContext(), "Dados invalidos", Toast.LENGTH_LONG).show();
                            }
                            else
                                {
                                    Log.d("Nova Tela", response);
                                    Intent novaTela = new Intent(LoginActivity.this, CategoriaActivity.class);
                                    startActivity(novaTela);
                                    finish();
                            }

                        }catch (Exception e)
                        {
                            Log.v("LogLogin", e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Log.e("LogLogin", error.getMessage());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("emailUsuario", edtUsuario.getText().toString());
                params.put("senhaUsuario", edtSenha.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }


}
