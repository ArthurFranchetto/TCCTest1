package com.example.arthurf.tcc.app.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.arthurf.tcc.app.R;

import java.util.ArrayList;

import model.Anuncio;

public class AnunciosActivity extends AppCompatActivity {

    public ListView list;
    public Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
        list = (ListView) findViewById(R.id.listViewAnuncios);
        list.setAdapter(new VivzAdapter(this));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(AnunciosActivity.this, DescricaoAnuncioActivity.class);
                anuncio = (Anuncio) list.getItemAtPosition(position);
                intent.putExtra("LISTA", anuncio);
                startActivity(intent);

            }

        });

    }


    class VivzAdapter extends BaseAdapter
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
    }

}
