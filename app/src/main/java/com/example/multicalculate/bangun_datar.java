package com.example.multicalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class bangun_datar extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Switch switchModeHitung;
    Spinner spinnerBangunDatar;
    ImageView imageBangunDatar, imageKetSatuan;
    TextView textInput1, textInput2, textInput3, textInput4, textKetModeHasil, textHasilBangunDatar;
    EditText editInput1, editInput2, editInput3, editInput4;
    LinearLayout layoutField1, layoutField2, layoutField3, layoutField4;
    Button buttonHitungBangunDatar;

    double nilai1, nilai2, nilai3, nilai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_datar);

        textInput1 = findViewById(R.id.txtInput1);
        textInput2 = findViewById(R.id.txtInput2);
        textInput3 = findViewById(R.id.txtInput3);
        textInput4 = findViewById(R.id.txtInput4);
        textKetModeHasil = findViewById(R.id.txtKetModeHasil);
        textHasilBangunDatar = findViewById(R.id.txtHasilBangunDatar);
        editInput1 = findViewById(R.id.etInput1);
        editInput2 = findViewById(R.id.etInput2);
        editInput3 = findViewById(R.id.etInput3);
        editInput4 = findViewById(R.id.etInput4);
        layoutField1 = findViewById(R.id.fldInput1);
        layoutField2 = findViewById(R.id.fldInput2);
        layoutField3 = findViewById(R.id.fldInput3);
        layoutField4 = findViewById(R.id.fldInput4);
        imageBangunDatar = findViewById(R.id.imgBangunDatar);
        imageKetSatuan = findViewById(R.id.imgKetSatuan);
        spinnerBangunDatar = (Spinner) findViewById(R.id.spBangunDatar);
        buttonHitungBangunDatar = findViewById(R.id.btnHitungBangunDatar);
        switchModeHitung = findViewById(R.id.swModeHitung);

        ArrayAdapter myAdapter = ArrayAdapter.createFromResource(this, R.array.list_bangun_datar, R.layout.custon_spinner_bgndatar_layout);
        myAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinnerBangunDatar.setAdapter(myAdapter);
        spinnerBangunDatar.setOnItemSelectedListener(this);

        switchModeHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                syncLayout();
            }
        });

        buttonHitungBangunDatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungBangunDatar();
            }
        });

        syncLayout();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Bangun " + spinnerBangunDatar.getSelectedItem().toString() + " Terpilih", Toast.LENGTH_SHORT).show();
        syncLayout();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    protected void syncLayout(){
        setEmptyValue();
        switch (spinnerBangunDatar.getSelectedItem().toString()){
            case "Segitiga":
                imageBangunDatar.setImageDrawable(getResources().getDrawable(R.drawable.segitiga));
                if(!switchModeHitung.isChecked()){
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.VISIBLE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("KELILING " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter));
                    textInput1.setText("Sisi 1");
                    textInput2.setText("Sisi 2");
                    textInput3.setText("Sisi 3");
                }
                else {
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.GONE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("LUAS " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1.setText("Tinggi");
                    textInput2.setText("Alas");
                }
                break;
            case "Persegi":
                imageBangunDatar.setImageDrawable(getResources().getDrawable(R.drawable.persegi));
                if(!switchModeHitung.isChecked()){
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.GONE);
                    layoutField3.setVisibility(View.GONE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("KELILING " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter));
                    textInput1.setText("Sisi");
                }
                else {
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.GONE);
                    layoutField3.setVisibility(View.GONE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("LUAS " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1.setText("Sisi");
                }
                break;
            case "Persegi Panjang":
                imageBangunDatar.setImageDrawable(getResources().getDrawable(R.drawable.persegi_panjang));
                if(!switchModeHitung.isChecked()){
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.GONE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("KELILING " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter));
                    textInput1.setText("Panjang");
                    textInput2.setText("Lebar");
                }
                else {
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.GONE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("LUAS " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1.setText("Panjang");
                    textInput2.setText("Lebar");
                }
                break;
            case "Lingkaran":
                imageBangunDatar.setImageDrawable(getResources().getDrawable(R.drawable.lingkaran));
                if(!switchModeHitung.isChecked()){
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.GONE);
                    layoutField3.setVisibility(View.GONE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("KELILING " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter));
                    textInput1.setText("Diameter");
                }
                else {
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.GONE);
                    layoutField3.setVisibility(View.GONE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("LUAS " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1.setText("Jari-Jari");
                }
                break;
            case "Jajaran Genjang":
                imageBangunDatar.setImageDrawable(getResources().getDrawable(R.drawable.jajar_genjang));
                if(!switchModeHitung.isChecked()){
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.VISIBLE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("KELILING " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter));
                    textInput1.setText("Panjang 1");
                    textInput2.setText("Panjang 2");
                    textInput3.setText("Tinggi");
                }
                else {
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.VISIBLE);
                    layoutField4.setVisibility(View.GONE);
                    textKetModeHasil.setText("LUAS " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1.setText("Panjang 1");
                    textInput2.setText("Panjang 2");
                    textInput3.setText("Tinggi");
                }
                break;
            case "Trapesium":
                imageBangunDatar.setImageDrawable(getResources().getDrawable(R.drawable.trapesium));
                if(!switchModeHitung.isChecked()){
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.VISIBLE);
                    layoutField4.setVisibility(View.VISIBLE);
                    textKetModeHasil.setText("KELILING " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter));
                    textInput1.setText("Panjang");
                    textInput2.setText("Alas 1");
                    textInput3.setText("Alas 2");
                    textInput4.setText("Tinggi");
                }
                else {
                    layoutField1.setVisibility(View.VISIBLE);
                    layoutField2.setVisibility(View.VISIBLE);
                    layoutField3.setVisibility(View.VISIBLE);
                    layoutField4.setVisibility(View.VISIBLE);
                    textKetModeHasil.setText("LUAS " + spinnerBangunDatar.getSelectedItem().toString().toUpperCase());
                    imageKetSatuan.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1.setText("Panjang");
                    textInput2.setText("Alas 1");
                    textInput3.setText("Alas 2");
                    textInput4.setText("Tinggi");
                }
                break;
        }
    }

    protected void setEmptyValue(){
        editInput1.setText("");
        editInput2.setText("");
        editInput3.setText("");
        editInput4.setText("");
        textHasilBangunDatar.setText("0");
    }

    protected void hitungBangunDatar(){
        Double hasil = 0.0, sisiMiring1, sisiMiring2;
        String metode;
        String shape = spinnerBangunDatar.getSelectedItem().toString();
        if(switchModeHitung.isChecked()){
            metode = "luas";
        }
        else {
            metode = "keliling";
        }

        if(metode.equals("keliling")){
            if(shape.equals("Segitiga")){
                if(field1() && field2() && field3()){
                    hasil = nilai1 + nilai2 + nilai3;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Persegi")){
                if(field1()){
                    hasil = nilai1 * 4;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Persegi Panjang")){
                if(field1() && field2()){
                    hasil = (nilai1 * 2) + (nilai2 * 2);
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Lingkaran")){
                if(field1()){
                    hasil = 3.14 * nilai1;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Jajaran Genjang")){
                if(field1() && field2() && field3()){
                    sisiMiring1 = Math.sqrt((nilai3*nilai3) + ((nilai2-nilai1)*(nilai2-nilai1)));
                    hasil = (nilai2 * 2) + (sisiMiring1 * 2);
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Trapesium")){
                if(field1() && field2() && field3() && field4()){
                    sisiMiring1 = Math.sqrt((nilai2*nilai2) + (nilai4*nilai4));
                    sisiMiring2 = Math.sqrt((nilai3*nilai3) + (nilai4*nilai4));
                    hasil = (nilai1 * 2) + sisiMiring1 + sisiMiring2 + nilai2 + nilai3;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if(metode.equals("luas")){
            if(shape.equals("Segitiga")){
                if(field1() && field2()){
                    hasil = nilai1 * nilai2 / 2;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Persegi")){
                if(field1()){
                    hasil = nilai1 * nilai1;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Persegi Panjang")){
                if(field1() && field2()){
                    hasil = nilai1 * nilai2;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Lingkaran")){
                if(field1()){
                    hasil = 3.14 * nilai1 * nilai1;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Jajaran Genjang")){
                if(field1() && field2() && field3()){
                    hasil = (nilai1*nilai3) + ((nilai2-nilai1)*nilai3);
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Trapesium")){
                if(field1() && field2() && field3() && field4()){
                    hasil = (nilai1*nilai4) + (nilai2*nilai4/2) + (nilai3*nilai4/2);
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        textHasilBangunDatar.setText(String.format("%.2f",hasil));
    }

    protected boolean field1(){
        boolean filled = true;
        if(editInput1.getText().toString().equals("")||editInput1.getText().toString().equals(".")) {filled = false;}
        else {
            nilai1 = Double.parseDouble(editInput1.getText().toString());
        }
        return filled;
    }
    protected boolean field2(){
        boolean filled = true;
        if(editInput2.getText().toString().equals("")||editInput2.getText().toString().equals(".")) {filled = false;}
        else {
            nilai2 = Double.parseDouble(editInput2.getText().toString());
        }
        return filled;
    }
    protected boolean field3(){
        boolean filled = true;
        if(editInput3.getText().toString().equals("")||editInput3.getText().toString().equals(".")) {filled = false;}
        else {
            nilai3 = Double.parseDouble(editInput3.getText().toString());
        }
        return filled;
    }
    protected boolean field4(){
        boolean filled = true;
        if(editInput4.getText().toString().equals("")||editInput4.getText().toString().equals(".")) {filled = false;}
        else {
            nilai4 = Double.parseDouble(editInput4.getText().toString());
        }
        return filled;
    }
}