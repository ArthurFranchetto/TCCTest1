package network;

import android.content.Context;
import android.net.ConnectivityManager;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import model.Anuncio;
import model.ListaDeConvidados;
import model.Reuniao;

/**
 * Created by ArthurF on 08/10/16.
 */


public class AnuncioRequester {
    OkHttpClient client = new OkHttpClient();

    public ArrayList<Anuncio> get(String url, String pEmail) throws IOException{

        ArrayList<Anuncio> lista = new ArrayList<>();

        RequestBody formBody = new FormEncodingBuilder()
                .add("email", pEmail)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        String jsonStr = response.body().string();

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        try {
            JSONArray root = new JSONArray(jsonStr);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++ ) {
                item = (JSONObject)root.get(i);

                int id = item.getInt("id");
                String nomeMorador = item.getString("nomeMorador");
                String anunciante = item.getString("anunciante");
                String titulo = item.getString("titulo");
                String categoria = item.getString("categoria");
                String descricao = item.getString("descricao");
                int telefone = item.getInt("telefone");
                String email = item.getString("email");
                String data = item.getString("data");

                lista.add(new Anuncio(id, nomeMorador, anunciante, titulo, categoria, descricao, telefone, email, data));
            }
        } catch(JSONException e){
            e.printStackTrace();
        }
        finally {
            if(lista.size() == 0)
                lista.add(new Anuncio(0, "Não encontrado", "Sem anunciante", "Sem titulo", "Sem categoria", "Sem descricao",
               0, "Sem email", "Sem data" ));
        }
        return lista;
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnected();
    }


}

