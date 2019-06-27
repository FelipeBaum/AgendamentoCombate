package com.example.agendamentocombate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetalhesCombates extends AppCompatActivity {
private Button btStatus1;
private Button btStatus2;
private TextView tvRobo1;
private TextView tvRobo2;
private TextView tvArena;
private TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_combates);

        Intent intent=getIntent();
        String frase = intent.getStringExtra("combate");
        String array[] = new String[8];
        array = frase.split(";");


        tvArena = findViewById(R.id.tvArena);
        tvData = findViewById(R.id.tvData);
        tvRobo1 = findViewById(R.id.tvRobo1);
        tvRobo2 = findViewById(R.id.tvRobo2);
        btStatus1 = findViewById(R.id.btStatusRobo1);
        btStatus2 = findViewById(R.id.btStatusRobo2);

        tvArena.setText(array[7]);
        tvData.setText(array[6]);
        tvRobo1.setText(array[0]);
        tvRobo2.setText(array[1]);
        btStatus1.setText(array[2]);
        btStatus2.setText(array[3]);
    }
}
