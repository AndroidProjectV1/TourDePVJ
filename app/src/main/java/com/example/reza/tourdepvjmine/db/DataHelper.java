package com.example.reza.tourdepvjmine.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.reza.tourdepvjmine.db.Query.CREATE_TABLE_WISATA;
import static com.example.reza.tourdepvjmine.db.Query.CREATE_TABLE_LOKASI;
import static com.example.reza.tourdepvjmine.db.Query.CREATE_TABLE_FEEDBACK;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_AMAZING_ART;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_BATAGOR_H;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_KARANG_SETRA;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_KAWAH_PUTIH;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_LAWANGWANGI;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_MUSEUM_GEOLOGI;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_SITU_PATENGGANG;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_TAMAN_JOMBLO;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_TANGKUBAN_PERAHU;
import static com.example.reza.tourdepvjmine.db.Query.INSERT_TOKO_YOU;

/**
 * Created by Said on 28/03/2018.
 */

public class DataHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "tempatwisata.db";
        private static final int DATABASE_VERSION = 1;

        public DataHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub

            Log.d("Data", "onCreate: " + CREATE_TABLE_WISATA);
            db.execSQL(CREATE_TABLE_WISATA);
            db.execSQL(CREATE_TABLE_LOKASI);
            db.execSQL(CREATE_TABLE_FEEDBACK);

            db.execSQL(INSERT_KAWAH_PUTIH);
            db.execSQL(INSERT_TOKO_YOU);
            db.execSQL(INSERT_LAWANGWANGI);
            db.execSQL(INSERT_TANGKUBAN_PERAHU);
            db.execSQL(INSERT_SITU_PATENGGANG);
            db.execSQL(INSERT_BATAGOR_H);
            db.execSQL(INSERT_KARANG_SETRA);
            db.execSQL(INSERT_TAMAN_JOMBLO);
            db.execSQL(INSERT_AMAZING_ART);
            db.execSQL(INSERT_MUSEUM_GEOLOGI);

        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub

        }

    }