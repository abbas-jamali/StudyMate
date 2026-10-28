package com.example.studymate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPasswordActivity extends Activity {
    private EditText etNewPassword, etConfirmNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmNewPassword = findViewById(R.id.etConfirmNewPassword);
        Button btnSavePassword = findViewById(R.id.btnSavePassword);
        TextView tvCancelReset = findViewById(R.id.tvCancelReset);

        btnSavePassword.setOnClickListener(v -> savePassword());
        tvCancelReset.setOnClickListener(v -> finish());
    }

    private void savePassword() {
        String password = etNewPassword.getText().toString();
        String confirm = etConfirmNewPassword.getText().toString();
        String email = getIntent().getStringExtra("recovery_email");

        if (password.isEmpty() || confirm.isEmpty()) {
            Toast.makeText(this, "Complete both password fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 8) {
            etNewPassword.setError("Use at least 8 characters");
            return;
        }
        if (!password.equals(confirm)) {
            etConfirmNewPassword.setError("Passwords do not match");
            return;
        }
        if (email == null || !new SessionManager(this).resetPassword(email, password)) {
            Toast.makeText(this, "Could not reset password. Try again.", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this, "Password updated. Please log in.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
