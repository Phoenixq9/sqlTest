package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try{
            SQLiteDatabase sqLiteDatabase=this.openOrCreateDatabase("Data",MODE_PRIVATE,null);
     //      sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS data(id INTEGER PRIMARY KEY,name VARCHAR, age INT)");
      //      sqLiteDatabase.execSQL("INSERT INTO data (name,age) VALUES('Elif',23)");
        //  sqLiteDatabase.execSQL("INSERT INTO data (name,age) VALUES('Muhammet',21)");
      //    sqLiteDatabase.execSQL("INSERT INTO data (name,age) VALUES('Mısra',21)");
//sqLiteDatabase.execSQL("UPDATE data SET name='Ayşe' WHERE id=3");
         //   sqLiteDatabase.execSQL("DELETE FROM data WHERE id=100");
            Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM data WHERE  name LIKE '%f' ",null);


            int nameIx=cursor.getColumnIndex("name");
            int ageIx=cursor.getColumnIndex("age");
            int idIx=cursor.getColumnIndex("id");
            while(cursor.moveToNext()){
                System.out.println("Name: "+cursor.getString(nameIx));
                System.out.println("Age: "+cursor.getInt(ageIx));
                System.out.println("Id: "+cursor.getInt(idIx));
            }
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}
