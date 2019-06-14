package com.example.agendamentocombate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaAgendamentoComabate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_agendamento_comabate);
    }
    TextView tvRobo1 = findViewById(R.id.tvRobo1);
    TextView tvRobo2 = findViewById(R.id.tvRobo2);
    EditText etData = findViewById(R.id.etData);
    EditText editText4 = findViewById(R.id.etArena);
    Button btSalvar = findViewById(R.id.btSalvar);





}
