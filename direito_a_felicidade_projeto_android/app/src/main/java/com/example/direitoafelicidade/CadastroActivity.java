package com.example.direitoafelicidade;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


public class CadastroActivity extends AppCompatActivity {

    String urlWebServicesDesenvolvimento = "http://192.168.0.112/teste/insertUsuario.php";
    RequestQueue requestQueue;
    Button btnCadastro;
    EditText edtConfirmarSenha, edtSenha, edtEmail, edtNome;
    RadioGroup rgSexo, rgAluno;
    RadioButton rbFem, rbMasc, rbOutro, rbSim, rbNao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCadastro = findViewById(R.id.btnCadastro);
        edtConfirmarSenha = findViewById(R.id.edtConfirmarSenha);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        rgSexo = findViewById(R.id.rgSexo);
        rgAluno = findViewById(R.id.rgAluno);
        rbFem = findViewById(R.id.rbFem);
        rbMasc = findViewById(R.id.rbMasc);
        rbOutro = findViewById(R.id.rbOutro);
        rbSim = findViewById(R.id.rbSim);
        rbNao = findViewById(R.id.rbNao);

        requestQueue = Volley.newRequestQueue(this);
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtNome.getText().toString().equals(""))
                {
                    if(rbMasc.isChecked() || rbFem.isChecked() || rbOutro.isChecked())
                    {
                        if(rbSim.isChecked() || rbNao.isChecked())
                        {
                            if(!edtEmail.getText().toString().equals(""))
                            {
                                if(!edtSenha.getText().toString().equals(""))
                                {
                                    String nome = edtNome.getText().toString();
                                    int sexo;
                                    if(rbMasc.isChecked())
                                    {
                                        sexo = 1;
                                    }
                                    else if(rbFem.isChecked())
                                    {
                                        sexo = 2;
                                    }
                                    else
                                    {
                                        sexo = 3;
                                    }
                                    int ifParticipante;
                                    if(rbSim.isChecked())
                                    {
                                        ifParticipante = 1;
                                    }
                                    else
                                    {
                                        ifParticipante = 2;
                                    }

                                    String email = edtEmail.getText().toString();
                                    String senha = edtSenha.getText().toString();

                                    Usuario usuario = new Usuario(nome, sexo, ifParticipante, email, senha);

                                    cadastrarUsuario(usuario);
                                    Toast.makeText(getApplicationContext(), "Usuário cadastrado", Toast.LENGTH_LONG).show();
                                    Intent novaTela = new Intent(CadastroActivity.this, CategoriaActivity.class);
                                    startActivity(novaTela);
                                    finish();
                                }
                            }
                        }
                    }
                }
            }
        });




    }

    private void cadastrarUsuario(final Usuario usuario)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlWebServicesDesenvolvimento, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("Resposta", response);
                Log.d("Response + ", response);
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d("Objeto: ", jsonObject.toString() );
                    boolean isErro = jsonObject.getBoolean("erro");

                    if (isErro)
                    {
                        Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Log.d("Nova Tela", response);
                        Intent novaTela = new Intent(CadastroActivity.this, CategoriaActivity.class);
                        startActivity(novaTela);
                        finish();
                    }

                }catch (Exception e)
                {
                    Log.v("Cadastro", e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Cadastro", error.getMessage());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String>params = new HashMap<>();
                params.put("nomeUsuario", usuario.getNomeUsuario());
                params.put("generoUsuario", String.valueOf(usuario.getGeneroUsuario()));
                params.put("tipoUsuario", String.valueOf(usuario.getTipoUsuario()));
                params.put("emailUsuario", usuario.getEmailUsuario());
                params.put("senhaUsuario", usuario.getSenhaUsuario());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
