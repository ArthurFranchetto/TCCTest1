package com.example.arthurf.tcc.app.Controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import java.util.ArrayList;

import model.Ocorrencia;

public class ListaDeOcorrenciasActivity extends AppCompatActivity {

    ListView listView;
    Activity atividade;
    public final static String OCORRENCIA = "model.Ocorrencia";
    Ocorrencia[] ocorrencias;
    ArrayList<String> titulos = new ArrayList<String>();
    Ocorrencia ocorrencia;
    public String titulo;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_ocorrencias);
        textView = (TextView) findViewById(R.id.txt_Lista_DE_ocorrencias);
        atividade = this;

        //pega a mensagem do intent
        Intent intent = getIntent();
        ocorrencias = ((ArrayList<Ocorrencia>)intent.getSerializableExtra(UserAreaActivity.OCORRENCIAS)).toArray(new Ocorrencia[0]);

        //cria o listview de ocorrencias
        listView = (ListView) findViewById(R.id.list_Ocorrencias);

        for (int i = 0; i < ocorrencias.length; i++)
        {
            ocorrencia = ocorrencias[i];
            titulos.add (ocorrencia.getAssunto());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, titulos);


        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, OcorrenciasActivity.class);
                intent.putExtra(OCORRENCIA, ocorrencias[position]);

                startActivity(intent);

            }

        });
    }
}
