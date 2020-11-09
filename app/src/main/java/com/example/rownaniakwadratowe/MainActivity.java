package com.example.rownaniakwadratowe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {
    EditText paramAet;
    EditText paramBet;
    EditText paramCet;
    TextView wynik1et;
    TextView wynik2et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paramAet = (EditText) findViewById(R.id.paramAet);
        paramBet = (EditText) findViewById(R.id.paramBet);
        paramCet = (EditText) findViewById(R.id.paramCet);
        wynik1et = (TextView) findViewById(R.id.wynik1et);
        wynik2et = (TextView) findViewById(R.id.wynik2et);
        getSupportActionBar().setTitle("Równania kwadratowe");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paramAet.setText("");
                paramBet.setText("");
                paramCet.setText("");
            }
        });
    }

    public void click(View view) {
        String as, bs ,cs;
        double a=0 , b=0, c=0;
        try {
            as = paramAet.getText().toString().trim();
            a = Double.parseDouble(as);
        } catch (NumberFormatException e) { paramAet.setText("0"); }
        try{
            bs = paramBet.getText().toString().trim();
            b = Double.parseDouble(bs);
        } catch (NumberFormatException e) { paramBet.setText("0"); }
        try{
            cs = paramCet.getText().toString().trim();
            c = Double.parseDouble(cs);
        } catch (NumberFormatException e) { paramCet.setText("0"); }
        finally {
            double x1, x2;
            double delta = pow(b, 2) - 4 * a * c;
            if (a != 0 && b != 0 && c != 0) {
                if (delta > 0) {
                    x1 = (-b + sqrt(delta)) / (2 * a);
                    x2 = (-b - sqrt(delta)) / (2 * a);
                    x1 *= 1000;
                    x2 *= 1000;
                    x1 = Math.round(x1);
                    x2 = Math.round(x2);
                    x1 /= 1000;
                    x2 /= 1000;
                    String wyn1 = String.valueOf(x1);
                    String wyn2 = String.valueOf(x2);
                    wynik1et.setText(wyn1);
                    wynik2et.setText(wyn2);
                } else if (delta == 0) {
                    x1 = (-b) / (2 * a);
                    x1 *= 1000;
                    x1 = Math.round(x1);
                    x1 /= 1000;
                    String wyn1 = String.valueOf(x1);
                    wynik1et.setText(wyn1);
                    wynik2et.setText("Brak");
                } else if (delta < 0) {
                    double cz1 = -b / 2*a;
                    double cz2 = sqrt(-delta)/ 2*a;
                    cz1 *= 1000;
                    cz2 *= 1000;
                    cz1 = Math.round(cz1);
                    cz2 = Math.round(cz2);
                    cz1 /= 1000;
                    cz2 /= 1000;
                    String cz1s = String.valueOf(cz1);
                    String cz2s = String.valueOf(cz2);
                    wynik1et.setText(cz1s + " + " + cz2s + "i");
                    wynik2et.setText(cz1s + " - " + cz2s + "i");
                }
            } else if (b == 0 && a != 0 && c != 0) {
                if ((c < 0 || a < 0) && !(c < 0 && a < 0)) {
                    x1 = sqrt(-(c / a));
                    x2 = -(sqrt(-(c / a)));
                    x1 *= 1000;
                    x2 *= 1000;
                    x1 = Math.round(x1);
                    x2 = Math.round(x2);
                    x1 /= 1000;
                    x2 /= 1000;
                    String wyn1 = String.valueOf(x1);
                    String wyn2 = String.valueOf(x2);
                    wynik1et.setText(wyn1);
                    wynik2et.setText(wyn2);
                } else if ((c < 0 && a < 0) || (c > 0 && a > 0)) {
                    double cz1 = sqrt(c/a);
                    double cz2 = -sqrt(c/a);
                    cz1 *= 1000;
                    cz2 *= 1000;
                    cz1 = Math.round(cz1);
                    cz2 = Math.round(cz2);
                    cz1 /= 1000;
                    cz2 /= 1000;
                    String cz1s = String.valueOf(cz1);
                    String cz2s = String.valueOf(cz2);
                    wynik1et.setText(cz1s + "i");
                    wynik2et.setText(cz2s + "i");
                }
            } else if (c == 0 && a != 0 && b != 0) {
                x2 = -b / a;
                x2 *= 1000;
                x2 = Math.round(x2);
                x2 /= 1000;
                String wyn2 = String.valueOf(x2);
                wynik1et.setText("0");
                wynik2et.setText(wyn2);
            } else if (a == 0 && b == 0 && c == 0) {
                wynik1et.setText("0");
                wynik2et.setText("0");
            } else if (a == 0 && c == 0 && b != 0) {
                wynik1et.setText("0");
                wynik2et.setText("0");
            } else if (a != 0 && b == 0 && c == 0) {
                wynik1et.setText("0");
                wynik2et.setText("0");
            } else if (a == 0 && b == 0 && c != 0) {
                wynik1et.setText("Brak");
                wynik2et.setText("Brak");
            } else if (a == 0 && b != 0 && c != 0) {
                x1 = -(c / b);
                x1 *= 1000;
                x1 = Math.round(x1);
                x1 /= 1000;
                String wyn1 = String.valueOf(x1);
                wynik1et.setText(wyn1);
                wynik2et.setText("Brak");
            }
        }
    }
}
