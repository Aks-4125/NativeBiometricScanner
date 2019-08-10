package com.example.nativebiometricscanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val executor = Executors.newSingleThreadExecutor() // can be executed on any executor as per requirement
        val activity: AppCompatActivity = this
        val biometricPrompt = BiometricPrompt(activity, executor, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    // user clicked negative button
                   runOnUiThread { textView.text = getString(R.string.operation_cancelled_by_user) }
                } else {
                    runOnUiThread {textView.text = getString(R.string.dismiss)}

                }
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                runOnUiThread {textView.text = getString(R.string.recognized)}
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                runOnUiThread { textView.text = getString(R.string.invalid)}
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Verify it's you...")
            .setSubtitle("native android API")
            .setDescription("native biometric prompt for faceID/fingerprint")
            .setNegativeButtonText("Back")
            .build()

        launchAuthentication.setOnClickListener { biometricPrompt.authenticate(promptInfo) }

    }

}



