package com.example.agendamentocombate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SetarStatus extends AppCompatActivity {

    private TextView tvNomeRobo;
    private TextView tvCategoria;
    private TextView tvArena;
    private TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setar_status);


        tvArena = findViewById(R.id.tvArena);
        tvData = findViewById(R.id.tvData);
        tvNomeRobo = findViewById(R.id.tvNomeRobo);
        tvCategoria = findViewById(R.id.tvCategoria);


        Intent intent=getIntent();
        String frase = intent.getStringExtra("combate");
        String array[] = new String[8];
        array = frase.split(";");

        tvNomeRobo.setText(array[0]);
        tvCategoria.setText(array[8]);
        tvArena.setText(array[7]);
        tvData.setText(array[6]);
    }
}
