package com.example.bitcoinprice.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.bitcoinprice.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryDBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "country_db";
    private static final int VERSION = 1;

    public CountryDBHelper(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("dbHelper","onCreate");
        String sql = "CREATE TABLE countries(code INTEGER, symbol TEXT, rate REAL, description TEXT)";
        db.execSQL(sql);
    }

    public void addData(Country country){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("code",country.getCode());
        values.put("symbol",country.getSymbol());
        values.put("rate",country.getRate());
        values.put("description",country.getDescription());
        db.insert("countries",null,values);
    }


    public List<Country> getData(){

        List<Country> countries =new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("countries",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Country car = new Country(cursor.getInt(0),cursor.getString(1),
                    cursor.getDouble(2),cursor.getString(3) );
            countries.add(car);
            Log.e("carDetails",car.toString());
        }
        return countries;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
