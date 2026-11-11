package com.example.aplikasiperhitungangajikaryawan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDeswithanur extends AppCompatActivity {

    ImageButton btnGaji, btnPetunjuk, btnTentang, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_deswithanur);

        btnGaji = findViewById(R.id.btnGaji);
        btnPetunjuk = findViewById(R.id.btnPetunjuk);
        btnTentang = findViewById(R.id.btnTentang);
        btnExit = findViewById(R.id.btnExit);

        btnGaji.setOnClickListener(v ->
                startActivity(new Intent(this, GajiActivityDeswithanur.class)));

        btnPetunjuk.setOnClickListener(v ->
                startActivity(new Intent(this, PetunjukActivityDeswithanur.class)));

        btnTentang.setOnClickListener(v ->
                startActivity(new Intent(this, TentangActivityDeswithanur.class)));

        btnExit.setOnClickListener(v -> finishAffinity());
    }
}