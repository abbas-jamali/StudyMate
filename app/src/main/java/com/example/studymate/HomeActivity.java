package com.example.studymate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SessionManager session = new SessionManager(this);
        TextView tvGreeting = findViewById(R.id.tvGreeting);
        tvGreeting.setText("Hello, " + session.getName() + " 👋");

        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnTasks = findViewById(R.id.btnTasks);
        Button btnNotes = findViewById(R.id.btnNotes);
        Button btnFocus = findViewById(R.id.btnFocus);
        Button btnSchedule = findViewById(R.id.btnSchedule);
        Button btnProgress = findViewById(R.id.btnProgress);
        Button btnLogout = findViewById(R.id.btnLogout);

        btnProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        btnTasks.setOnClickListener(v -> showFeature("Tasks"));
        btnNotes.setOnClickListener(v -> showFeature("Notes"));
        btnFocus.setOnClickListener(v -> showFeature("Focus timer"));
        btnSchedule.setOnClickListener(v -> showFeature("Study schedule"));
        btnProgress.setOnClickListener(v -> showFeature("Study progress"));
        btnLogout.setOnClickListener(v -> {
            session.logout();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }

    private void showFeature(String feature) {
        Toast.makeText(this, feature + " feature selected — demo preview", Toast.LENGTH_SHORT).show();
    }
}
