package com.example.fisica_demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Calcular_Vector extends AppCompatActivity {

    double cos, grades, forceI, forceJ, forceK, charge, forceRes;

    EditText fuerza, carga, campo, velocidad, fuerzares;
    Button calcularV;
    boolean corrio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_vector);

        fuerza = findViewById(R.id.fuerzaVec);
        fuerzares = findViewById(R.id.FuerzaRes);
        carga = findViewById(R.id.cargaV);
        campo = findViewById(R.id.campoMV);
        velocidad = findViewById(R.id.velocidadV);
        calcularV = findViewById(R.id.button2);

        calcularV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fuerzS = fuerza.getText().toString();
                String fuerzResS = fuerzares.getText().toString();
                String cargaS = carga.getText().toString();
                String campoS = campo.getText().toString();
                String velocidadS = velocidad.getText().toString();

                if (fuerzS.isEmpty() & !velocidadS.isEmpty() & !campoS.isEmpty() & !cargaS.isEmpty() & fuerzResS.isEmpty()) {
                    calcularF();
                    corrio = true;
                }  if (cargaS.isEmpty() & !velocidadS.isEmpty() & !campoS.isEmpty() & !fuerzS.isEmpty() & !fuerzResS.isEmpty()) {
                    calcularQ();
                    corrio = true;
                }if(!corrio) {
                    Toast.makeText(getApplicationContext(), R.string.eror, Toast.LENGTH_SHORT).show();
                } if (!fuerzS.isEmpty() & !cargaS.isEmpty() & !campoS.isEmpty() & !velocidadS.isEmpty()) {
                    corrio = true;
                    Toast.makeText(getApplicationContext(), R.string.completos, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void calcularF() {
        charge = Double.parseDouble(carga.getText().toString());
        String campoS = campo.getText().toString();
        String velocidadS = velocidad.getText().toString();
        Double ic, jc, kc, iv, jv, kv, ir, jr, kr;


        DecimalFormat formato1 = new DecimalFormat("#.0000");
        DecimalFormat formato2 = new DecimalFormat("#.00");

        String[] parts = campoS.split(",");
        String IC = parts[0]; // 123
        String JC = parts[1];
        String KC = parts[2];

        String[] parts2 = velocidadS.split(",");
        String IV = parts2[0];
        String JV = parts2[1];
        String KV = parts2[2];

        ic = Double.parseDouble(IC);
        jc = Double.parseDouble(JC);
        kc = Double.parseDouble(KC);

        iv = Double.parseDouble(IV);
        jv = Double.parseDouble(JV);
        kv = Double.parseDouble(KV);

        ir = (jv * kc) - (jc * kv);
        jr = (iv * kc * -1) + (kv * ic);
        kr = (iv * jc) - (jv * ic);

        Log.d("Producto Cruz", ir + " " + jr + " " + kr);

        forceI = (charge * ir);
        forceJ = (charge * jr);
        forceK = (charge * kr);

        fuerza.setText(forceI + "I, " + forceJ + "J, " + forceK + "K" + "  N");

        Double sumaCuadra = Math.pow(forceI, 2) + Math.pow(forceJ, 2) + Math.pow(forceK, 2);

        Log.d("suamacuadrada", String.valueOf(sumaCuadra));

        forceRes = Math.sqrt(sumaCuadra);
        forceRes = Double.parseDouble(formato1.format(forceRes));

        String fuerzaresul = String.valueOf(forceRes);

        cos = Math.acos(forceI / forceRes);

        grades = Math.toDegrees(cos);
        grades = Double.parseDouble(formato2.format(grades));

        fuerzares.setVisibility(View.VISIBLE);
        fuerzares.setText(fuerzaresul + " N " + grades + "°");

    }

    public void calcularQ() {
        String campoS = campo.getText().toString();
        String FuerzS = fuerza.getText().toString();
        String velocidadS = velocidad.getText().toString();
        Double ic, jc, kc, iv, jv, kv, ir, jr, kr, iF, jF, kF, chargeI, chargeJ, chargeK;


        DecimalFormat formato1 = new DecimalFormat("#.00");

        String[] parts = campoS.split(",");
        String IC = parts[0]; // 123
        String JC = parts[1];
        String KC = parts[2];

        String[] parts2 = velocidadS.split(",");
        String IV = parts2[0];
        String JV = parts2[1];
        String KV = parts2[2];

        String[] parts3 = FuerzS.split(",");
        String IF = parts3[0];
        String JF = parts3[1];
        String KF = parts3[2];

        ic = Double.parseDouble(IC);
        jc = Double.parseDouble(JC);
        kc = Double.parseDouble(KC);

        iF = Double.parseDouble(IF);
        jF = Double.parseDouble(JF);
        kF = Double.parseDouble(KF);

        iv = Double.parseDouble(IV);
        jv = Double.parseDouble(JV);
        kv = Double.parseDouble(KV);

        ir = (jv * kc) - (jc * kv);
        jr = (iv * kc * -1) + (kv * ic);
        kr = (iv * jc) - (jv * ic);

        Log.d("Producto Cruz", ir + " " + jr + " " + kr);

        chargeI = (iF / ir);
        chargeJ = (jF / jr);
        chargeK = (kF / kr);

        Log.d("cargas", chargeI + " " + chargeJ + " " + chargeK);

        if (chargeI.equals(chargeJ) & chargeI.equals(chargeK)) {
            charge = Double.parseDouble(formato1.format(chargeI));
            carga.setText(String.valueOf(charge));
        } else {
            Toast.makeText(this, "No se pudo completar la operacion.", Toast.LENGTH_SHORT).show();
        }

    }

}

