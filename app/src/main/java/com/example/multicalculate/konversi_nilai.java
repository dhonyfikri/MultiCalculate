package com.example.multicalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class konversi_nilai extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerJumlahNilai;
    EditText editNilai1, editNilai2, editNilai3, editNilai4, editNilai5, editNilai6, editNilai7 , editNilai8, editNilai9, editNilai10;
    TextView textNilai2, textNilai3, textNilai4, textNilai5, textNilai6, textNilai7 , textNilai8, textNilai9, textNilai10, textMean, textGrade;
    Button buttonGrade;
    double nilai1, nilai2, nilai3, nilai4, nilai5, nilai6, nilai7, nilai8, nilai9, nilai10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi_nilai);

        spinnerJumlahNilai = (Spinner) findViewById(R.id.spJumlahNilai);
        editNilai1 = findViewById(R.id.etNilai1);
        editNilai2 = findViewById(R.id.etNilai2);
        editNilai3 = findViewById(R.id.etNilai3);
        editNilai4 = findViewById(R.id.etNilai4);
        editNilai5 = findViewById(R.id.etNilai5);
        editNilai6 = findViewById(R.id.etNilai6);
        editNilai7 = findViewById(R.id.etNilai7);
        editNilai8 = findViewById(R.id.etNilai8);
        editNilai9 = findViewById(R.id.etNilai9);
        editNilai10 = findViewById(R.id.etNilai10);
        textNilai2 = findViewById(R.id.txtNilai2);
        textNilai3 = findViewById(R.id.txtNilai3);
        textNilai4 = findViewById(R.id.txtNilai4);
        textNilai5 = findViewById(R.id.txtNilai5);
        textNilai6 = findViewById(R.id.txtNilai6);
        textNilai7 = findViewById(R.id.txtNilai7);
        textNilai8 = findViewById(R.id.txtNilai8);
        textNilai9 = findViewById(R.id.txtNilai9);
        textNilai10 = findViewById(R.id.txtNilai10);
        textGrade = findViewById(R.id.txtGrade);
        textMean = findViewById(R.id.txtMean);
        buttonGrade = findViewById(R.id.btnGrade);

        ArrayAdapter myAdapter = ArrayAdapter.createFromResource(this, R.array.jumlah_nilai, R.layout.custon_spinner_layout);
        myAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinnerJumlahNilai.setAdapter(myAdapter);
        spinnerJumlahNilai.setOnItemSelectedListener(this);

        buttonGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//textRataRata.setText(Float.toString(Float.parseFloat(editNilai1.getText().toString()) + Float.parseFloat(editNilai2.getText().toString())));
                if(checkField(Integer.parseInt(spinnerJumlahNilai.getSelectedItem().toString()))){
                    hitungMean(Integer.parseInt(spinnerJumlahNilai.getSelectedItem().toString()));
                }
                else {
                    Toast.makeText(konversi_nilai.this, "Ada nilai yang Kosong...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Jumlah nilai = " + spinnerJumlahNilai.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        switch (spinnerJumlahNilai.getSelectedItem().toString()){
            case "1":
                editNilai2.setVisibility(View.GONE);    textNilai2.setVisibility(View.GONE); editNilai2.setText("");
                editNilai3.setVisibility(View.GONE);    textNilai3.setVisibility(View.GONE); editNilai3.setText("");
                editNilai4.setVisibility(View.GONE);    textNilai4.setVisibility(View.GONE); editNilai4.setText("");
                editNilai5.setVisibility(View.GONE);    textNilai5.setVisibility(View.GONE); editNilai5.setText("");
                editNilai6.setVisibility(View.GONE);    textNilai6.setVisibility(View.GONE); editNilai6.setText("");
                editNilai7.setVisibility(View.GONE);    textNilai7.setVisibility(View.GONE); editNilai7.setText("");
                editNilai8.setVisibility(View.GONE);    textNilai8.setVisibility(View.GONE); editNilai8.setText("");
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "2":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.GONE);    textNilai3.setVisibility(View.GONE); editNilai3.setText("");
                editNilai4.setVisibility(View.GONE);    textNilai4.setVisibility(View.GONE); editNilai4.setText("");
                editNilai5.setVisibility(View.GONE);    textNilai5.setVisibility(View.GONE); editNilai5.setText("");
                editNilai6.setVisibility(View.GONE);    textNilai6.setVisibility(View.GONE); editNilai6.setText("");
                editNilai7.setVisibility(View.GONE);    textNilai7.setVisibility(View.GONE); editNilai7.setText("");
                editNilai8.setVisibility(View.GONE);    textNilai8.setVisibility(View.GONE); editNilai8.setText("");
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "3":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.GONE);    textNilai4.setVisibility(View.GONE); editNilai4.setText("");
                editNilai5.setVisibility(View.GONE);    textNilai5.setVisibility(View.GONE); editNilai5.setText("");
                editNilai6.setVisibility(View.GONE);    textNilai6.setVisibility(View.GONE); editNilai6.setText("");
                editNilai7.setVisibility(View.GONE);    textNilai7.setVisibility(View.GONE); editNilai7.setText("");
                editNilai8.setVisibility(View.GONE);    textNilai8.setVisibility(View.GONE); editNilai8.setText("");
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "4":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.VISIBLE); textNilai4.setVisibility(View.VISIBLE);
                editNilai5.setVisibility(View.GONE);    textNilai5.setVisibility(View.GONE); editNilai5.setText("");
                editNilai6.setVisibility(View.GONE);    textNilai6.setVisibility(View.GONE); editNilai6.setText("");
                editNilai7.setVisibility(View.GONE);    textNilai7.setVisibility(View.GONE); editNilai7.setText("");
                editNilai8.setVisibility(View.GONE);    textNilai8.setVisibility(View.GONE); editNilai8.setText("");
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "5":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.VISIBLE); textNilai4.setVisibility(View.VISIBLE);
                editNilai5.setVisibility(View.VISIBLE); textNilai5.setVisibility(View.VISIBLE);
                editNilai6.setVisibility(View.GONE);    textNilai6.setVisibility(View.GONE); editNilai6.setText("");
                editNilai7.setVisibility(View.GONE);    textNilai7.setVisibility(View.GONE); editNilai7.setText("");
                editNilai8.setVisibility(View.GONE);    textNilai8.setVisibility(View.GONE); editNilai8.setText("");
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case"6":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.VISIBLE); textNilai4.setVisibility(View.VISIBLE);
                editNilai5.setVisibility(View.VISIBLE); textNilai5.setVisibility(View.VISIBLE);
                editNilai6.setVisibility(View.VISIBLE); textNilai6.setVisibility(View.VISIBLE);
                editNilai7.setVisibility(View.GONE);    textNilai7.setVisibility(View.GONE); editNilai7.setText("");
                editNilai8.setVisibility(View.GONE);    textNilai8.setVisibility(View.GONE); editNilai8.setText("");
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "7":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.VISIBLE); textNilai4.setVisibility(View.VISIBLE);
                editNilai5.setVisibility(View.VISIBLE); textNilai5.setVisibility(View.VISIBLE);
                editNilai6.setVisibility(View.VISIBLE); textNilai6.setVisibility(View.VISIBLE);
                editNilai7.setVisibility(View.VISIBLE); textNilai7.setVisibility(View.VISIBLE);
                editNilai8.setVisibility(View.GONE);    textNilai8.setVisibility(View.GONE); editNilai8.setText("");
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "8":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.VISIBLE); textNilai4.setVisibility(View.VISIBLE);
                editNilai5.setVisibility(View.VISIBLE); textNilai5.setVisibility(View.VISIBLE);
                editNilai6.setVisibility(View.VISIBLE); textNilai6.setVisibility(View.VISIBLE);
                editNilai7.setVisibility(View.VISIBLE); textNilai7.setVisibility(View.VISIBLE);
                editNilai8.setVisibility(View.VISIBLE); textNilai8.setVisibility(View.VISIBLE);
                editNilai9.setVisibility(View.GONE);    textNilai9.setVisibility(View.GONE); editNilai9.setText("");
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "9":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.VISIBLE); textNilai4.setVisibility(View.VISIBLE);
                editNilai5.setVisibility(View.VISIBLE); textNilai5.setVisibility(View.VISIBLE);
                editNilai6.setVisibility(View.VISIBLE); textNilai6.setVisibility(View.VISIBLE);
                editNilai7.setVisibility(View.VISIBLE); textNilai7.setVisibility(View.VISIBLE);
                editNilai8.setVisibility(View.VISIBLE); textNilai8.setVisibility(View.VISIBLE);
                editNilai9.setVisibility(View.VISIBLE); textNilai9.setVisibility(View.VISIBLE);
                editNilai10.setVisibility(View.GONE);   textNilai10.setVisibility(View.GONE); editNilai10.setText("");
            break;
            case "10":
                editNilai2.setVisibility(View.VISIBLE); textNilai2.setVisibility(View.VISIBLE);
                editNilai3.setVisibility(View.VISIBLE); textNilai3.setVisibility(View.VISIBLE);
                editNilai4.setVisibility(View.VISIBLE); textNilai4.setVisibility(View.VISIBLE);
                editNilai5.setVisibility(View.VISIBLE); textNilai5.setVisibility(View.VISIBLE);
                editNilai6.setVisibility(View.VISIBLE); textNilai6.setVisibility(View.VISIBLE);
                editNilai7.setVisibility(View.VISIBLE); textNilai7.setVisibility(View.VISIBLE);
                editNilai8.setVisibility(View.VISIBLE); textNilai8.setVisibility(View.VISIBLE);
                editNilai9.setVisibility(View.VISIBLE); textNilai9.setVisibility(View.VISIBLE);
                editNilai10.setVisibility(View.VISIBLE);    textNilai10.setVisibility(View.VISIBLE);
            break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    protected boolean field1(){
        boolean filled = true;
        if(editNilai1.getText().toString().equals("")||editNilai1.getText().toString().equals(".")) {filled = false;}
        else {
            nilai1 = Double.parseDouble(editNilai1.getText().toString());
        }
        return filled;
    }
    protected boolean field2(){
        boolean filled = true;
        if(editNilai2.getText().toString().equals("")||editNilai2.getText().toString().equals(".")) {filled = false;}
        else {
            nilai2 = Double.parseDouble(editNilai2.getText().toString());
        }
        return filled;
    }
    protected boolean field3(){
        boolean filled = true;
        if(editNilai3.getText().toString().equals("")||editNilai3.getText().toString().equals(".")) {filled = false;}
        else {
            nilai3 = Double.parseDouble(editNilai3.getText().toString());
        }
        return filled;
    }
    protected boolean field4(){
        boolean filled = true;
        if(editNilai4.getText().toString().equals("")||editNilai4.getText().toString().equals(".")) {filled = false;}
        else {
            nilai4 = Double.parseDouble(editNilai4.getText().toString());
        }
        return filled;
    }
    protected boolean field5(){
        boolean filled = true;
        if(editNilai5.getText().toString().equals("")||editNilai5.getText().toString().equals(".")) {filled = false;}
        else {
            nilai5 = Double.parseDouble(editNilai5.getText().toString());
        }
        return filled;
    }
    protected boolean field6(){
        boolean filled = true;
        if(editNilai6.getText().toString().equals("")||editNilai6.getText().toString().equals(".")) {filled = false;}
        else {
            nilai6 = Double.parseDouble(editNilai6.getText().toString());
        }
        return filled;
    }
    protected boolean field7(){
        boolean filled = true;
        if(editNilai7.getText().toString().equals("")||editNilai7.getText().toString().equals(".")) {filled = false;}
        else {
            nilai7 = Double.parseDouble(editNilai7.getText().toString());
        }
        return filled;
    }
    protected boolean field8(){
        boolean filled = true;
        if(editNilai8.getText().toString().equals("")||editNilai8.getText().toString().equals(".")) {filled = false;}
        else {
            nilai8 = Double.parseDouble(editNilai8.getText().toString());
        }
        return filled;
    }
    protected boolean field9(){
        boolean filled = true;
        if(editNilai9.getText().toString().equals("")||editNilai9.getText().toString().equals(".")) {filled = false;}
        else {
            nilai9 = Double.parseDouble(editNilai9.getText().toString());
        }
        return filled;
    }
    protected boolean field10(){
        boolean filled = true;
        if(editNilai10.getText().toString().equals("")||editNilai10.getText().toString().equals(".")) {filled = false;}
        else {
            nilai10 = Double.parseDouble(editNilai10.getText().toString());
        }
        return filled;
    }

    protected boolean checkField(int jumlah){
        boolean isFilled = true;
        if(jumlah == 1){
            if(!field1()) isFilled = false;
        }
        else if(jumlah == 2){
            if(!field1()||!field2()) isFilled = false;
        }
        else if(jumlah == 3){
            if(!field1()||!field2()||!field3()) isFilled = false;
        }
        else if(jumlah == 4){
            if(!field1()||!field2()||!field3()||!field4()) isFilled = false;
        }
        else if(jumlah == 5){
            if(!field1()||!field2()||!field3()||!field4()||!field5()) isFilled = false;
        }
        else if(jumlah == 6){
            if(!field1()||!field2()||!field3()||!field4()||!field5()||!field6()) isFilled = false;
        }
        else if(jumlah == 7){
            if(!field1()||!field2()||!field3()||!field4()||!field5()||!field6()||!field7()) isFilled = false;
        }
        else if(jumlah == 8){
            if(!field1()||!field2()||!field3()||!field4()||!field5()||!field6()||!field7()||!field8()) isFilled = false;
        }
        else if(jumlah == 9){
            if(!field1()||!field2()||!field3()||!field4()||!field5()||!field6()||!field7()||!field8()||!field9()) isFilled = false;
        }
        else if(jumlah == 10){
            if(!field1()||!field2()||!field3()||!field4()||!field5()||!field6()||!field7()||!field8()||!field9()||!field10()) isFilled = false;
        }
        return isFilled;
    }

