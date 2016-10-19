package com.example.arthurf.tcc.app.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import java.util.ArrayList;

import model.Anuncio;

public class AnunciosActivity extends AppCompatActivity {

    public Anuncio anuncio;
    ListView listView;
    Activity atividade;
    public final static String ANUNCIO = "model.Anuncio";
    Anuncio[] anuncios;
    ArrayList<String> titulos = new ArrayList<String>();
    public String titulo;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);

        listView = (ListView) findViewById(R.id.listViewAnuncios);
        atividade = this;

        //pega a mensagem do intent
        Intent intent = getIntent();
        anuncios = ((ArrayList<Anuncio>)intent.getSerializableExtra(UserAreaActivity.ANUNCIOS)).toArray(new Anuncio[0]);

        //cria o listview de anuncios
        listView = (ListView) findViewById(R.id.listViewAnuncios);

        for (int i = 0; i < anuncios.length; i++)
        {
            anuncio = anuncios[i];
            titulos.add (anuncio.getTitles());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, titulos);


        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DescricaoAnuncioActivity.class);
                intent.putExtra(ANUNCIO, anuncios[position]);

                startActivity(intent);

            }

        });
    }


 /*   class VivzAdapter extends BaseAdapter
    {

        ArrayList<Anuncio> list;
        Context context;

        public VivzAdapter(Context c){
            context = c;

            list = new ArrayList<Anuncio>();
            Resources res = c.getResources();

           String[] titles =  res.getStringArray(R.array.titlesAnuncios);
           String[] description = res.getStringArray(R.array.descriptionAnuncios);
           int[] images = {R.drawable.fuck};

            for(int i = 0; i < titles.length; i++){
                list.add(anuncio = new Anuncio(titles[i], description[i], images[0]));
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
        return list.get(i);
    }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.single_row,viewGroup,false); //contains a ref to the relative layout

            TextView title = (TextView) row.findViewById(R.id.textViewAnuncios);
            TextView description = (TextView) row.findViewById(R.id.textViewAnuncios2);
            ImageView images = (ImageView) row.findViewById(R.id.imageViewAnuncios);

            Anuncio temp = list.get(i);

            title.setText(temp.getTitles());
            description.setText(temp.getDescriptions());
            images.setImageResource(temp.getImages());

            return row;
        }
    }*/

}
