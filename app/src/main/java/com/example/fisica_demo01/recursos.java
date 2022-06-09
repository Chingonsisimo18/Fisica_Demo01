package com.example.fisica_demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class recursos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursos);
    }

    public void abrir_info(View view) {
        String url = "http://www.sc.ehu.es/sbweb/fisica/elecmagnet/ciclotron/ciclo.html#El%20ciclotr%C3%B3n";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void abrir_info2(View view) {
        String url = "http://www.fulviofrisone.com/attachments/article/485/Resnick-Fisica%20Vol%202.pdf";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void link2(View view) {
        String url = "http://jol.liljenzin.se/CYCLOTR/CYCLOANI.HTM";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void link3(View view) {
        String url = "https://gfycat.com/ko/gifs/search/science.+cyclotron";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void link1(View view) {
        String url = "https://gifer.com/en/Vfyv";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}