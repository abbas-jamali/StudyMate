package com.example.studymate;

import android.content.Context;
import android.content.SharedPreferences;

/** Small local demo account store. This is for an assignment, not production authentication. */
public class SessionManager {
    private static final String PREFS = "studymate_prefs";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String LOGGED_IN = "logged_in";

    private final SharedPreferences prefs;

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        // Demo credentials make the app testable immediately after first install.
        if (!prefs.contains(EMAIL)) {
            prefs.edit()
                    .putString(NAME, "Student User")
                    .putString(EMAIL, "student@studymate.com")
                    .putString(PASSWORD, "StudyMate123")
                    .apply();
        }
    }

    public boolean register(String name, String email, String password) {
        prefs.edit().putString(NAME, name).putString(EMAIL, email)
                .putString(PASSWORD, password).putBoolean(LOGGED_IN, false).apply();
        return true;
    }

    public boolean login(String email, String password) {
        boolean valid = email.equalsIgnoreCase(prefs.getString(EMAIL, ""))
                && password.equals(prefs.getString(PASSWORD, ""));
        if (valid) prefs.edit().putBoolean(LOGGED_IN, true).apply();
        return valid;
    }

    public boolean emailExists(String email) {
        return email.equalsIgnoreCase(prefs.getString(EMAIL, ""));
    }

    public boolean resetPassword(String email, String newPassword) {
        if (!emailExists(email)) return false;
        prefs.edit().putString(PASSWORD, newPassword).apply();
        return true;
    }

    public String getName() { return prefs.getString(NAME, "Student User"); }
    public String getEmail() { return prefs.getString(EMAIL, "student@studymate.com"); }
    public void logout() { prefs.edit().putBoolean(LOGGED_IN, false).apply(); }
}
