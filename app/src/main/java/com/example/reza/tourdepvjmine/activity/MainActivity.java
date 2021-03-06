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
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reza.tourdepvjmine.R;

/**
 *
 * @author Said Al-Fakhri
 */

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;

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
                i.putExtra("cari", "");
                startActivity(i);
            }
        });

        cardKulinerClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "kuliner");
                i.putExtra("cari", "");
                startActivity(i);
            }
        });

        cardKolamClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "kolam");
                i.putExtra("cari", "");
                startActivity(i);
            }
        });

        cardTamanClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "taman");
                i.putExtra("cari", "");
                startActivity(i);
            }
        });

        cardSeniClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "seni");
                i.putExtra("cari", "");
                startActivity(i);
            }
        });

        cardSejarahClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "sejarah");
                i.putExtra("cari", "");
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //passing kata kunci yang diketikkan user di searchview
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", "");
                i.putExtra("cari", s);
                startActivity(i);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about :
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.exit :
                    System.exit(0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}