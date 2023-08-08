package com.example.foregroundser

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.finalproject.dbhelper.DatabaseHelper
import com.example.foregroundser.databinding.ActivityLoginBinding
import com.example.foregroundser.databinding.ActivitySingupBinding
import com.example.foregroundser.serv.MyService

class singup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = DatabaseHelper(this)
        binding.singintex.setOnClickListener {
            val i = Intent(this,login::class.java)
            startActivity(i)


        }
        binding.buttonSignup.setOnClickListener {


            if( binding.emails.text.isEmpty()||binding.names.text.isEmpty()||binding.passwoeds.text.isEmpty()||binding.phone.text.isEmpty()){
                Toast.makeText(this,"pleas Enter all the information and  ",
                    Toast.LENGTH_SHORT).show()
            }


            else{

                val databaseHelper = DatabaseHelper(this)
                val db = DatabaseHelper(this)

                db.insertUsers(binding.names.text.toString(),binding.emails.text.toString(),binding.passwoeds.text.toString(),binding.phone.text.toString())

                val sharedPref=  this.getSharedPreferences("login", Context.MODE_PRIVATE);
                val editor = sharedPref!!.edit()
                editor.putString("email",binding.emails.text.toString())
                editor.commit()








        }
    }
}}