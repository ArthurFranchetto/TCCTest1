package network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import com.example.arthurf.tcc.app.Controller.ReuniaoActivity;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import model.Reuniao;

/**
 * Created by ArthurF on 18/10/16.
 */
public class ReuniaoRequester {

    OkHttpClient client = new OkHttpClient();

    public ArrayList<Reuniao> get(String url, String pEmail) throws IOException{

        ArrayList<Reuniao> lista = new ArrayList<>();

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

                int id = item.getInt("idReuniao");
                String titulo = item.getString("titulo");
                String pauta = item.getString("pauta");
                String dataInicio = item.getString("dataInicio");
                String dataFim = item.getString("dataFim");

                lista.add(new Reuniao(id, titulo, pauta, dataInicio, dataFim));
            }
        } catch(JSONException e){
            e.printStackTrace();
        }
        finally {
            if(lista.size() == 0)
                lista.add(new Reuniao(0, "Não encontrada", "Sem pauta", "Sem inicio", "Sem fim"));
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

