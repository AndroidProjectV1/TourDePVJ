package com.example.reza.tourdepvjmine.admin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Said on 28/03/2018.
 */

public class DataHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "dbsample.db";
        private static final int DATABASE_VERSION = 1;
        public DataHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            String sql = "CREATE TABLE wisata(no integer primary key autoincrement, nama text null, lat real null, long real null, alamat text null);";
            Log.d("Data", "onCreate: " + sql);
            db.execSQL(sql);
            sql = "INSERT INTO wisata (nama, lat, long, alamat) VALUES ('Tangkuban Perahu', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat');";
            db.execSQL(sql);

        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub

        }

    }