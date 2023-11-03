package com.example.blancoxfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    EditText Email,Contra;
    Button btn1;
    TextView TextView;
    ImageView ImageView,ImageView2,ImageView3;

    String str_Correo,str_Contra;
    String url= "http://localhost/Funciones/validar_usuario.php ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.editTextText);
        Contra = findViewById(R.id.editTextTextPassword);
        btn1 = findViewById(R.id.button);
        TextView = findViewById(R.id.textView);
        ImageView = findViewById(R.id.imageView);
        ImageView2 = findViewById(R.id.imageView8);
        ImageView3 = findViewById(R.id.imageView3);

    }
    public void Login(View view){

        if (Email.getText().toString().equals(" ")){
            Toast.makeText(this, "ingresar usuario", Toast.LENGTH_SHORT).show();
        }
        else if (Contra.getText().toString().equals(" ")){

            Toast.makeText(this, "Ingresar Contrasena", Toast.LENGTH_SHORT).show();
        }
        else{

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("zzz espere");

            progressDialog.show();

            str_Correo = Email.getText().toString().trim();
            str_Contra = Contra.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if (response.equalsIgnoreCase("Ingresaste Correctamente")){
                        Contra.setText("");
                        Email.setText("");

                        startActivity(new Intent(getApplicationContext(), Inicio.class));
                        Toast.makeText(MainActivity.this,response, Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }{

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