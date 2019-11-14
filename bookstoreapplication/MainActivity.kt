package com.example.bookstoreapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NoAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        LoginButton.setOnClickListener {
            val email = EmailLogin.text.toString()
            val password = PasswordLogin.text.toString()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    Log.d("LoginActivity", "Successfully Logged in")
                    val intent = Intent(this, BookList::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Log.d("LoginActivity", "Failed to login")
                }
        }
    }
}
