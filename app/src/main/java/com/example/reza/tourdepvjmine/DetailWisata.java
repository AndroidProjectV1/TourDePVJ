package com.example.reza.tourdepvjmine;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailWisata extends AppCompatActivity {
    Resources resources;
    ImageView image;
    ImageView background;
    DataHelper dbcenter;
    protected Cursor cursor;
    TempatWisata tempatWisata;
    TextView textAlamat;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        dbcenter = new DataHelper(this);

        Toolbar toolbarDetail = (Toolbar) findViewById(R.id.toolbarIdDetail);
        setSupportActionBar(toolbarDetail);

        toolbarDetail.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbarDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        String namaWisata = intent.getStringExtra("namawisata");

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM wisata where nama_wisata = '"+namaWisata+"'", null);
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            tempatWisata = new TempatWisata();
            tempatWisata.setNamaTempat(cursor.getString(1).toString());
            tempatWisata.setAlamat(cursor.getString(10).toString());
            tempatWisata.setLatitude(cursor.getDouble(8));
            tempatWisata.setLongitude(cursor.getDouble(9));
            tempatWisata.setFoto(cursor.getString(11));
            tempatWisata.setKategori(cursor.getInt(12));
        }

        textAlamat = (TextView) findViewById(R.id.alamat_tempat_wisata_detail);
        textAlamat.setText(tempatWisata.getAlamat());
        image = (ImageView) findViewById(R.id.maps);
        image.setClickable(true);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailWisata.this,MapsActivity.class);
                i.putExtra("latitude",tempatWisata.getLatitude());
                i.putExtra("longitude",tempatWisata.getLongitude());
                startActivity(i);
            }
        });

        resources = getResources();
        int resID = resources.getIdentifier(tempatWisata.getFoto(), "drawable","com.example.reza.tourdepvjmine");
        Drawable drawable = resources.getDrawable(resID);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_detail);
        collapsingToolbarLayout.setTitle(tempatWisata.getNamaTempat());
        collapsingToolbarLayout.setBackground(drawable);
    }
}