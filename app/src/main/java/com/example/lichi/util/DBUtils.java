package com.example.lichi.util;

import java.util.ArrayList;
import java.util.List;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lichi.Person;

/**增删改查
 */
public class DBUtils {
    public static void add(MySqliteHelper helper, Person person){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into person(name,sex,age) values(?,?,?)", new Object[]{person.getName(),person.getSex(),person.getAge()});
        db.close();
    }
    public static void delete(MySqliteHelper helper,Integer personId){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from person where personid=?",new Object[]{personId});
        db.close();
    }
    public static void update(MySqliteHelper helper,Person person){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update person set name=?,sex=?,age=? where personid=?",new Object[]{person.getName(),person.getSex(),person.getAge(),person.getId()});
        db.close();
    }
    public static List<Person> query(MySqliteHelper helper){
        List<Person> persons = new ArrayList<Person>();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from person", null);
        while (cursor.moveToNext()) {
            int personId = cursor.getInt(0);
            String name = cursor.getString(1);
            String sex = cursor.getString(2);
            int age = Integer.parseInt(cursor.getString(3));
            Person person = new Person(personId,name, sex,age);
            persons.add(person);
        }
        cursor.close();
        db.close();
        return persons;
    }
}
