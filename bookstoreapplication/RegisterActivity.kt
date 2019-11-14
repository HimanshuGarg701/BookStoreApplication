package com.example.bookstoreapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        RegisterUser()
    }

    private fun RegisterUser(){
        RegisterButton.setOnClickListener {
            val email = EmailRegister.text.toString()
            val password = PasswordRegister.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if(!it.isSuccessful) return@addOnCompleteListener
                    Log.d("RegisterUser", "user is registered")
                    val intent = Intent(this, BookList::class.java)
                    startActivity(intent)

                }
                .addOnFailureListener {
                    Log.d("RegisterUser", "failed to register user")
                }
        }
    }
}
