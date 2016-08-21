package network;

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

    public ArrayList<Morador> get(String url, String pEmail) throws IOException{

        ArrayList<Morador> lista = new ArrayList<>();

        RequestBody formBody = new FormEncodingBuilder()
                .add("email", pEmail)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        String jsonStr = response.body().string();

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        try{
            JSONArray root = new JSONArray(jsonStr);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++){
                item = (JSONObject)root.get(i);

                String nome = item.getString("nome");
                String nascimento = item.getString("nascimento");
                String email = item.getString("email");
                int apartamento = item.getInt("apartamento");

                lista.add(new Morador(nome, nascimento, email, apartamento));
            }
        } catch(JSONException e){
            e.printStackTrace();
        }
    finally {
        if(lista.size() == 0)
            lista.add(new Morador(Morador.NAO_ENCONTRADO, "10/10/2010", "email", 0));
    }
    return lista;
}
}