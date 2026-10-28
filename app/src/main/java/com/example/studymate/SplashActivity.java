package com.example.studymate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button btnGetStarted = findViewById(R.id.btnGetStarted);
        TextView tvLoginLink = findViewById(R.id.tvAlreadyMember);

        btnGetStarted.setOnClickListener(v ->
                startActivity(new Intent(SplashActivity.this, LoginActivity.class)));
        tvLoginLink.setOnClickListener(v ->
                startActivity(new Intent(SplashActivity.this, LoginActivity.class)));
    }
}
