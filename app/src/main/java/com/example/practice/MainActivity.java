package com.example.practice;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {
    TextView tvMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMsg = (TextView) findViewById(R.id.tvMessage);

        BiometricManager biometricManager = BiometricManager.from(this);

        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                tvMsg.setText("Use fingerprint sensor to login");
                break;

            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                tvMsg.setText("Device dont have fingerprint");
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                tvMsg.setText("biometric sensor is curretly unavilable");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                tvMsg.setText("Device have dont any fingerprint saved,please check your setting");
                break;
        }

        Executor executor= ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(MainActivity.this,"Login Succesfull",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(MainActivity.this,"Login Fail",Toast.LENGTH_LONG).show();

            }
        });

        BiometricPrompt.PromptInfo promptInfo =new BiometricPrompt.PromptInfo.Builder().setTitle("Login")
                .setSubtitle("Use finger to login")
                .setNegativeButtonText("Cancel")
                .build();
        biometricPrompt.authenticate(promptInfo);
    }


}