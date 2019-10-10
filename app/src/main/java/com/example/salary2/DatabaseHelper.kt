package com.example.salary2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.ID
import android.util.Log

class DatabaseHelper (context: Context):SQLiteOpenHelper(context,dbTable,factory,version){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE IF NOT EXISTS $dbTable($ID integer primary key autoincrement,$name varchar(30),$email varchar(100) not null ,$password varchar(20) not null)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented")
    }

    fun insertUserData(name:String,email:String,password:String){
        val db:SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put("name",name)
        values.put("email",email)
        values.put("password",password)
        db.insert("$dbTable",null,values)
        db.close()
    }

    fun viewUser():String {
        var allUser:String = " "
        val db = readableDatabase
        val selectQuery = "SELECT * FROM $dbTable"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getString(cursor.getColumnIndex(ID))
                    var name = cursor.getString(cursor.getColumnIndex(name))
                    var email = cursor.getString(cursor.getColumnIndex(email))
                    var password = cursor.getString(cursor.getColumnIndex(password))
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allUser
    }

    fun userPresent(email: String,password: String):Boolean {
        val db = writableDatabase
        val query = "SELECT * FROM $dbTable WHERE email = '$email' AND password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }


    companion object{
        internal val dbTable = "user"
        internal val  factory = null
        internal val version = 1
        internal val ID = "id"
        internal val name = "name"
        internal val email = "email"
        internal val password = "password"
    }

}