package com.example.reza.tourdepvjmine.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.reza.tourdepvjmine.db.DataHelper;
import com.example.reza.tourdepvjmine.DetailWisataActivity;
import com.example.reza.tourdepvjmine.R;
import com.example.reza.tourdepvjmine.model.TempatWisata;
import com.example.reza.tourdepvjmine.adapter.AdapterListWisata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;

public class ListWisataActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog dialog;

    float[] arrayJarakKeLokasi;
    TempatWisata[] arrayTempatWisata;
    TempatWisata tempatWisata;

    private Double currentLat;
    private Double currentLong;

    Toolbar tolbar;
    ListView ListView01;
    Menu menu;
    Context context;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static ListWisataActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupGoogleAPI();
        setupDialog();

        ma = this;
        dbcenter = new DataHelper(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDialog(){
        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setMessage("Loading");
    }

    private void setupGoogleAPI(){
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);

        Intent intent = getIntent();
        final int kategori = intent.getIntExtra("kategori", 0);
        if(mLastLocation != null){
            SQLiteDatabase db = dbcenter.getReadableDatabase();
            if (kategori != 0){
                cursor = db.rawQuery("SELECT * FROM wisata where kategori_wisata = "+kategori+"", null);
            } else {
                cursor = db.rawQuery("SELECT * FROM wisata", null);
            }
            arrayTempatWisata = new TempatWisata[cursor.getCount()];
            arrayJarakKeLokasi = new float[cursor.getCount()];
            cursor.moveToFirst();

            for (int cc = 0; cc < cursor.getCount(); cc++) {
                cursor.moveToPosition(cc);
                tempatWisata = new TempatWisata();
                tempatWisata.setNamaTempat(cursor.getString(1).toString());
                tempatWisata.setAlamat(cursor.getString(10).toString());
                tempatWisata.setLatitude(cursor.getDouble(8));
                tempatWisata.setLongitude(cursor.getDouble(9));
                tempatWisata.setJarak(hitungJarakKeLokasi(tempatWisata.getLatitude(), tempatWisata.getLongitude()));
                tempatWisata.setFoto(cursor.getString(11));
                tempatWisata.setKategori(cursor.getInt(12));
                arrayTempatWisata[cc] = tempatWisata;
            }

            context = this;

            ListView01 = (ListView) findViewById(R.id.listView1);
            ListView01.setAdapter(new AdapterListWisata(this, arrayTempatWisata));
            ListView01.setSelected(true);
            ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View view, int position, long arg3) {
                    Intent i = new Intent(ListWisataActivity.this, DetailWisataActivity.class);
                    String namaWisata = ((TextView)view.findViewById(R.id.nama_tempat_wisata)).getText().toString();
                    i.putExtra("namawisata", namaWisata);
                    startActivity(i);
                }
            });
        } else {
            Toast.makeText(this,"null", Toast.LENGTH_LONG).show();
        }
    }

    private float hitungJarakKeLokasi(Double lati, Double longi){
        float distanceInMeters = 0;
        if(mLastLocation != null) {
            Location loc1 = new Location("");
            loc1.setLatitude(mLastLocation.getLatitude());
            loc1.setLongitude(mLastLocation.getLongitude());

            setCurrentLat(loc1.getLatitude());
            setCurrentLong(loc1.getLongitude());

            Location loc2 = new Location("");
            loc2.setLatitude(lati);
            loc2.setLongitude(longi);

            distanceInMeters = loc1.distanceTo(loc2);
        } else {
            Toast.makeText(this,"method distanceTo Gagal", Toast.LENGTH_SHORT).show();
        }
        return distanceInMeters/1000;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public Double getCurrentLat() {
        return currentLat;
    }

    public void setCurrentLat(Double currentLat) {
        this.currentLat = currentLat;
    }

    public Double getCurrentLong() {
        return currentLong;
    }

    public void setCurrentLong(Double currentLong) {
        this.currentLong = currentLong;
    }
}