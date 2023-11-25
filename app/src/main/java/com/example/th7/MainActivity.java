package com.example.th7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioButton Complex,Fraction,Real;
    Button Calculate;

    ArrayList<Object> Numbers= new ArrayList<>();;
    EditText a,b;
    TextView list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.textViewlist);
        Button add = findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addnum();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Failed to ADD number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Calculate = findViewById(R.id.buttonCalculateTotal);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CalculateTotal();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Failed to calculate", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void addnum() {
        Complex= findViewById(R.id.radioComplex);
        Fraction= findViewById(R.id.radioComplex);
        Real = findViewById(R.id.radioReal);
        a= findViewById(R.id.editTextNumber1);
        b= findViewById(R.id.editTextNumber2);
        double aValue = Double.parseDouble(a.getText().toString());
        double bValue = Double.parseDouble(b.getText().toString());

        if (Complex.isChecked()) {
           Complex currentNumber = new Complex(aValue, bValue);
            Numbers.add(currentNumber);
        } else if (Fraction.isChecked()) {
           Fraction currentNumber = new Fraction(aValue,bValue);
            Numbers.add(currentNumber);
        } else if (Real.isChecked()) {
           RealNumber currentNumber = new RealNumber(aValue);
            Numbers.add(currentNumber);
        }
        
        list.setText(Numbers.toString());
        a.setText("");
        b.setText("");
        Complex.setChecked(false);
        Real.setChecked(false);
        Fraction.setChecked(false);
    }
    private void CalculateTotal(){
        int d = 0, e = 0, f = 0;
        String arr = "";
        RealNumber SumNum = new RealNumber(0);
        Fraction SumFrac = new Fraction();
        Complex SumCom = new Complex();
        for (Object number : Numbers) {
            if (number instanceof Number) {
                if (d != 0) {
                    SumNum.add(number);
                    arr+=SumNum + " + " + number + " = " + SumNum;
                    d = 0;
                } else {
                    SumNum = (RealNumber) number;
                    d++;
                }
            }

            if (number instanceof Fraction) {
                if (e != 0) {

                    arr+=SumFrac.toString() + " + " + number.toString() + " = " + SumFrac.add(number).toString();
                    e = 0;
                } else {
                    SumFrac = (Fraction) number;
                    e++;
                }
            }
            if (number instanceof Complex) {
                if (f != 0) {

                    arr+="(" + SumCom.toString() + ") + (" + number.toString() + ") = " + SumCom.add(number).toString();
                    f = 0;
                } else {
                    SumCom = (Complex) number;
                    f++;
                }
            }
        }
        ResultActivity.start(MainActivity.this, arr);
    }

}
