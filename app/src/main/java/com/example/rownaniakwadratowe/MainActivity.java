package com.example.rownaniakwadratowe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {
    EditText paramAet;
    EditText paramBet;
    EditText paramCet;
    EditText wynik1et;
    EditText wynik2et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paramAet = (EditText) findViewById(R.id.paramAet);
        paramBet = (EditText) findViewById(R.id.paramBet);
        paramCet = (EditText) findViewById(R.id.paramCet);
        wynik1et = (EditText) findViewById(R.id.wynik1et);
        wynik2et = (EditText) findViewById(R.id.wynik2et);
    }

    public void click(View view) {
        String as = paramAet.getText().toString().trim();
        String bs = paramBet.getText().toString().trim();
        String cs = paramCet.getText().toString().trim();
        double a = Double.parseDouble(as);
        double b = Double.parseDouble(bs);
        double c = Double.parseDouble(cs);
        double x1, x2;
        double delta = sqrt(pow(b, 2) - 4 * a * c);
        x1 = (-b + delta) / (2 * a);
        x2 = (-b - delta) / (2 * a);
        String wyn1 = String.valueOf(x1);
        String wyn2 = String.valueOf(x2);
        wynik1et.setText(wyn1);
        wynik2et.setText(wyn2);
    }
}