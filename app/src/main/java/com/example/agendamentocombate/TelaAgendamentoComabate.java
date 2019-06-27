package com.example.agendamentocombate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaAgendamentoComabate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_agendamento_comabate);

        Intent intent = getIntent();
        String frase = intent.getStringExtra("combate");
        String array[] = new String[8];
        array = frase.split(";");
        tvRobo1 = findViewById(R.id.tvRobo1);
        tvRobo2 = findViewById(R.id.tvRobo2);
        etData = findViewById(R.id.etData);
        editText4 = findViewById(R.id.etArena);
        btSalvar = findViewById(R.id.btSalvar);

        tvRobo1.setText(array[0]);
        tvRobo2.setText(array[1]);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });
    }

    TextView tvRobo1;
    TextView tvRobo2;
    EditText etData;
    EditText editText4;
    Button btSalvar;





}
