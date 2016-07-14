package com.example.arthurf.tcc.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsuario = (EditText) findViewById(R.id.edUsuario);
        final EditText etSenha = (EditText) findViewById(R.id.edSenha);

        final Button bAcessar = (Button) findViewById(R.id.btAcessar);

    }
}
