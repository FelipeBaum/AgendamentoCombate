package com.example.agendamentocombate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TelaCombateRobosUsuarios extends AppCompatActivity {
    private ListView listCombates;
    private List listaCombates = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_combate_robos_usuarios);

        listCombates = findViewById(R.id.lvLista);

        DownloadDeDados downloadDeDados = new DownloadDeDados();
        downloadDeDados.execute("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json");

        listCombates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent=new Intent(TelaCombateRobosUsuarios.this, DetalhesCombates.class);
                ((Intent) intent).putExtra("combate",listaCombates.get(position).toString());
                startActivity(intent);
            }
        });
    }
    private class DownloadDeDados extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String jsonFeed = downloadJson(strings[0]);
            if (jsonFeed == null) {
                Toast.makeText(TelaCombateRobosUsuarios.this, "DownloadError", Toast.LENGTH_SHORT).show();
            }
            return jsonFeed;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            JSONTokener jsonTokener = new JSONTokener(s);
            try {
                JSONObject json = new JSONObject(jsonTokener);
                JSONArray jsonArray = json.getJSONArray("combate");

                for (int i = 0; i < jsonArray.length(); i++) {
                    CombatesList jsoncombates = new CombatesList(
                            jsonArray.getJSONObject(i).getString("nome_robo1"),
                            jsonArray.getJSONObject(i).getString("nome_robo2"),
                            jsonArray.getJSONObject(i).getString("status_robo1"),
                            jsonArray.getJSONObject(i).getString("status_robo2"),
                            jsonArray.getJSONObject(i).getString("data"),
                            jsonArray.getJSONObject(i).getString("arena"));
                    listaCombates.add(jsoncombates);
                }

                CombateAdapter ListAdapter = new CombateAdapter(TelaCombateRobosUsuarios.this,
                        R.layout.combaterobousuario, listaCombates);
                listCombates.setAdapter(ListAdapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private String downloadJson(String urlString) {
            StringBuilder json = new StringBuilder();
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int resposta = connection.getResponseCode();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

                int charsLidos;
                char[] inputBuffer = new char[5000];
                while (true) {
                    charsLidos = reader.read(inputBuffer);
                    if (charsLidos < 0) {
                        break;
                    }
                    if (charsLidos > 0) {
                        json.append(
                                String.copyValueOf(inputBuffer, 0, charsLidos));
                    }
                }
                reader.close();
                return json.toString();

            } catch (MalformedURLException e) {
                Toast.makeText(TelaCombateRobosUsuarios.this, "Invalid URL", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(TelaCombateRobosUsuarios.this, "IO Error In Download", Toast.LENGTH_SHORT).show();
            }
            return null;
        }
    }
}
