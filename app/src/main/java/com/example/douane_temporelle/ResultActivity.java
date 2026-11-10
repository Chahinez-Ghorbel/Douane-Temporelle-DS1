package com.example.douanetemporelle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        View root = findViewById(R.id.root_result_cg);
        TextView tvMessageCg = findViewById(R.id.tv_message_cg);
        Button btnNouveauCg = findViewById(R.id.btn_nouveau_cg);

        // verdict wl nom voyageur ly jew ml act 2
        boolean approuve = getIntent().getBooleanExtra(Cles.verdict(), false);
        String nom = getIntent().getStringExtra(Cles.nomVoyageur());

        // loun el bg wl text hasb l verdict
        if (approuve) {
            root.setBackgroundColor(Color.parseColor("#2E7D32")); // أخضر
            tvMessageCg.setText("Bon voyage " + nom + " !");
        } else {
            root.setBackgroundColor(Color.parseColor("#C62828")); // أحمر
            tvMessageCg.setText(nom + " est en état d'arrestation temporelle");
        }

        // tsaker les activités w tarjaa lel main activity loula
        btnNouveauNj.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}