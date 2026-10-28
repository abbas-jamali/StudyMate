# StudyMate — Android Java/XML Assignment

StudyMate is a student-focused demo app built with native Android Activities, Java, and XML layouts.

## Features
- Welcome screen and explicit Intent navigation
- Login with email/password validation
- Registration with required-field, email, minimum-length, and confirmation validation
- Simulated forgot/reset password flow
- Dashboard grid with task, notes, focus timer, schedule, and progress preview cards
- Profile screen and logout
- Local account details stored with `SharedPreferences`
- Centralized strings, colors, and day/night theme resource folders

## Demo login
- Email: `student@studymate.com`
- Password: `StudyMate123`

You can also create an account on the Register screen. Data is stored locally on this device/emulator.

## Open and run
1. Extract this folder.
2. Open the `StudyMate_Android_Project` folder in Android Studio.
3. Let Gradle sync. Install Android SDK 36 if Android Studio requests it, or change `compileSdk` and `targetSdk` to an installed SDK.
4. Run the `app` configuration on an emulator or Android device.

## Screen flow
Welcome → Login → Home → Profile
Login → Register
Login → Forgot Password → Reset Password → Login

## Important limitation
This is an educational prototype. Passwords are stored locally in app preferences in plain text to keep the assignment simple. This is **not secure enough for a real app**. Forgot-password is simulated; no email is sent. Dashboard feature cards currently show a demo message rather than saving tasks/notes or running a real timer.

## Main files
- `SplashActivity.java`: welcome screen and navigation to login
- `LoginActivity.java`: login form validation and credential checking
- `RegisterActivity.java`: account creation and validation
- `ForgotPasswordActivity.java`: validates email and starts demo recovery
- `ResetPasswordActivity.java`: validates and updates local password
- `HomeActivity.java`: dashboard cards and navigation
- `ProfileActivity.java`: shows local user details and logout
- `SessionManager.java`: central local preference/account helper
- `res/layout/*.xml`: screen user interfaces
- `res/values/strings.xml`: shared app text
- `res/values/colors.xml`: palette
- `res/values/themes.xml` and `res/values-night/themes.xml`: light/dark theme resources
- `AndroidManifest.xml`: declares app Activities and launcher screen

## Suggested testing
- Try blank login fields.
- Try invalid email.
- Try incorrect credentials.
- Log in with the demo account.
- Register an account and log in with it.
- Try mismatched registration passwords.
- Use Forgot Password with the current account email, reset the password, and log in with the new password.
- Open Profile and test both back and logout.
