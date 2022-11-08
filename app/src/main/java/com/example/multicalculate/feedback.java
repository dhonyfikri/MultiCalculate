package com.example.multicalculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends AppCompatActivity {

    EditText editNama, editTelepon, editEmail, editPesan;
    Button buttonKirimFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editNama = findViewById(R.id.etNama);
        editTelepon = findViewById(R.id.etTelepon);
        editEmail = findViewById(R.id.etEmail);
        editPesan = findViewById(R.id.etPesan);
        buttonKirimFeedBack = findViewById(R.id.btnKirimFeedBack);

        buttonKirimFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFilled()){
                    String field1 = editNama.getText().toString();
                    String field2 = editTelepon.getText().toString();
                    String field3 = editEmail.getText().toString();
                    String field4 = editPesan.getText().toString();

                    String semuaPesan = "Nama : " + field1 + "\n" + "No. Telepon : " + field2 + "\n" + "Email : " + field3 + "\n" + "Pesan : " + field4;
                    Intent kirimWA = new Intent(Intent.ACTION_SEND);
                    kirimWA.setType("text/plain");
                    kirimWA.putExtra(Intent.EXTRA_TEXT, semuaPesan);
                    kirimWA.putExtra("jid","6281542198298" + "@s.whatsapp.net");
                    kirimWA.setPackage("com.whatsapp");

                    startActivity(kirimWA);
                }
                else {
                    Toast.makeText(feedback.this, "Form Belum Terisi Lengkap", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    protected boolean isFilled(){
        boolean terisi = true;
        if(editNama.getText().toString().equals("")) terisi = false;
        if(editTelepon.getText().toString().equals("")) terisi = false;
        if(editEmail.getText().toString().equals("")) terisi = false;
        if(editPesan.getText().toString().equals("")) terisi = false;
        return terisi;
    }
}