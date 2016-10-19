package com.example.arthurf.tcc.app.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import model.Reuniao;

public class ReuniaoActivity extends AppCompatActivity {

    private TextView txtReuniao, reuniao_DataInicio, reuniao_DataFim,reuniao_Pauta;
    public String test;
    public Reuniao reuniao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuniao);
        txtReuniao = (TextView) findViewById(R.id.txt_reuniao);
        reuniao_DataInicio = (TextView) findViewById(R.id.reuniao_DataInicio);
        reuniao_DataFim = (TextView) findViewById(R.id.reuniao_DataFim);
        reuniao_Pauta = (TextView) findViewById(R.id.reuniao_Pauta);

        Intent intent = getIntent();
        final Reuniao reuniao = (Reuniao) intent.getSerializableExtra(ListaReuniao.REUNIAO);

        txtReuniao.setText(reuniao.getTitulo());
        reuniao_DataInicio.setText(reuniao.getDataI());
        reuniao_DataFim.setText(reuniao.getDataF());
        reuniao_Pauta.setText(reuniao.getPauta());

    }
}
