package com.example.pertemuankeduaevent;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {

    //Deklarasi variabel dengan tipe EditText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //Deklarasi variabel dengan tipe data Floating Action Button
    FloatingActionButton fab;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftran);

        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtPassword= findViewById(R.id.edPass);
        edtrepass= findViewById(R.id.edrepas);
        edtEmail=findViewById(R.id.edEamil);

        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty()) {

                    //Menampilkan pesan notifikasi jika seluruh EditText wajib disi
                    Snackbar.make(view, "Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();

                } else {

                    //Membuat kondisi untuk mengecek apakah isi dari EditText password dan EditText repassword
                    //sama atau tidak

                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString())) {
                        //Menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...",
                                Toast.LENGTH_LONG).show();

                        //Method untuk kembali ke activity Main
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText repassword
                        //tidak sama
                        Snackbar.make(view, "Password dan Repassword harus sama!!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}









