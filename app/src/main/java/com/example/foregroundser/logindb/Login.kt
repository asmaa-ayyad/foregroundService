package com.example.finalproject.logindb

data class Login(var id :Int,var name:String, var email:String, var pasword:String,var phone:String) {

    companion object{
        const val TABLE_NAME = "Login"
        const val COL_ID ="id"
        const val COL_email = "email"
        const val COL_pasword = "pasword"
        const val COL_name = "name"
        const val COL_phone = "phone"

        const val TABLE_CREATE ="CREATE TABLE $TABLE_NAME($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $COL_name TEXT NOT NULL,$COL_email TEXT , $COL_pasword TEXT NOT NULL ,$COL_phone TEXT NOT NULL )"
    }
}