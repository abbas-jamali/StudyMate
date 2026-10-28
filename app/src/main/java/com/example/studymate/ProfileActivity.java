package com.example.studymate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SessionManager session = new SessionManager(this);
        TextView tvProfileName = findViewById(R.id.tvProfileName);
        TextView tvProfileEmail = findViewById(R.id.tvProfileEmail);
        Button btnProfileBack = findViewById(R.id.btnProfileBack);
        Button btnProfileLogout = findViewById(R.id.btnProfileLogout);

        tvProfileName.setText(session.getName());
        tvProfileEmail.setText(session.getEmail());
        btnProfileBack.setOnClickListener(v -> finish());
        btnProfileLogout.setOnClickListener(v -> {
            session.logout();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}
