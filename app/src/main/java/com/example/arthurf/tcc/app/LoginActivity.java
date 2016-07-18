package com.example.arthurf.tcc.app;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsuario = (EditText) findViewById(R.id.edUsuario);
        final EditText etSenha = (EditText) findViewById(R.id.edSenha);

        final Button bAcessar = (Button) findViewById(R.id.btAcessar);

        bAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String usuario = etUsuario.getText().toString();
                final String senha = etSenha.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                String nome = jsonResponse.getString("name");

                                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);

                                intent.putExtra("nome", nome);

                            }else{

                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest = new LoginRequest(usuario, senha, responseListener);
            }
        });

    }

}
