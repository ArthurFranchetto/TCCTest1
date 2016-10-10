package com.example.arthurf.tcc.app.Controller;

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

import model.Morador;

public class UserAreaActivity extends AppCompatActivity {

    ListView listView;
    private Morador morador;
    private TextView textView;
    public static String nome ;
    public static String email;
    public static String data;
    public static int apartamento ;
    public static Boolean validacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        String[] opcoes = new String[]{ "Lista de convidados", "Ocorrências", "Anúncios", "Reunião", "Locação de salão"};

        listView = (ListView) findViewById(R.id.list);

        textView = (TextView) findViewById(R.id.name);

        Intent intent = getIntent();
        morador = (Morador)intent.getSerializableExtra("MORADOR");


        nome = morador.getNome();
        data = morador.getDataNascimento();
        email = morador.getEmail();
        apartamento = morador.getnApartamento();
        validacao = morador.getValidacao();

        textView.setText(nome);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, opcoes);

        listView.setAdapter(adapter);



        // ListView Item Click Listener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;
                Intent intent = new Intent();


                if (itemPosition == 0){
                    intent = new Intent(UserAreaActivity.this, EventosActivity.class);
                    UserAreaActivity.this.startActivity(intent);
                } else if (itemPosition == 1){
                    intent = new Intent(UserAreaActivity.this, OcorrenciasActivity.class);
                    UserAreaActivity.this.startActivity(intent);
                } else if (itemPosition == 2){
                    intent = new Intent(UserAreaActivity.this, AnunciosActivity.class);
                    UserAreaActivity.this.startActivity(intent);
                } else if (itemPosition == 3){
                    intent = new Intent(UserAreaActivity.this, ReuniaoActivity.class);
                    UserAreaActivity.this.startActivity(intent);
                }else if (itemPosition == 4){
                    intent = new Intent(UserAreaActivity.this, LocacaoActivity.class);
                    UserAreaActivity.this.startActivity(intent);
                }


            }

        });
    }
}
