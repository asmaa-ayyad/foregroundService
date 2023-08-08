package com.example.foregroundser

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.finalproject.dbhelper.DatabaseHelper
import com.example.foregroundser.databinding.ActivityLoginBinding
import com.example.foregroundser.serv.MyService

class login : AppCompatActivity() {
    companion object{
         var msg = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.singup.setOnClickListener {
            val i = Intent(this,singup::class.java)
            startActivity(i)


        }

        binding.buttonSignin.setOnClickListener {

            val db = DatabaseHelper(this)


            if(db.isLogin(binding.email.text.toString(),binding.passwoed.text.toString())){
                 msg="true"
                val intent = Intent(this, MyService::class.java)


                ContextCompat.startForegroundService(this,intent)

            }
            else if (db.isLogin(binding.email.text.toString(),binding.passwoed.text.toString())==false){
                msg="false"
                val intent = Intent(this, MyService::class.java)
                ContextCompat.startForegroundService(this,intent)

            }



            else   if( !db.isLogin(binding.email.text.toString(),binding.passwoed.text.toString())){
                binding.email.error="email or password dont match "

                binding.passwoed.error="email or password dont match"
            }




        }

    }}
