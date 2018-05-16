package com.example.reza.tourdepvjmine.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reza.tourdepvjmine.R;
import com.example.reza.tourdepvjmine.model.TempatWisata;

public class DetailWisataActivity extends AppCompatActivity {
    Resources resources;
    ImageView image;
    ImageView background;

    protected Cursor cursor;
    TempatWisata tempatWisata;
    TextView textAlamat;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

/*
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

        textAlamat = (TextView) findViewById(R.id.alamat_tempat_wisata_detail);
        image = (ImageView) findViewById(R.id.maps);
        image.setClickable(true);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailWisataActivity.this,MapsActivity.class);
                i.putExtra("latitude",tempatWisata.getLatitude());
                i.putExtra("longitude",tempatWisata.getLongitude());
                startActivity(i);
            }
        });

        resources = getResources();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_detail);
        collapsingToolbarLayout.setTitle(tempatWisata.getNamaTempat());
        collapsingToolbarLayout.setBackgroundColor(Color.BLACK);
*/
    }
}