package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText Email, Contra;
    Button btn1;
    ImageView imagen;
    TextView TextView1;
    ProgressBar progressBar;
    String str_Correo, str_Contra;
    String url = "https://stoss-cone.000webhostapp.com/Proyecto_blanco/validar_usuario.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.logo1);
        Email = findViewById(R.id.editTextText);
        Contra = findViewById(R.id.editTextTextPassword);
        btn1 = findViewById(R.id.button);
        TextView1 = findViewById(R.id.volver);
        progressBar = findViewById(R.id.progressBar);

        TextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),register2.class);
                startActivity(intent);
            }
        });
    }

    public void Login(View view) {
        if (Email.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar usuario", Toast.LENGTH_SHORT).show();
        } else if (Contra.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingresar Contraseña", Toast.LENGTH_SHORT).show();
        } else {
            // Mostrar el ProgressBar
            progressBar.setVisibility(View.VISIBLE);

            str_Correo = Email.getText().toString().trim();
            str_Contra = Contra.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Ocultar el ProgressBar
                    progressBar.setVisibility(View.GONE);

                    if (response.equalsIgnoreCase("Ingresaste Correctamente")) {
                        Contra.setText("");
                        Email.setText("");
                        startActivity(new Intent(getApplicationContext(), Inicio.class));
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Ocultar el ProgressBar
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Correo", str_Correo);
                    params.put("password", str_Contra);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);
        }
    }
}