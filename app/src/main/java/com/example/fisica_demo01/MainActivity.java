package com.example.fisica_demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double sin, grades, force, charge, camp, velocity;

    EditText fuerza, carga, campo, angulo, velocidad;
    Button calcular;
    boolean corrio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fuerza = findViewById(R.id.fuerza);
        carga = findViewById(R.id.carga);
        campo = findViewById(R.id.campoM);
        angulo = findViewById(R.id.angulo);
        velocidad = findViewById(R.id.velocidad);
        calcular = findViewById(R.id.button);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fuerzS = fuerza.getText().toString();
                String cargaS = carga.getText().toString();
                String campoS = campo.getText().toString();
                String velocidadS = velocidad.getText().toString();
                String anguloS = angulo.getText().toString();

                if (fuerzS.isEmpty() & !velocidadS.isEmpty() & !campoS.isEmpty() & !anguloS.isEmpty() & !cargaS.isEmpty()) {
                    calcularF();
                    corrio = true;
                }
                if (cargaS.isEmpty() & !fuerzS.isEmpty() & !velocidadS.isEmpty() & !campoS.isEmpty() & !anguloS.isEmpty()) {
                    calcularQ();
                    corrio = true;
                }
                if (campoS.isEmpty() & !fuerzS.isEmpty() & !velocidadS.isEmpty() & !cargaS.isEmpty() & !anguloS.isEmpty()) {
                    calcularB();
                }
                if (velocidadS.isEmpty() & !fuerzS.isEmpty() & !cargaS.isEmpty() & !campoS.isEmpty() & !anguloS.isEmpty()) {
                    calcularV();
                    corrio = true;

                }
                if (anguloS.isEmpty() & !fuerzS.isEmpty() & !cargaS.isEmpty() & !campoS.isEmpty() & !velocidadS.isEmpty()) {
                    calcularA();
                    corrio = true;
                }  if (!anguloS.isEmpty() & !fuerzS.isEmpty() & !cargaS.isEmpty() & !campoS.isEmpty() & !velocidadS.isEmpty()) {
                    corrio = true;
                    Toast.makeText(MainActivity.this, R.string.completos, Toast.LENGTH_SHORT).show();
                }if(!corrio) {
                    Toast.makeText(MainActivity.this, R.string.eror, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void calcularF() {

        grades = Double.parseDouble(angulo.getText().toString());
        charge = Double.parseDouble(carga.getText().toString());
        camp = Double.parseDouble(campo.getText().toString());
        velocity = Double.parseDouble(velocidad.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        double rads = Math.toRadians(grades);

        sin = Math.sin(rads);

        force = charge * velocity * camp * sin;
        force = Double.parseDouble(formato1.format(force));

        fuerza.setText(String.valueOf(force));

    }

    public void calcularB() {

        grades = Double.parseDouble(angulo.getText().toString());
        force = Double.parseDouble(fuerza.getText().toString());
        charge = Double.parseDouble(carga.getText().toString());
        velocity = Double.parseDouble(velocidad.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.00000000000");

        double rads = Math.toRadians(grades);

        sin = Math.sin(rads);

        camp = force / (charge * velocity * sin);
        camp = Double.parseDouble(formato1.format(camp));

        campo.setText(String.valueOf(camp));

    }

    public void calcularV() {

        grades = Double.parseDouble(angulo.getText().toString());
        force = Double.parseDouble(fuerza.getText().toString());
        camp = Double.parseDouble(campo.getText().toString());
        charge = Double.parseDouble(carga.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        double rads = Math.toRadians(grades);

        sin = Math.sin(rads);

        velocity = force / (camp * charge * sin);
        velocity = Double.parseDouble(formato1.format(velocity));

        velocidad.setText(String.valueOf(velocity));

    }

    public void calcularQ() {

        grades = Double.parseDouble(angulo.getText().toString());
        force = Double.parseDouble(fuerza.getText().toString());
        camp = Double.parseDouble(campo.getText().toString());
        velocity = Double.parseDouble(velocidad.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        double rads = Math.toRadians(grades);

        sin = Math.sin(rads);

        charge = force / (camp * velocity * sin);
        charge = Double.parseDouble(formato1.format(charge));

        carga.setText(String.valueOf(charge));

    }

    public void calcularA() {

        charge = Double.parseDouble(carga.getText().toString());
        force = Double.parseDouble(fuerza.getText().toString());
        camp = Double.parseDouble(campo.getText().toString());
        velocity = Double.parseDouble(velocidad.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        Double res = force / (charge * velocity * camp);
        Double rads = Math.asin(res);

        sin = Math.toDegrees(rads);

        sin = Double.parseDouble(formato1.format(sin));

        angulo.setText(String.valueOf(sin));

    }
}