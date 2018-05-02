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

            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Kawah Putih', '-7.166783', '107.401996','Lembang,Kabupaten Bandung Barat','kawahputih',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban Perahu', '-6.767213', '107.622624','Lembang,Kabupaten Bandung Barat','tangkuban_perahu',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('situ Patenggang', '-7.166965', '107.357534','Lembang,Kabupaten Bandung Barat','situ_patenggang',"+WISATA_ALAM+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Batagor H.Ihsan', '-6.928791', '107.599390','Jalan Bojongloa No.38, Panjunan, Astanaanyar Panjunan ,Astanaanyar','batagor_hj_ihsan',"+WISATA_KULINER+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Kolam Renang Karang Setra', '-6.878167', '107.594626','jalan sirnagalih KM.4.5 No.15 Gegerkalong, Sukasari, Kota Bandung','karangsetra',"+WISATA_KOLAM_RENANG+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Taman Jomblo', '-6.898110', '107.609254','jl.taman sari no.66,lb.siliwangi,coblong ,kota bandung','tamanjomblo',"+WISATA_TAMAN+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Amazing Art World', '-6.851784', '107.595607','jl.setiabudhi No.293, isola,sukasari,kota bandung','amazingartworld',"+WISATA_SENI_BUDAYA+");");
            db.execSQL("INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Museum Geologi', '-6.900708', '107.621491','Jl.Diponegoro no.57 cihaurgeulis, cibeunying kaler, kota bandung','museum_geologi_bandung',"+WISATA_SEJARAH+");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub
        }

    }