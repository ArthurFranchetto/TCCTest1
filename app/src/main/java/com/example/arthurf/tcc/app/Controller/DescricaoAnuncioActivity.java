package com.example.arthurf.tcc.app.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import model.Anuncio;


public class DescricaoAnuncioActivity extends AppCompatActivity {


    private TextView anuncio_TextTitulo, anuncio_TextAnunciante2, anuncio_TextCategoria2, anuncio_TextTelefone2,
    anuncio_TextEmail2, anuncio_TextData2, anuncio_FieldDescricao;

    private Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_anuncio);

        anuncio_TextTitulo = (TextView) findViewById(R.id.anuncio_TextTitulo);
        anuncio_TextAnunciante2 = (TextView) findViewById(R.id.anuncio_TextAnunciante2);
        anuncio_TextCategoria2 = (TextView) findViewById(R.id.anuncio_TextCategoria2);
        anuncio_TextTelefone2 = (TextView) findViewById(R.id.anuncio_TextTelefone2);
        anuncio_TextEmail2 = (TextView) findViewById(R.id.anuncio_TextEmail2);
        anuncio_TextData2 = (TextView) findViewById(R.id.anuncio_TextData2);
        anuncio_FieldDescricao = (TextView) findViewById(R.id.anuncio_FieldDescricao);

        Intent intent = getIntent();
        final Anuncio anuncio = (Anuncio) intent.getSerializableExtra(AnunciosActivity.ANUNCIO);

        anuncio_TextTitulo.setText(anuncio.getTitles());
        anuncio_TextAnunciante2.setText(anuncio.getAnunciante());
        anuncio_TextCategoria2.setText(anuncio.getCategoria());
        anuncio_TextTelefone2.setText(Integer.toString(anuncio.getTelefone()));
        anuncio_TextEmail2.setText(anuncio.getEmail());
        anuncio_TextData2.setText(anuncio.getData());
        anuncio_FieldDescricao.setText(anuncio.getDescriptions());

    }
}
