package com.example.reza.tourdepvjmine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
            String CREATE_TABLE_WISATA = "CREATE TABLE wisata(id_wisata integer primary key autoincrement, " +
                    "nama_wisata text null, jam_buka integer null, jam_tutup integer null, deskripsi_wisata text null, " +
                    "fasilitas text null, harga_masuk integer null, kontak_pengelola text null, lat real null, long real null, " +
                    "alamat text null, foto Integer null);";
            String CREATE_TABLE_LOKASI = "CREATE TABLE lokasi(id integer primary key autoincrement, " +
                    "nama text null, lat real null, long real null, alamat text null, foto Integer null);";
            String CREATE_TABLE_FEEDBACK = "CREATE TABLE feedback(kode integer primary key autoincrement, " +
                    "nama text null, lat real null, long real null, alamat text null, foto Integer null);";
            Log.d("Data", "onCreate: " + CREATE_TABLE_WISATA);
            db.execSQL(CREATE_TABLE_WISATA);
            db.execSQL(CREATE_TABLE_LOKASI);
            db.execSQL(CREATE_TABLE_FEEDBACK);

            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto) VALUES ('Tangkuban Perahu', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','2131165312');");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto) VALUES ('Lembang', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','2131165312');");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto) VALUES ('Cibulan', '-6.767213', '107.622624','Kuningan,Kabupaten Bandung Barat','2131165312');");

        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub

        }

    }