package com.example.arthurf.tcc.app.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import org.w3c.dom.Text;

import model.Anuncio;
import model.Morador;

public class DescricaoAnuncioActivity extends AppCompatActivity {

    private Anuncio anuncio;
    private String titles;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_anuncio);

        textView = (TextView) findViewById(R.id.textViewDescricaoAnuncio);

        Intent intent = getIntent();
        anuncio = (Anuncio) intent.getSerializableExtra("LISTA");

        titles = anuncio.getTitles();
        textView.setText(titles);

    }
}
