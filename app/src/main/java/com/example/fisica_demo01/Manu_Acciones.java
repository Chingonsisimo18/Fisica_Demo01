package com.example.fisica_demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Manu_Acciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu_acciones);
    }

    public void calcular_angulo_abrir(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void calcular_vector_abrir(View view) {
        Intent intent = new Intent(getApplicationContext(), Calcular_Vector.class);
        startActivity(intent);
    }

    public void calcular_ciclotron_abrir(View view) {
        Intent intent = new Intent(getApplicationContext(), Ciclotron.class);
        startActivity(intent);
    }

    public void comparacion_ciclotron_abrir(View view) {
        Intent intent = new Intent(getApplicationContext(), ComparacionView.class);
        startActivity(intent);
    }

    public void recursos_abrir(View view) {
        Intent intent = new Intent(getApplicationContext(), recursos.class);
        startActivity(intent);
    }
}