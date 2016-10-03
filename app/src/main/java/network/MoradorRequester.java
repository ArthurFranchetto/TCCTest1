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

import model.Morador;

/**
 * Created by ArthurF on 21/08/16.
 */
public class MoradorRequester {

    OkHttpClient client = new OkHttpClient();



    public Morador get(String url, String pEmail, String pPassword) throws IOException{

        Morador morador = new Morador();

        Boolean validacao = false;

        RequestBody formBody = new FormEncodingBuilder() //form
                .add("email", pEmail)
                .add("senha", pPassword)
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

                morador.setNome(item.getString("nome_completo"));
                morador.setDataNascimento(item.getString("data_nascimento"));
                morador.setnApartamento(item.getInt("n_apartamento"));
                morador.setEmail(item.getString("email"));
                morador.setValidacao((Boolean) item.get("validacao"));

            }

        } catch(JSONException e){
            e.printStackTrace();
        }
    finally {
      /*  if(morador == null){
            morador.setEmail("email");
            morador.setnApartamento(0);
            morador.setNome("Sem Nome");
            morador.setDataNascimento("10/10/2010");
            morador.setValidacao(true);
        }*/
    }
        return morador;
}

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}