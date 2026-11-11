package com.example.aplikasiperhitungangajikaryawan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GajiActivityDeswithanur extends AppCompatActivity {

    EditText etNik, etNama, etGajiPokok, etTunjJabatan, etHariKerja;
    EditText etTunjMakan, etTunjTransport, etGajiKotor, etGajiBersih;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_deswithanur);

        etNik = findViewById(R.id.etNik);
        etNama = findViewById(R.id.etNama);
        etGajiPokok = findViewById(R.id.etGajiPokok);
        etTunjJabatan = findViewById(R.id.etTunjJabatan);
        etHariKerja = findViewById(R.id.etHariKerja);
        etTunjMakan = findViewById(R.id.etTunjMakan);
        etTunjTransport = findViewById(R.id.etTunjTransport);
        etGajiKotor = findViewById(R.id.etGajiKotor);
        etGajiBersih = findViewById(R.id.etGajiBersih);
        btnHitung = findViewById(R.id.btnHitung);

        btnHitung.setOnClickListener(v -> hitung());
    }

    private void hitung() {
        if (etNik.getText().toString().isEmpty()
                || etNama.getText().toString().isEmpty()
                || etGajiPokok.getText().toString().isEmpty()
                || etTunjJabatan.getText().toString().isEmpty()
                || etHariKerja.getText().toString().isEmpty()) {
            Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        double gajiPokok = Double.parseDouble(etGajiPokok.getText().toString());
        double tunjJabatan = Double.parseDouble(etTunjJabatan.getText().toString());
        int hariKerja = Integer.parseInt(etHariKerja.getText().toString());

        double tunjMakan = hariKerja * 10000;
        double tunjTransport = hariKerja * 5000;
        double gajiKotor = gajiPokok + tunjJabatan + tunjMakan + tunjTransport;
        double pajak = 0.10 * gajiKotor;
        double gajiBersih = gajiKotor - pajak;

        etTunjMakan.setText("Rp " + String.format("%,.0f", tunjMakan));
        etTunjTransport.setText("Rp " + String.format("%,.0f", tunjTransport));
        etGajiKotor.setText("Rp " + String.format("%,.0f", gajiKotor));
        etGajiBersih.setText("Rp " + String.format("%,.0f", gajiBersih));
    }
}