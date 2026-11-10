package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    private TextView tvNomCg, tvAgeCg, tvMotifCg;
    private Button btnApprouverCg, btnRefuserCg;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        // 1) ربط العناصر
        tvNomCg = findViewById(R.id.tv_nom_cg);
        tvAgeCg = findViewById(R.id.tv_age_cg);
        tvMotifCg = findViewById(R.id.tv_motif_cg);
        btnApprouverCg = findViewById(R.id.btn_approuver_cg);
        btnRefuserCg = findViewById(R.id.btn_refuser_cg);

        // données ly jew ml activity loula
        Intent recu = getIntent();
        nom = recu.getStringExtra(Cles.nomVoyageur());
        int naiss = recu.getIntExtra(Cles.anneeNaiss(), 0);
        int dest = recu.getIntExtra(Cles.anneeDest(), 0);
        String motif = recu.getStringExtra(Cles.motif());

        // fark binet l aam ly mechilou wl année naissance
        int ageTemporel = dest - naiss;

        // affichage taa données
        tvNomCg.setText("Nom : " + nom);
        tvAgeCg.setText("Âge temporel : " + ageTemporel + " ans");
        tvMotifCg.setText("Motif : " + motif);

        // kenha modif passé wl difference nbre premier
        if ("Modification du passé".equals(motif) && estPremier(ageTemporel)) {
            btnApprouverCg.setEnabled(false);
        }

        // ken approuvé true w ken refusé false hasb l bouton
        btnApprouverCg.setOnClickListener(v -> lancerVerdict(true));
        btnRefuserCg.setOnClickListener(v -> lancerVerdict(false));
    }

    // intent explicite lel activity 3
    private void lancerVerdict(boolean approuve) {
        Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
        intent.putExtra(Cles.verdict(), approuve);
        intent.putExtra(Cles.nomVoyageur(), nom);
        startActivity(intent);
    }

    // bch nthabtou eli lfark premier
    private boolean estPremier(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}