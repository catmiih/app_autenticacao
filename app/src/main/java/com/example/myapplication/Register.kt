package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val edtLogin: EditText = findViewById(R.id.user)
        val edtPass: EditText = findViewById(R.id.pass)

        val inputLogin = edtLogin.text.toString()
        val inputPass = edtPass.text.toString()

        if (inputLogin.isEmpty() || inputPass.isEmpty()) {
            Toast.makeText(this,"O campo login ou senha está vazio",LENGTH_SHORT).show()
            return
        }
    }
}