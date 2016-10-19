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
import java.util.List;

import model.Reuniao;

public class ListaReuniao extends AppCompatActivity {

    ListView listView;
    Activity atividade;
    public final static String REUNIAO = "model.Reunião";
    Reuniao[] reunioes;
    ArrayList<String> titulos = new ArrayList<String>();
    Reuniao reuniao;
    public String titulo;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reuniao);
        textView = (TextView) findViewById(R.id.editTextListaDeReuniões);
        atividade = this;

        //pega a mensagem do intent
        Intent intent = getIntent();
        reunioes = ((ArrayList<Reuniao>)intent.getSerializableExtra(UserAreaActivity.REUNIOES)).toArray(new Reuniao[0]);

        //cria o listview de reunião
        listView = (ListView) findViewById(R.id.listListaDeReunioes);

        for (int i = 0; i < reunioes.length; i++)
        {
            reuniao = reunioes[i];
            titulos.add (reuniao.getTitulo());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, titulos);


        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, ReuniaoActivity.class);
                intent.putExtra(REUNIAO, reunioes[position]);

                startActivity(intent);

            }

        });
    }
}
