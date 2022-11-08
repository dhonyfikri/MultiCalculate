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

public class bangun_ruang extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Switch switchModeHitungr;
    Spinner spinnerBangunRuang;
    ImageView imageBangunRuang, imageKetSatuanr;
    TextView textInput1r, textInput2r, textInput3r, textInput4r, textKetModeHasilr, textHasilBangunRuang;
    EditText editInput1r, editInput2r, editInput3r, editInput4r;
    LinearLayout layoutField1r, layoutField2r, layoutField3r, layoutField4r;
    Button buttonHitungBangunRuang;

    double nilai1, nilai2, nilai3, nilai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_ruang);

        textInput1r = findViewById(R.id.txtInput1r);
        textInput2r = findViewById(R.id.txtInput2r);
        textInput3r = findViewById(R.id.txtInput3r);
        textInput4r = findViewById(R.id.txtInput4r);
        textKetModeHasilr = findViewById(R.id.txtKetModeHasilr);
        textHasilBangunRuang = findViewById(R.id.txtHasilBangunRuang);
        editInput1r = findViewById(R.id.etInput1r);
        editInput2r = findViewById(R.id.etInput2r);
        editInput3r = findViewById(R.id.etInput3r);
        editInput4r = findViewById(R.id.etInput4r);
        layoutField1r = findViewById(R.id.fldInput1r);
        layoutField2r = findViewById(R.id.fldInput2r);
        layoutField3r = findViewById(R.id.fldInput3r);
        layoutField4r = findViewById(R.id.fldInput4r);
        imageBangunRuang = findViewById(R.id.imgBangunRuang);
        imageKetSatuanr = findViewById(R.id.imgKetSatuanr);
        spinnerBangunRuang = (Spinner) findViewById(R.id.spBangunRuang);
        buttonHitungBangunRuang = findViewById(R.id.btnHitungBangunRuang);
        switchModeHitungr = findViewById(R.id.swModeHitungr);

        ArrayAdapter myAdapter = ArrayAdapter.createFromResource(this, R.array.list_bangun_ruang, R.layout.custon_spinner_bgndatar_layout);
        myAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinnerBangunRuang.setAdapter(myAdapter);
        spinnerBangunRuang.setOnItemSelectedListener(this);

        switchModeHitungr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                syncLayout();
            }
        });

        buttonHitungBangunRuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungBangunDatar();
            }
        });

        syncLayout();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Bangun " + spinnerBangunRuang.getSelectedItem().toString() + " Terpilih", Toast.LENGTH_SHORT).show();
        syncLayout();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    protected void syncLayout(){
        setEmptyValue();
        switch (spinnerBangunRuang.getSelectedItem().toString()){
            case "Kubus":
                imageBangunRuang.setImageDrawable(getResources().getDrawable(R.drawable.kubus));
                if(!switchModeHitungr.isChecked()){
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.GONE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("LUAS PERMUKAAN " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1r.setText("Sisi");
                }
                else {
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.GONE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("VOLUME " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_kubik));
                    textInput1r.setText("Sisi");
                }
                break;
            case "Balok":
                imageBangunRuang.setImageDrawable(getResources().getDrawable(R.drawable.balok));
                if(!switchModeHitungr.isChecked()){
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.VISIBLE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("LUAS PERMUKAAN " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1r.setText("Panjang");
                    textInput2r.setText("Lebar");
                    textInput3r.setText("Tinggi");
                }
                else {
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.VISIBLE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("VOLUME " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_kubik));
                    textInput1r.setText("Panjang");
                    textInput2r.setText("Lebar");
                    textInput3r.setText("Tinggi");
                }
                break;
            case "Prisma":
                imageBangunRuang.setImageDrawable(getResources().getDrawable(R.drawable.prisma));
                if(!switchModeHitungr.isChecked()){
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.VISIBLE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("LUAS PERMUKAAN " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1r.setText("Panjang");
                    textInput2r.setText("Lebar");
                    textInput3r.setText("Tinggi");
                }
                else {
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.VISIBLE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("VOLUME " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_kubik));
                    textInput1r.setText("Panjang");
                    textInput2r.setText("Lebar");
                    textInput3r.setText("Tinggi");
                }
                break;
            case "Bola":
                imageBangunRuang.setImageDrawable(getResources().getDrawable(R.drawable.bola));
                if(!switchModeHitungr.isChecked()){
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.GONE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("LUAS PERMUKAAN " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1r.setText("Diameter");
                }
                else {
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.GONE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("VOLUME " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_kubik));
                    textInput1r.setText("Diameter");
                }
                break;
            case "Tabung":
                imageBangunRuang.setImageDrawable(getResources().getDrawable(R.drawable.tabung));
                if(!switchModeHitungr.isChecked()){
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("LUAS PERMUKAAN " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1r.setText("Diameter");
                    textInput2r.setText("Tinggi");
                }
                else {
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("VOLUME " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_kubik));
                    textInput1r.setText("Diameter");
                    textInput2r.setText("Tinggi");
                }
                break;
            case "Kerucut":
                imageBangunRuang.setImageDrawable(getResources().getDrawable(R.drawable.kerucut));
                if(!switchModeHitungr.isChecked()){
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("LUAS PERMUKAAN " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_persegi));
                    textInput1r.setText("Diameter");
                    textInput2r.setText("Tinggi");
                }
                else {
                    layoutField1r.setVisibility(View.VISIBLE);
                    layoutField2r.setVisibility(View.VISIBLE);
                    layoutField3r.setVisibility(View.GONE);
                    layoutField4r.setVisibility(View.GONE);
                    textKetModeHasilr.setText("VOLUME " + spinnerBangunRuang.getSelectedItem().toString().toUpperCase());
                    imageKetSatuanr.setImageDrawable(getResources().getDrawable(R.drawable.centimeter_kubik));
                    textInput1r.setText("Diameter");
                    textInput2r.setText("Tinggi");
                }
                break;
        }
    }

    protected void setEmptyValue(){
        editInput1r.setText("");
        editInput2r.setText("");
        editInput3r.setText("");
        editInput4r.setText("");
        textHasilBangunRuang.setText("0");
    }

    protected void hitungBangunDatar(){
        Double hasil = 0.0, sisiMiring1;
        String metode;
        String shape = spinnerBangunRuang.getSelectedItem().toString();
        if(switchModeHitungr.isChecked()){
            metode = "volume";
        }
        else {
            metode = "luas_permukaan";
        }

        if(metode.equals("luas_permukaan")){
            if(shape.equals("Kubus")){
                if(field1()){
                    hasil = (nilai1*nilai1)*6;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Balok")){
                if(field1() && field2() && field3()){
                    hasil = ((nilai1*nilai2)*2) + ((nilai1*nilai3)*2) + ((nilai2*nilai3)*2);
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Prisma")){
                if(field1() && field2() && field3()){
                    sisiMiring1 = Math.sqrt((nilai3*nilai3)+((nilai1/2)*(nilai1/2)));
                    hasil = (nilai1*nilai3/2) + (nilai2*sisiMiring1*2) + (nilai1*nilai2);
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Bola")){
                if(field1()){
                    hasil = 4 * 3.14 * nilai1;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Tabung")){
                if(field1() && field2()){
                    hasil = ((3.14*(nilai1/2)*(nilai1/2))*2) + (3.14*nilai1*nilai2);
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Kerucut")){
                if(field1() && field2()){
                    sisiMiring1 = Math.sqrt(nilai2*nilai2) + ((nilai1/2)*(nilai1/2));
                    hasil = (3.14*(nilai1/2)*sisiMiring1) + (3.14*(nilai1/2)*(nilai1/2));
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if(metode.equals("volume")){
            if(shape.equals("Kubus")){
                if(field1()){
                    hasil = nilai1 * nilai1 * nilai1;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Balok")){
                if(field1() && field2() && field3()){
                    hasil = nilai1 * nilai2 * nilai3;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Prisma")){
                if(field1() && field2() && field3()){
                    hasil = (nilai1/2) * nilai2 * nilai2;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Bola")){
                if(field1()){
                    hasil = (4 * 3.14 * nilai1 * nilai1 * nilai1) /3;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Tabung")){
                if(field1() && field2()){
                    hasil = (3.14*(nilai1/2)*(nilai1/2))*nilai2;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
            else if(shape.equals("Kerucut")){
                if(field1() && field2()){
                    hasil = ((3.14*(nilai1/2.0)*(nilai1/2.0)) * (nilai2)) / 3.0;
                }
                else {
                    Toast.makeText(this, "Fileld Belum Lengkap...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        textHasilBangunRuang.setText(String.format("%.2f",hasil));
    }

    protected boolean field1(){
        boolean filled = true;
        if(editInput1r.getText().toString().equals("")||editInput1r.getText().toString().equals(".")) {filled = false;}
        else {
            nilai1 = Double.parseDouble(editInput1r.getText().toString());
        }
        return filled;
    }
    protected boolean field2(){
        boolean filled = true;
        if(editInput2r.getText().toString().equals("")||editInput2r.getText().toString().equals(".")) {filled = false;}
        else {
            nilai2 = Double.parseDouble(editInput2r.getText().toString());
        }
        return filled;
    }
    protected boolean field3(){
        boolean filled = true;
        if(editInput3r.getText().toString().equals("")||editInput3r.getText().toString().equals(".")) {filled = false;}
        else {
            nilai3 = Double.parseDouble(editInput3r.getText().toString());
        }
        return filled;
    }
    protected boolean field4(){
        boolean filled = true;
        if(editInput4r.getText().toString().equals("")||editInput4r.getText().toString().equals(".")) {filled = false;}
        else {
            nilai4 = Double.parseDouble(editInput4r.getText().toString());
        }
        return filled;
    }
}