package com.example.fisica_demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Ciclotron extends AppCompatActivity {

    Spinner spinner;
    Double charge, mass, campM, potential, frecuence, period, kinetic, radius, velocity;
    EditText radio, velocidad, campom, potencial, periodo, frecuencia, energia;
    Button calcular;
    boolean corrio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclotron);

        energia = findViewById(R.id.EnegiaKC);
        radio = findViewById(R.id.radioC);
        campom = findViewById(R.id.campoMC);
        potencial = findViewById(R.id.DeltaVC);
        velocidad = findViewById(R.id.velocidadC);
        periodo = findViewById(R.id.periodoC);
        frecuencia = findViewById(R.id.frecuenciaC);
        calcular = findViewById(R.id.buttonC);

        spinner = findViewById(R.id.spinner);
        ArrayList<particulas> particulas = new ArrayList<>();
        particulas.add(new particulas("Electron", -1.60E-19, 9.11E-31, "e-"));
        particulas.add(new particulas("Proton", 1.60E-19, 1.67E-27, "p+"));
        particulas.add(new particulas("Neutron", 0, 1.67E-27, "n"));
        particulas.add(new particulas("Alfa", 3.2E-19, 6.69E-27, "α"));
        particulas.add(new particulas("Deuteron", 1.60E-19, 3.34E-27, "d"));
        particulas.add(new particulas("Positron", 1.60E-19, 9.11E-31, "e+"));

        ArrayAdapter<particulas> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, particulas);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                particulas particula = (particulas) spinner.getSelectedItem();
                String msg = particula.getNombre() + " " + particula.getCarga();
                charge = particula.getCarga();
                mass = particula.getMasa();
                Toast.makeText(Ciclotron.this, msg, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String energiaS = energia.getText().toString();
                String radioS = radio.getText().toString();
                String velocidadS = velocidad.getText().toString();
                String periodoS = periodo.getText().toString();
                String frecuenciaS = frecuencia.getText().toString();
                String campoMS = campom.getText().toString();
                String potencialS = potencial.getText().toString();
                String cargaS = charge.toString();
                String masaS = mass.toString();

                String msj2 = energiaS + " " + radioS + " " + velocidadS + " " + periodoS + " " + frecuenciaS + cargaS + " " + masaS + " " + campoMS + " " + potencialS ;
                Log.d("ciclotronmsj", msj2);

                if (energiaS.isEmpty() & !cargaS.isEmpty() & !masaS.isEmpty() & !campoMS.isEmpty() & !radioS.isEmpty()) {
                    calcularK1();
                    corrio = true;
                } if (energiaS.isEmpty() & !masaS.isEmpty() & !velocidadS.isEmpty() & campoMS.isEmpty() & radioS.isEmpty()) {
                    calcularK2();
                    corrio = true;
                }if (velocidadS.isEmpty() & !cargaS.isEmpty() & !masaS.isEmpty() & !campoMS.isEmpty() & !radioS.isEmpty()) {
                    calcularV1();
                    corrio = true;
                }if (frecuenciaS.isEmpty() & !cargaS.isEmpty() & !masaS.isEmpty() & !campoMS.isEmpty()) {
                    calcularF1();
                    corrio = true;
                }if (periodoS.isEmpty() & !cargaS.isEmpty() & !masaS.isEmpty() & !campoMS.isEmpty()) {
                    calcularP1();
                    corrio = true;
                }if (velocidadS.isEmpty() & !energiaS.isEmpty() & !masaS.isEmpty()) {
                    calcularV2();
                    corrio = true;
                }if (radioS.isEmpty() & !cargaS.isEmpty() & !masaS.isEmpty() & !velocidadS.isEmpty() & !campoMS.isEmpty()) {
                    calcularR1();
                    corrio = true;
                }
                if (campoMS.isEmpty() & !cargaS.isEmpty() & !masaS.isEmpty() & !velocidadS.isEmpty() & !radioS.isEmpty()) {
                    calcularB1();
                    corrio = true;
                }if (potencialS.isEmpty() & !cargaS.isEmpty() & !energiaS.isEmpty()) {
                    calcularPo1();
                    corrio = true;
                }
            }
        });
    }

    private void calcularF1() {
        // q * b / 2pim

        campM = Double.parseDouble(campom.getText().toString());

        frecuence = ((charge * campM) / (2 * Math.PI * mass));

        Log.d("ciclotronmsj2" , String.valueOf(frecuence));

        frecuencia.setText(String.valueOf(frecuence));

    }

    private void calcularP1() {
        // q * b / 2pim

        campM = Double.parseDouble(campom.getText().toString());

        period = ((2 * Math.PI * mass) / (charge * campM));

        Log.d("ciclotronmsj2" , String.valueOf(period));

        periodo.setText(String.valueOf(period));

    }

    public void calcularK1() {
        // q^2 * b^2 * r^2 / 2m

        radius = Double.parseDouble(radio.getText().toString());
        campM = Double.parseDouble(campom.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        kinetic = (Math.pow(charge, 2) * Math.pow(campM, 2) * Math.pow(radius, 2)) ;

        Log.d("ciclotronmsj2" , String.valueOf(kinetic));

        kinetic = kinetic / (2 * mass);

        Log.d("ciclotronmsj2" , String.valueOf(kinetic));

        energia.setText(String.valueOf(kinetic));
    }

    public void calcularK2() {

        // 1/2mv^2
        velocity = Double.parseDouble(velocidad.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        kinetic = (mass * Math.pow(velocity, 2)) / 2 ;

        Log.d("ciclotronmsj2" , String.valueOf(kinetic));

        energia.setText(String.valueOf(kinetic));
    }

    public void calcularV1() {
        // q*b*r / m

        campM = Double.parseDouble(campom.getText().toString());
        radius = Double.parseDouble(radio.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        velocity = (charge * campM * radius) / mass ;

        Log.d("ciclotronmsj2" , String.valueOf(velocity));

        velocidad.setText(String.valueOf(velocity));
    }

    public void calcularR1() {
        // mv/qb

        campM = Double.parseDouble(campom.getText().toString());
        velocity = Double.parseDouble(velocidad.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        radius = (mass * velocity ) / (charge * campM) ;

        Log.d("ciclotronmsj2" , String.valueOf(radius));

        radio.setText(String.valueOf(radius));
    }

    public void calcularB1() {
        // mv/qr

        velocity = Double.parseDouble(velocidad.getText().toString());
        radius = Double.parseDouble(radio.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        campM = (mass  * velocity) / (radius * charge) ;

        Log.d("ciclotronmsj2" , String.valueOf(campM));

        campom.setText(String.valueOf(campM));
    }

    public void calcularV2() {
        // sqr 2k/m

        kinetic = Double.parseDouble(energia.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        velocity = Math.sqrt((2*kinetic)/mass);

        Log.d("ciclotronmsj2" , String.valueOf(velocity));

        velocidad.setText(String.valueOf(velocity));
    }

    public void calcularPo1() {
        // k/q

        kinetic = Double.parseDouble(energia.getText().toString());

        DecimalFormat formato1 = new DecimalFormat("#.0000");

        potential = kinetic / charge;

        Log.d("ciclotronmsj2" , String.valueOf(potential));

        potencial.setText(String.valueOf(potential));
    }
}