package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.douane_temporelle.Cles;

public class MainActivity extends AppCompatActivity {

    private EditText etNomCg, etNaissanceCg, etDestinationCg;
    private Spinner spMotifCg;
    private Button btnInspecterCg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // données eli ktebhom l voyageur
        etNomCg = findViewById(R.id.et_nom_cg);
        etNaissanceCg = findViewById(R.id.et_naissance_cg);
        etDestinationCg = findViewById(R.id.et_destination_cg);
        spMotifCg = findViewById(R.id.sp_motif_cg);
        btnInspecterCg = findViewById(R.id.btn_inspecter_cg);

        // ki tenzel aal bouton
        btnInspecterCg.setOnClickListener(v -> {
            String nom = etNomCg.getText().toString().trim();
            String naiss = etNaissanceCg.getText().toString().trim();
            String dest = etDestinationCg.getText().toString().trim();

            // lezem champs lkol fihom ktiba
            if (nom.isEmpty() || naiss.isEmpty() || dest.isEmpty()) {
                Toast.makeText(this, "Remplissez tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            int anneeNaiss = Integer.parseInt(naiss);
            int anneeDest = Integer.parseInt(dest);

            // lezem yemchi l aam baad ly touled fih
            if (anneeDest <= anneeNaiss) {
                Toast.makeText(this, "L'année de destination doit être > année de naissance",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // intent explicite
            Intent intent = new Intent(MainActivity.this, com.example.douanetemporelle.VerificationActivity.class);
            intent.putExtra(Cles.nomVoyageur(), nom);
            intent.putExtra(Cles.anneeNaiss(), anneeNaiss);
            intent.putExtra(Cles.anneeDest(), anneeDest);
            intent.putExtra(Cles.motif(), spMotifCg.getSelectedItem().toString());
            startActivity(intent);
        });
    }
}