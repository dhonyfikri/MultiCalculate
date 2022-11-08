package com.example.multicalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class bbi extends AppCompatActivity {

    Switch switchButton;
    EditText editTinggi, editBerat;
    Button buttonBBI;
    TextView textBeratIdeal, textBeratAnda, textKeteranganKesimpulan, textKesimpulan;

    Double hasilIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbi);

        switchButton = findViewById(R.id.swButton);
        editTinggi = findViewById(R.id.etTinggi);
        editBerat = findViewById(R.id.etBerat);
        buttonBBI = findViewById(R.id.btnBBI);
        textBeratIdeal = findViewById(R.id.txtBeratIdeal);
        textBeratAnda = findViewById(R.id.txtBeratAnda);
        textKeteranganKesimpulan = findViewById(R.id.txtKetKesimpulan);
        textKesimpulan = findViewById(R.id.txtKesimpulan);

        buttonBBI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preCount();
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preCount();
            }
        });
    }

    protected void preCount (){
        String input1 = editTinggi.getText().toString();
        String input2 = editBerat.getText().toString();
        if(input1.length() != 0 && input2.length() != 0){
            double tinggiBadan = Double.parseDouble(editTinggi.getText().toString());
            double beratBadan = Double.parseDouble(editBerat.getText().toString());
            if(!switchButton.isChecked()){
                // ketika pilihan cowok
                hitungBBI(tinggiBadan, beratBadan, "pria");
            }
            else {
                // ketika pilihan cewek
                hitungBBI(tinggiBadan, beratBadan, "wanita");
            }
        }
    }

    protected void hitungBBI(Double tinggi, Double berat, String Sex){
        switch (Sex){
            case "pria":
                hasilIdeal = (tinggi-100)-((tinggi-100)*10/100);
            break;
            case "wanita":
                hasilIdeal = (tinggi-100)-((tinggi-100)*15/100);
            break;
        }
        textBeratIdeal.setText(String.format("%.2f",hasilIdeal) + " Kg");
        textBeratAnda.setText(String.format("%.2f",berat) + " Kg");
        if(berat == hasilIdeal){
            textKesimpulan.setText("Berat Anda Ideal");
        }
        else if(berat > hasilIdeal+5){
            textKesimpulan.setText("Terlalu Gemuk");
        }
        else if(berat < hasilIdeal-5){
            textKesimpulan.setText("Terlalu Kurus");
        }
        else if(berat != hasilIdeal && berat <= hasilIdeal+5 && berat >= hasilIdeal-5){
            textKesimpulan.setText("Jangkauan Ideal");
        }
    }
}