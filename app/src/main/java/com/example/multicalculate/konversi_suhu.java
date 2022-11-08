package com.example.multicalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class konversi_suhu extends AppCompatActivity {

    String namaSuhu[] = {"Celcius", "Fahrenheit", "Reamur", "Kelvin"};
    int stateSuhuAwal = 0, stateSuhuAkhir = 1, swapState;
    double hasilCelcius, hasilFahrenheit, hasilReamur, hasilKelvin, hasilKonversiSuhu;

    LinearLayout layoutSuhuAwal, layoutSuhuAkhir;
    ImageView simbolSuhuAwal, simbolSuhuAkhir, iconSwap, imageKetSuhuAwal, imageKetSuhuAkhir;
    TextView textSuhuAwal, textSuhuAkhir, textInputSuhu, textKetSuhuAwal, textKetSuhuAkhir, textHasilSuhuAwal, textHasilSuhuAkhir;
    EditText editInputSuhu;
    Button buttonHitungKonversiSuhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi_suhu);

        layoutSuhuAwal = findViewById(R.id.lytSuhuAwal);
        layoutSuhuAkhir = findViewById(R.id.lytSuhuAkhir);
        iconSwap = findViewById(R.id.icSwap);
        simbolSuhuAwal = findViewById(R.id.smblSuhuAwal);
        simbolSuhuAkhir = findViewById(R.id.smblSuhuAkhir);
        textSuhuAwal = findViewById(R.id.txtSuhuAawal);
        textSuhuAkhir = findViewById(R.id.txtSuhuAkhir);
        textInputSuhu = findViewById(R.id.txtInputSuhu);
        textKetSuhuAwal = findViewById(R.id.txtKetSuhuAwal);
        textKetSuhuAkhir = findViewById(R.id.txtKetSuhuAkhir);
        textHasilSuhuAwal = findViewById(R.id.txtHasilSuhuAwal);
        textHasilSuhuAkhir = findViewById(R.id.txtHasilSuhuAkhir);
        editInputSuhu = findViewById(R.id.etInputSuhu);
        imageKetSuhuAwal = findViewById(R.id.imgKetSuhuAwal);
        imageKetSuhuAkhir = findViewById(R.id.imgKetSuhuAkhir);
        buttonHitungKonversiSuhu = findViewById(R.id.btnHitungKonvSuhu);

        layoutSuhuAwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSuhuAwal++;
                if(stateSuhuAwal>3){
                    stateSuhuAwal = 0;
                }
                ubahIconSuhu("awal");
            }
        });

        layoutSuhuAkhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSuhuAkhir++;
                if(stateSuhuAkhir>3){
                    stateSuhuAkhir = 0;
                }
                ubahIconSuhu("akhir");
            }
        });

        iconSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapState = stateSuhuAwal; stateSuhuAwal = stateSuhuAkhir; stateSuhuAkhir = swapState;
                ubahIconSuhu("awal");
                ubahIconSuhu("akhir");
            }
        });

        buttonHitungKonversiSuhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editInputSuhu.getText().toString().equals("") && !editInputSuhu.getText().toString().equals(".")){
                    konversiSuhu();
                }
                else{
                    Toast.makeText(konversi_suhu.this, "Input suhu masih kosong...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ubahIconSuhu(String suhu){
        if(suhu.equals("awal")){
            if(stateSuhuAwal==0){
                simbolSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
                textSuhuAwal.setText("Celcius");
            }
            else if(stateSuhuAwal==1){
                simbolSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
                textSuhuAwal.setText("Fahrenheit");
            }
            else if(stateSuhuAwal==2){
                simbolSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
                textSuhuAwal.setText("Reamur");
            }
            else if(stateSuhuAwal==3){
                simbolSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
                textSuhuAwal.setText("Kelvin");
            }
            textInputSuhu.setText("Suhu " + textSuhuAwal.getText().toString());
        }
        else if(suhu.equals("akhir")){
            if(stateSuhuAkhir==0){
                simbolSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
                textSuhuAkhir.setText("Celcius");
            }
            else if(stateSuhuAkhir==1){
                simbolSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
                textSuhuAkhir.setText("Fahrenheit");
            }
            else if(stateSuhuAkhir==2){
                simbolSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
                textSuhuAkhir.setText("Reamur");
            }
            else if(stateSuhuAkhir==3){
                simbolSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
                textSuhuAkhir.setText("Kelvin");
            }
        }
    }

    protected void konversiSuhu(){

        if(textSuhuAwal.getText().toString().equals("Celcius")&&textSuhuAkhir.getText().toString().equals("Celcius")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            hasilCelcius = Double.parseDouble(editInputSuhu.getText().toString());
            hasilKonversiSuhu = hasilCelcius;
        }
        else if(textSuhuAwal.getText().toString().equals("Celcius")&&textSuhuAkhir.getText().toString().equals("Fahrenheit")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            hasilFahrenheit = ((9.0/5.0) * Double.parseDouble(editInputSuhu.getText().toString())) + 32.0;
            hasilKonversiSuhu = hasilFahrenheit;
        }
        else if(textSuhuAwal.getText().toString().equals("Celcius")&&textSuhuAkhir.getText().toString().equals("Reamur")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            hasilReamur = (4.0/5.0) * Double.parseDouble(editInputSuhu.getText().toString());
            hasilKonversiSuhu = hasilReamur;
        }
        else if(textSuhuAwal.getText().toString().equals("Celcius")&&textSuhuAkhir.getText().toString().equals("Kelvin")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            hasilKelvin = Double.parseDouble(editInputSuhu.getText().toString()) + 273.0;
            hasilKonversiSuhu = hasilKelvin;
        }
        else if(textSuhuAwal.getText().toString().equals("Fahrenheit")&&textSuhuAkhir.getText().toString().equals("Celcius")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            hasilCelcius = (5.0/9.0) * (Double.parseDouble(editInputSuhu.getText().toString()) - 32.0);
            hasilKonversiSuhu = hasilCelcius;
        }
        else if(textSuhuAwal.getText().toString().equals("Fahrenheit")&&textSuhuAkhir.getText().toString().equals("Fahrenheit")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            hasilFahrenheit = Double.parseDouble(editInputSuhu.getText().toString());
            hasilKonversiSuhu = hasilFahrenheit;
        }
        else if(textSuhuAwal.getText().toString().equals("Fahrenheit")&&textSuhuAkhir.getText().toString().equals("Reamur")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            hasilReamur = (4.0/9.0) * (Double.parseDouble(editInputSuhu.getText().toString()) - 32.0);
            hasilKonversiSuhu = hasilReamur;
        }
        else if(textSuhuAwal.getText().toString().equals("Fahrenheit")&&textSuhuAkhir.getText().toString().equals("Kelvin")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            hasilKelvin = (((5.0/9.0) * (Double.parseDouble(editInputSuhu.getText().toString()) - 32.0)) + 273.0);
            hasilKonversiSuhu = hasilKelvin;
        }
        else if(textSuhuAwal.getText().toString().equals("Reamur")&&textSuhuAkhir.getText().toString().equals("Celcius")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            hasilCelcius = (5.0/4.0) * Double.parseDouble(editInputSuhu.getText().toString());
            hasilKonversiSuhu = hasilCelcius;
        }
        else if(textSuhuAwal.getText().toString().equals("Reamur")&&textSuhuAkhir.getText().toString().equals("Fahrenheit")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            hasilFahrenheit = ((9.0/4.0) * Double.parseDouble(editInputSuhu.getText().toString())) + 32.0;
            hasilKonversiSuhu = hasilFahrenheit;
        }
        else if(textSuhuAwal.getText().toString().equals("Reamur")&&textSuhuAkhir.getText().toString().equals("Reamur")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            hasilReamur = Double.parseDouble(editInputSuhu.getText().toString());
            hasilKonversiSuhu = hasilReamur;
        }
        else if(textSuhuAwal.getText().toString().equals("Reamur")&&textSuhuAkhir.getText().toString().equals("Kelvin")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            hasilKelvin = ((5.0/4.0) * Double.parseDouble(editInputSuhu.getText().toString())) + 273.0;
            hasilKonversiSuhu = hasilKelvin;
        }
        else if(textSuhuAwal.getText().toString().equals("Kelvin")&&textSuhuAkhir.getText().toString().equals("Celcius")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_celcius));
            hasilCelcius = Double.parseDouble(editInputSuhu.getText().toString()) - 273.0;
            hasilKonversiSuhu = hasilCelcius;
        }
        else if(textSuhuAwal.getText().toString().equals("Kelvin")&&textSuhuAkhir.getText().toString().equals("Fahrenheit")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_fahrenheit));
            hasilFahrenheit = ((9.0/5.0)*(Double.parseDouble(editInputSuhu.getText().toString()) - 273.0)) + 32.0;
            hasilKonversiSuhu = hasilFahrenheit;
        }
        else if(textSuhuAwal.getText().toString().equals("Kelvin")&&textSuhuAkhir.getText().toString().equals("Reamur")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_reamur));
            hasilReamur = (4.0/5.0) * (Double.parseDouble(editInputSuhu.getText().toString()) - 273.0);
            hasilKonversiSuhu = hasilReamur;
        }
        else if(textSuhuAwal.getText().toString().equals("Kelvin")&&textSuhuAkhir.getText().toString().equals("Kelvin")){
            imageKetSuhuAwal.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            imageKetSuhuAkhir.setImageDrawable(getResources().getDrawable(R.drawable.satuan_kelvin));
            hasilKelvin = Double.parseDouble(editInputSuhu.getText().toString());
            hasilKonversiSuhu = hasilKelvin;
        }

        textKetSuhuAwal.setText(textSuhuAwal.getText().toString().toUpperCase());
        textHasilSuhuAwal.setText(String.format("%.2f", Double.parseDouble(editInputSuhu.getText().toString())));
        textKetSuhuAkhir.setText(textSuhuAkhir.getText().toString().toUpperCase());
        textHasilSuhuAkhir.setText(String.format("%.2f", hasilKonversiSuhu));
    }
}