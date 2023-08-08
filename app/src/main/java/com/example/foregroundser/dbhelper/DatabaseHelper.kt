package com.example.finalproject.dbhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.finalproject.logindb.Login

class DatabaseHelper (context: Context): SQLiteOpenHelper(context, "Login", null, 3){

    private val db = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
    db!!.execSQL(Login.TABLE_CREATE)

    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS ${Login.TABLE_NAME}")
        onCreate(db)
    }

    fun insertUsers(name: String, email: String ,pasword:String, phone :String ): Boolean {
        val cv = ContentValues()
        cv.put(Login.COL_name, name)
        cv.put(Login.COL_email,email)
        cv.put(Login.COL_pasword,pasword)
        cv.put(Login.COL_phone,phone)

        return db.insert(Login.TABLE_NAME, null, cv) > 0
    }













    fun isLogin( email: String ,pasword:String):Boolean  {
        val d=  db.rawQuery("select * from ${Login.TABLE_NAME} where ${Login.COL_email}='$email' and ${Login.COL_pasword}='$pasword' "
            , null)
        if(d.count>0){
            return true
        } else return false
    }



}
