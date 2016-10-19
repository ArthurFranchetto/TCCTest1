package com.example.arthurf.tcc.app.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arthurf.tcc.app.R;

import java.io.IOException;
import java.util.ArrayList;

import model.Morador;
import model.Reuniao;
import network.ReuniaoRequester;

public class UserAreaActivity extends AppCompatActivity {

    ListView listView;
    private Morador morador;
    private TextView textView;
    public static String nome ;
    public static String email;
    public static String data;
    public static int apartamento ;
    public static Boolean validacao;
    final String servidor = "10.0.2.2:8080/tcc_SI_M_12_-_18-10-2016_v1";
    ReuniaoRequester requester;
    Intent intent;
    ProgressBar mProgress;
    ArrayList<Reuniao> reunioes;
    public final static String REUNIOES = "model.Reunião";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        String[] opcoes = new String[]{ "Lista de convidados", "Ocorrências", "Anúncios", "Reunião", "Locação de salão"};

        listView = (ListView) findViewById(R.id.list);

        textView = (TextView) findViewById(R.id.name);

        Intent intent = getIntent();
        morador = (Morador)intent.getSerializableExtra("MORADOR");

        mProgress = (ProgressBar) findViewById(R.id.carregando);
        mProgress.setVisibility(View.INVISIBLE);

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
                Intent intent;


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

                    consultarReuniao(view);

                }else if (itemPosition == 4){
                    intent = new Intent(UserAreaActivity.this, LocacaoActivity.class);
                    UserAreaActivity.this.startActivity(intent);
                }


            }

        });
    }


    public void consultarReuniao(View view) {

        final String pEmail = email;


        requester = new ReuniaoRequester();
        if(requester.isConnected(this)) {
            intent = new Intent(this, ListaReuniao.class);

            mProgress.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        reunioes = requester.get("http://" + servidor + "/ReuniaoAndroid.json", pEmail);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(REUNIOES, reunioes);
                                mProgress.setVisibility(View.INVISIBLE);
                                startActivity(intent);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponível!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
