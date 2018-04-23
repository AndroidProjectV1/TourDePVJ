package com.example.reza.tourdepvjmine;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.reza.tourdepvjmine.admin.DataHelper;
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

    ListView ListView01;
    Menu menu;
    Context context;
    protected Cursor cursor;
    com.example.reza.tourdepvjmine.admin.DataHelper dbcenter;
    public static ListWisataActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);

        setupGoogleAPI();
        setupDialog();

        ma = this;
        dbcenter = new DataHelper(this);
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
        if(mLastLocation != null){
            SQLiteDatabase db = dbcenter.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM wisata", null);
            arrayTempatWisata = new TempatWisata[cursor.getCount()];
            arrayJarakKeLokasi = new float[cursor.getCount()];
            cursor.moveToFirst();
            for (int cc = 0; cc < cursor.getCount(); cc++) {
                cursor.moveToPosition(cc);
                tempatWisata = new TempatWisata();
                tempatWisata.setNamaTempat(cursor.getString(1).toString());
                tempatWisata.setAlamat(cursor.getString(4).toString());
                tempatWisata.setLatitude(cursor.getDouble(2));
                tempatWisata.setLongitude(cursor.getDouble(3));
                tempatWisata.setJarak(hitungJarakKeLokasi(tempatWisata.getLatitude(), tempatWisata.getLongitude()));
                arrayTempatWisata[cc] = tempatWisata;
            }

            context = this;

            ListView01 = (ListView) findViewById(R.id.listView1);
            ListView01.setAdapter(new AdapterListWisata(this, arrayTempatWisata));
            ListView01.setSelected(true);
            ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                    Intent i = new Intent(ListWisataActivity.this, DetailWisata.class);
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

            Location loc2 = new Location("");
            loc2.setLatitude(lati);
            loc2.setLongitude(longi);

            //distanceInMeters = (int) Math.round(loc1.distanceTo(loc2));
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
}