//    protected void hitungMean(int jumlah){
//        switch (jumlah){
//            case 1:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", Float.parseFloat(editNilai1.getText().toString())))));
//                break;
//            case 2:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())) / 2))));
//                break;
//            case 3:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())) / 3))));
//                break;
//            case 4:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())
//                        + Float.parseFloat(editNilai4.getText().toString())) / 4))));
//                break;
//            case 5:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())
//                        + Float.parseFloat(editNilai4.getText().toString())
//                        + Float.parseFloat(editNilai5.getText().toString())) / 5))));
//                break;
//            case 6:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())
//                        + Float.parseFloat(editNilai4.getText().toString())
//                        + Float.parseFloat(editNilai5.getText().toString())
//                        + Float.parseFloat(editNilai6.getText().toString())) / 6))));
//                break;
//            case 7:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())
//                        + Float.parseFloat(editNilai4.getText().toString())
//                        + Float.parseFloat(editNilai5.getText().toString())
//                        + Float.parseFloat(editNilai6.getText().toString())
//                        + Float.parseFloat(editNilai7.getText().toString())) / 7))));
//                break;
//            case 8:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())
//                        + Float.parseFloat(editNilai4.getText().toString())
//                        + Float.parseFloat(editNilai5.getText().toString())
//                        + Float.parseFloat(editNilai6.getText().toString())
//                        + Float.parseFloat(editNilai7.getText().toString())
//                        + Float.parseFloat(editNilai8.getText().toString())) / 8))));
//                break;
//            case 9:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())
//                        + Float.parseFloat(editNilai4.getText().toString())
//                        + Float.parseFloat(editNilai5.getText().toString())
//                        + Float.parseFloat(editNilai6.getText().toString())
//                        + Float.parseFloat(editNilai7.getText().toString())
//                        + Float.parseFloat(editNilai8.getText().toString())
//                        + Float.parseFloat(editNilai9.getText().toString())) / 9))));
//                break;
//            case 10:
//                textRataRata.setText(Float.toString(Float.parseFloat(String.format("%.2f", (Float.parseFloat(editNilai1.getText().toString())
//                        + Float.parseFloat(editNilai2.getText().toString())
//                        + Float.parseFloat(editNilai3.getText().toString())
//                        + Float.parseFloat(editNilai4.getText().toString())
//                        + Float.parseFloat(editNilai5.getText().toString())
//                        + Float.parseFloat(editNilai6.getText().toString())
//                        + Float.parseFloat(editNilai7.getText().toString())
//                        + Float.parseFloat(editNilai8.getText().toString())
//                        + Float.parseFloat(editNilai9.getText().toString())
//                        + Float.parseFloat(editNilai10.getText().toString())) / 10))));
//                break;
//        }
//        grading(Float.parseFloat(textRataRata.getText().toString()));
//    }

    protected void hitungMean(int jumlah){
        double rerata = 0.0;
        switch (jumlah){
            case 1:
                rerata = (nilai1)/1.0;
                break;
            case 2:
                rerata = (nilai1+nilai2)/2.0;
                break;
            case 3:
                rerata = (nilai1+nilai2+nilai3)/3.0;
                break;
            case 4:
                rerata = (nilai1+nilai2+nilai3+nilai4)/4.0;
                break;
            case 5:
                rerata = (nilai1+nilai2+nilai3+nilai4+nilai5)/5.0;
                break;
            case 6:
                rerata = (nilai1+nilai2+nilai3+nilai4+nilai5+nilai6)/6.0;
                break;
            case 7:
                rerata = (nilai1+nilai2+nilai3+nilai4+nilai5+nilai6+nilai7)/7.0;
                break;
            case 8:
                rerata = (nilai1+nilai2+nilai3+nilai4+nilai5+nilai6+nilai7+nilai8)/8.0;
                break;
            case 9:
                rerata = (nilai1+nilai2+nilai3+nilai4+nilai5+nilai6+nilai7+nilai8+nilai9)/9.0;
                break;
            case 10:
                rerata = (nilai1+nilai2+nilai3+nilai4+nilai5+nilai6+nilai7+nilai8+nilai9+nilai10)/10.0;
                break;
        }
        textMean.setText(String.format("%.2f",rerata)); //untuk membatasi 2 digit dibelakang koma
        //textMean.setText(Double.toString(rerata)); //tanpa batasan digit dibelakang koma
        grading(rerata);
    }

    protected void grading(double rata){
        if(rata >= 100){
            textGrade.setText("A");
        }
        else if(rata < 100 && rata >= 93){
            textGrade.setText("A-");
        }
        else if(rata < 93 && rata >= 86){
            textGrade.setText("B+");
        }
        else if(rata < 86 && rata >= 79){
            textGrade.setText("B");
        }
        else if(rata < 79 && rata >= 72){
            textGrade.setText("B-");
        }
        else if(rata < 72 && rata >= 65){
            textGrade.setText("C+");
        }
        else if(rata < 65 && rata >= 58){
            textGrade.setText("C");
        }
        else if(rata < 58 && rata >= 51){
            textGrade.setText("C-");
        }
        else if(rata < 51){
            textGrade.setText("D");
        }
    }
}