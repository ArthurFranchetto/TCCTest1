package com.example.arthurf.tcc.app.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import model.Ocorrencia;

public class OcorrenciasActivity extends AppCompatActivity {

    private TextView ocorrencia_txtTipo, ocorrencia_txtData, ocorrencia_txtAssunto, ocorrencia_textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocorrencias);

        ocorrencia_txtTipo = (TextView) findViewById(R.id.ocorrencia_TextTipo2);
        ocorrencia_txtData = (TextView) findViewById(R.id.ocorrencia_textData2);
        ocorrencia_txtAssunto = (TextView) findViewById(R.id.ocorrencia_textAssunto2);
        ocorrencia_textField = (TextView) findViewById(R.id.ocorrencia_textField);

        Intent intent = getIntent();
        final Ocorrencia ocorrencia = (Ocorrencia) intent.getSerializableExtra(ListaDeOcorrenciasActivity.OCORRENCIA);

        ocorrencia_txtTipo.setText(ocorrencia.getTipoOcorrencia());
        ocorrencia_txtData.setText(ocorrencia.getData());
        ocorrencia_txtAssunto.setText(ocorrencia.getAssunto());
        ocorrencia_textField.setText(ocorrencia.getDescricao());
    }

}
