package com.example.reza.tourdepvjmine.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reza.tourdepvjmine.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Tour DePVJ");

        CardView cardAlamClick = (CardView) findViewById(R.id.card_alam_click);
        CardView cardKulinerClick = (CardView) findViewById(R.id.card_kuliner_click);
        CardView cardKolamClick = (CardView) findViewById(R.id.card_kolam_click);
        CardView cardTamanClick = (CardView) findViewById(R.id.card_taman_click);
        CardView cardSeniClick = (CardView) findViewById(R.id.card_seni_click);
        CardView cardSejarahClick = (CardView) findViewById(R.id.card_sejarah_click);

        cardAlamClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "alam");
                startActivity(i);
            }
        });

        cardKulinerClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "kuliner");
                startActivity(i);
            }
        });

        cardKolamClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "kolam");
                startActivity(i);
            }
        });

        cardTamanClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "taman");
                startActivity(i);
            }
        });

        cardSeniClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "seni");
                startActivity(i);
            }
        });

        cardSejarahClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "sejarah");
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.language :

                return true;
            case R.id.about :

                return true;
            case R.id.exit :

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}