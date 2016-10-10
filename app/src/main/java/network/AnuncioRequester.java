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

import model.ListaDeConvidados;

/**
 * Created by ArthurF on 08/10/16.
 */


public class AnuncioRequester {
    OkHttpClient client = new OkHttpClient();



    public ListaDeConvidados get(String url, String pEmail) throws IOException{

        ListaDeConvidados lista = new ListaDeConvidados();

        RequestBody formBody = new FormEncodingBuilder() //form
                .add("email", pEmail)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        String jsonStr = response.body().string();

        try {
            JSONArray root = new JSONArray(jsonStr);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++ ) {
                item = (JSONObject) root.get(i);

                lista.setId(item.getInt("id"));
                lista.setId_locacao(item.getInt("id_locacao"));
                lista.setNome(item.getString("nome"));
                lista.setData(item.getString("data"));
            }

        } catch(JSONException e){
            e.printStackTrace();
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


