package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        val user = Firebase.auth.currentUser

        val edtLogin: EditText = findViewById(R.id.user)
        val edtPass: EditText = findViewById(R.id.pass)

        val inputLogin = edtLogin.text
        val inputPass = edtPass.text

        val btnRegister : Button = findViewById(R.id.register)
        btnRegister.setOnClickListener{
            if (inputLogin.isEmpty() || inputPass.isEmpty()) {
                Toast.makeText(this,"O campo login ou senha está vazio",LENGTH_SHORT).show()
            }
                createAccount(inputLogin.toString(), inputPass.toString())
        }
    }

    private fun createAccount(login: String, pass: String) {
        auth.createUserWithEmailAndPassword(login, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"Usuário criado com sucesso!",LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"Ocorreu algum erro na criação. Erro:"+task.exception,LENGTH_SHORT).show()

                }
            }
    }
}