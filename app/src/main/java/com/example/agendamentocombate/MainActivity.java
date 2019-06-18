package com.example.agendamentocombate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    List<Usuario> usuario=new ArrayList<Usuario>();
    EditText etUsuario = findViewById(R.id.etUsuario);
    EditText etSenha = findViewById(R.id.etSenha);
    Button btlogin = findViewById(R.id.btLogin);
    String url="http://www.mocky.io/v2/5d02cabd3100005a00ab31a7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadDeDados down=new DownloadDeDados();
        down.execute(url);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                for (int i = 0;i<usuario.size();i++){

                    if (usuario.get(i).getUsuario().equals(etUsuario.getText()) && usuario.get(i).getSenha().equals(etSenha.getText())){
                        if (usuario.get(i).getNivel().equals( "competidor")){
                            Intent intent = new Intent(MainActivity.this, TelaCombateRobosUsuarios.class);
                            ((Intent) intent).putExtra("usuario" , usuario.get(i).toString());
                            startActivity(intent);
                        }
                        else if ((usuario.get(i).getNivel().equals( "organizador"))){
                            Intent intent = new Intent(MainActivity.this, TelaAgendamentoComabate.class);
                            ((Intent) intent).putExtra("usuario" , usuario.get(i).toString());
                            startActivity(intent);
                        }
                    }
                }
                Toast.makeText(MainActivity.this, "ERRO!! usuario nao encontrado", Toast.LENGTH_LONG).show();
            }
        });
    }



    private class DownloadDeDados extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String json = downloadJson(strings[0]);
            if (json == null) {
                Log.e(TAG, "doInBackground: Erro baixando RSS");
            }
            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ParseJson parseJson = new ParseJson();
            parseJson.parseUsuario(s);
            usuario = parseJson.getUsuario();
        }

        private String downloadJson(String urlString) {
            StringBuilder stringBuilder = new StringBuilder();

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int resposta = connection.getResponseCode();
                Log.d(TAG, "downloadJson: O código de resposta foi: " + resposta);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

                int charsLidos;
                char[] inputBuffer = new char[500];
                while (true) {
                    charsLidos = reader.read(inputBuffer);
                    if (charsLidos < 0) {
                        break;
                    }
                    if (charsLidos > 0) {
                        stringBuilder.append(
                                String.copyValueOf(inputBuffer, 0, charsLidos));
                    }
                }
                reader.close();
                return stringBuilder.toString();

            } catch (MalformedURLException e) {
                Log.e(TAG, "downloadJson: URL é inválida " + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "downloadJson: Ocorreu um erro de IO ao baixar dados: "
                        + e.getMessage());
            }
            return null;
        }
    }
}






