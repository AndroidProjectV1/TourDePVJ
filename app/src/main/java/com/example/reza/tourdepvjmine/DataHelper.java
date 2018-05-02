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
        private static final int WISATA_ALAM = 1;
        private static final int WISATA_KULINER = 2;
        private static final int WISATA_KOLAM_RENANG = 3;
        private static final int WISATA_TAMAN = 4;
        private static final int WISATA_SENI_BUDAYA = 5;
        private static final int WISATA_SEJARAH = 6;
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
                    "alamat text null, foto Integer null, kategori_wisata integer null, id_lokasi integer null);";
            String CREATE_TABLE_LOKASI = "CREATE TABLE lokasi(id_lokasi integer primary key, " +
                    "nama_lokasi text null, latitude real null, longitude real null);";
            String CREATE_TABLE_FEEDBACK = "CREATE TABLE feedback(kode_feedback integer primary key autoincrement, " +
                    "ulasan_feedback text null, nama_pemberi_feedback text null);";
            Log.d("Data", "onCreate: " + CREATE_TABLE_WISATA);
            db.execSQL(CREATE_TABLE_WISATA);
            db.execSQL(CREATE_TABLE_LOKASI);
            db.execSQL(CREATE_TABLE_FEEDBACK);

            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban1', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','alam',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Kawah Merah', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','alam',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban2', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','bandung',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban3', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','bdg',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban4', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','bandung',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban Pesawat', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','bandung',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban Mobil', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','bandung',"+WISATA_KULINER+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban Motor', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','bandung',"+WISATA_KOLAM_RENANG+");");

        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub

        }

    }