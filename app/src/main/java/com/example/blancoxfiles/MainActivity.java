package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText Edit1,Edit2;
    Button btn1,btn2;
    TextView TextView;
    ImageView ImageView,ImageView2,ImageView3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edit1 = findViewById(R.id.editTextText);
        Edit2 = findViewById(R.id.editTextTextPassword);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        TextView = findViewById(R.id.textView);
        ImageView = findViewById(R.id.imageView);
        ImageView2 = findViewById(R.id.imageView8);
        ImageView3 = findViewById(R.id.imageView3);
    }
}