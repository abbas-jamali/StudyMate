package com.example.studymate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText etRecoveryEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        etRecoveryEmail = findViewById(R.id.etRecoveryEmail);
        Button btnContinue = findViewById(R.id.btnRecoveryContinue);
        TextView tvBackLogin = findViewById(R.id.tvBackLogin);

        btnContinue.setOnClickListener(v -> continueRecovery());
        tvBackLogin.setOnClickListener(v -> finish());
    }

    private void continueRecovery() {
        String email = etRecoveryEmail.getText().toString().trim();
        if (email.isEmpty()) {
            etRecoveryEmail.setError("Email is required");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etRecoveryEmail.setError("Enter a valid email");
            return;
        }
        if (!new SessionManager(this).emailExists(email)) {
            etRecoveryEmail.setError("No local account found for this email");
            return;
        }
        Toast.makeText(this, "Demo recovery accepted. Set your new password.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        intent.putExtra("recovery_email", email);
        startActivity(intent);
    }
}
