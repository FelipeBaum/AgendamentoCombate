package com.example.agendamentocombate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class TelaCombateRobosUsuarios extends AppCompatActivity {
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_combate_robos_usuarios);

        ListView lvLista = findViewById(R.id.lvLista);
        //adapter = new SimpleCursorAdapter(MainActivity.this,
                //R.layout.combaterobousuario);
        //lvLista.setAdapter(adapter);
        //ListView listView = findViewById(R.id.lvCombates);

        //ParseJson parseJson = new ParseJson();
        // parseJson.parse(s);
        // combates = parseJson.getCombate();

        //CombatesAdapter adapter = new combatesAdapter(R.layout.activity_combates_agendados, ParseJson.getcombates());

        //listView.setAdapter(adapter);

    }
}
