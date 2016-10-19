package com.example.arthurf.tcc.app.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import model.Reuniao;

public class ReuniaoActivity extends AppCompatActivity {

    private TextView textView;
    public String test;
    public Reuniao reuniao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuniao);
        textView = (TextView) findViewById(R.id.txt_reuniao);

        Intent intent = getIntent();
        final Reuniao reuniao = (Reuniao) intent.getSerializableExtra(ListaReuniao.REUNIAO);

        String s = reuniao.getTitulo();

        textView.setText(s);

    }
}
