package com.example.reza.tourdepvjmine.admin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reza.tourdepvjmine.R;

public class BuatWisata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button buttonSimpan, buttonBack;
    EditText text1, nama, alamat, lati, longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_wisata);

        dbHelper = new DataHelper(this);
//        text1 = (EditText) findViewById(R.id.editText1); //no
        nama = (EditText) findViewById(R.id.editNama); //nama tempat
        alamat = (EditText) findViewById(R.id.editAlamat); //alamat
        lati = (EditText) findViewById(R.id.editLat); //latitude
        longi = (EditText) findViewById(R.id.editLongi); //longitude

        buttonSimpan = (Button) findViewById(R.id.buttonSimpan);
        buttonBack = (Button) findViewById(R.id.buttonBack);

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into wisata(nama, lat, long, alamat) values('" +
                        nama.getText().toString() +"','" +
                        lati.getText()+"','"+
                        longi.getText() +"','" +
                        alamat.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}