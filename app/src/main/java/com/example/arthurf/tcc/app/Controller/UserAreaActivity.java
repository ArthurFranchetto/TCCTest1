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
    private Morador[] morador;
    private TextView textView;
    public static String nome ;
    public static String email;
    public static String data;
    public static String apartamento ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        listView = (ListView) findViewById(R.id.list);

        textView = (TextView) findViewById(R.id.name);

        Intent intent = getIntent();
        morador = ((ArrayList<Morador>)intent.getSerializableExtra(LoginActivity.MORADORES)).toArray(new Morador[0]);


        String[] opcoes = new String[]{
            "Lista de convidados", "Ocorrências", "Anúncios", "Reunião", "Locação de salão"
        };

        nome = intent.getStringExtra("nome");
        data = intent.getStringExtra("data");
        email = intent.getStringExtra("email");
        apartamento = intent.getStringExtra("apartamento");

       /* morador.setNome(nome);
        morador.setDataNascimento(data);
        morador.setEmail(email);
        morador.setnApartamento(Integer.parseInt(apartamento));*/

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
                    intent = new Intent(UserAreaActivity.this, ListaDeConvidadosActivity.class);
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
