package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class miperfil extends AppCompatActivity {

    TextView Text1,Text2,Text3,Text4,Text5,Text6,Text7,Text8,Ver1,Ver2,Ver3,Ver4,Ver5;
    ImageView Logo;
    Button Volver, Editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);

        Logo = findViewById(R.id.logo);
        Volver = findViewById(R.id.botonvolver);
        Editar = findViewById(R.id.botoneditar);
        Text1= findViewById(R.id.Text1);
        Text2 = findViewById(R.id.Text2);
        Text3 = findViewById(R.id.Text3);
        Text4 = findViewById(R.id.Text4);
        Text5 = findViewById(R.id.Text5);
        Text6 = findViewById(R.id.Text6);
        Text7 = findViewById(R.id.Text7);
        Text8 = findViewById(R.id.Text8);
        Ver1 = findViewById(R.id.Ver1);
        Ver2 = findViewById(R.id.Ver2);
        Ver3 = findViewById(R.id.Ver3);
        Ver4 = findViewById(R.id.Ver4);
        Ver5 = findViewById(R.id.Ver5);

    }
}