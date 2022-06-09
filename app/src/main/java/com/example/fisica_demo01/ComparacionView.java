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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ComparacionView extends AppCompatActivity {
    Double chargeP, massP, chargeE, massE, chargeN, massN, chargeA, massA, chargeD, massD, chargePO, massPO, campM, kinetic, radius;
    float kinetP, kinetE, kinetN, kinetA, kinetD, kinetPO;
    EditText radio, campom;
    Button calcular;
    BarChart barChart;
    boolean corrio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacion_view);

        radio = findViewById(R.id.radioCC);
        campom = findViewById(R.id.campoMCC);
        calcular = findViewById(R.id.buttonCC);
        barChart = findViewById(R.id.barchar);

//Asignar valores a la grafica
        asignvalue();
//Asignar valores a la carga y masa

        chargeP = 1.60E-19;
        massP = 1.67E-27;
        chargeE = -1.60E-19;
        massE = 9.11E-31;
        chargeN = 0.0;
        massN = 1.67E-27;
        chargeA = 3.2E-19;
        massA = 6.69E-27;
        chargeD = 1.60E-19;
        massD = 3.34E-27;
        chargePO = 1.60E-19;
        massPO = 9.11E-31;

        kinetN = 0F;

//Array del Spinner
//        ArrayList<particulas> particulas = new ArrayList<>();
//        particulas.add(new particulas("Electron", -1.60E-19, 9.11E-31, "e-"));
//        particulas.add(new particulas("Proton", 1.60E-19, 1.67E-27, "p+"));
//        particulas.add(new particulas("Neutron", 0, 1.67E-27, "n"));
//        particulas.add(new particulas("Alfa", 3.2E-19, 6.69E-27, "α"));
//        particulas.add(new particulas("Deuteron", 1.60E-19, 3.34E-27, "d"));
//        particulas.add(new particulas("Positron", 1.60E-19, 9.11E-31, "e+"));


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radioS = radio.getText().toString();
                String campoMS = campom.getText().toString();


                String msj2 = radioS + " " + chargeP + " " + massP + " " + campoMS + " ";
                Log.d("ciclotroncompmsj", msj2);

                if (!campoMS.isEmpty() & !radioS.isEmpty()) {
                    calcularKP();
                    corrio = true;
                }
            }
        });

    }

    private void calcularKP() {
        radius = Double.parseDouble(radio.getText().toString());
        campM = Double.parseDouble(campom.getText().toString());
        kinetic = 0.0;

        kinetic = (Math.pow(chargeP, 2) * Math.pow(campM, 2) * Math.pow(radius, 2));

        Log.d("ciclotronP", String.valueOf(kinetic));

        kinetic = kinetic / (2 * massP);

        Log.d("ciclotronP", String.valueOf(kinetic));

        Double energyEV = kinetic / 1.60E-19;

        Log.d("ciclotronP", String.valueOf(energyEV));

        kinetP = energyEV.floatValue();
        Log.d("ciclotronP", String.valueOf(kinetP));
        calcularKE();

    }

    private void calcularKE() {
        radius = Double.parseDouble(radio.getText().toString());
        campM = Double.parseDouble(campom.getText().toString());
        kinetic = 0.0;

        kinetic = (Math.pow(chargeE, 2) * Math.pow(campM, 2) * Math.pow(radius, 2));

        Log.d("ciclotronE", String.valueOf(kinetic));

        kinetic = kinetic / (2 * massE);

        Log.d("ciclotronE", String.valueOf(kinetic));

        Double energyEV = kinetic / 1.60E-19;

        Log.d("ciclotronE", String.valueOf(energyEV));

        kinetE = energyEV.floatValue();

        Log.d("ciclotronE", String.valueOf(kinetE));
        calcularKA();

    }

    private void calcularKA() {
        radius = Double.parseDouble(radio.getText().toString());
        campM = Double.parseDouble(campom.getText().toString());
        kinetic = 0.0;

        kinetic = (Math.pow(chargeA, 2) * Math.pow(campM, 2) * Math.pow(radius, 2));

        Log.d("ciclotronA", String.valueOf(kinetic));

        kinetic = kinetic / (2 * massA);

        Log.d("ciclotronA", String.valueOf(kinetic));

        Double energyEV = kinetic / 1.60E-19;

        Log.d("ciclotronA", String.valueOf(energyEV));

        kinetA = energyEV.floatValue();
        Log.d("ciclotronA", String.valueOf(kinetA));
        calcularKPO();

    }

    private void calcularKPO() {
        radius = Double.parseDouble(radio.getText().toString());
        campM = Double.parseDouble(campom.getText().toString());
        kinetic = 0.0;

        kinetic = (Math.pow(chargePO, 2) * Math.pow(campM, 2) * Math.pow(radius, 2));

        Log.d("ciclotronPO", String.valueOf(kinetic));

        kinetic = kinetic / (2 * massPO);

        Log.d("ciclotronPO", String.valueOf(kinetic));

        Double energyEV = kinetic / 1.60E-19;

        Log.d("ciclotronPO", String.valueOf(energyEV));

        kinetPO = energyEV.floatValue();
        Log.d("ciclotronPO", String.valueOf(kinetPO));
         calcularKD();

    }

    private void calcularKD() {
        radius = Double.parseDouble(radio.getText().toString());
        campM = Double.parseDouble(campom.getText().toString());
        kinetic = 0.0;

        kinetic = (Math.pow(chargeD, 2) * Math.pow(campM, 2) * Math.pow(radius, 2));

        Log.d("ciclotronD", String.valueOf(kinetic));

        kinetic = kinetic / (2 * massD);

        Log.d("ciclotronD", String.valueOf(kinetic));

        Double energyEV = kinetic / 1.60E-19;

        Log.d("ciclotronD", String.valueOf(energyEV));

        kinetD = energyEV.floatValue();
        Log.d("ciclotronD", String.valueOf(kinetD));
        asignvalue();

    }


    private void asignvalue() {
        //Array de la grafica
        ArrayList<BarEntry> BargraphValue = new ArrayList<>();
        BargraphValue.add(new BarEntry(1, kinetP));
        BargraphValue.add(new BarEntry(2, kinetE));
        BargraphValue.add(new BarEntry(3, kinetD));
//        BargraphValue.add(new BarEntry(4, kinetPO));
        BargraphValue.add(new BarEntry(4, kinetA));

        BarDataSet barDataSet = new BarDataSet(BargraphValue, "valores");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(R.color.azul4);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Grafica comparativa");
        barChart.animateY(300);
    }
}
