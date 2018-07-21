package com.example.reza.tourdepvjmine.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.reza.tourdepvjmine.R;
import com.example.reza.tourdepvjmine.model.TempatWisata;
import com.example.reza.tourdepvjmine.adapter.AdapterListWisata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 *
 * @author Reza Dwi Kurniawan
 */


public class ListWisataActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private com.google.firebase.database.Query query;
    private ArrayList<TempatWisata> arrayTempatWisata;
    private ListView listWisata;

    private ProgressDialog progressDialog;

    static final int REQUEST_LOCATION = 1;
    private LocationManager locationManager;

    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        Intent intent = getIntent();
        String kategori = intent.getStringExtra("kategori");
        String cari = intent.getStringExtra("cari");

        //pengecekan nilai yang di passing dari main activity untuk keperluan search
        if(!kategori.equals("")){
            String actionKategori = kategori.substring(0,1).toUpperCase() + kategori.substring(1);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Wisata "+actionKategori);
        } else {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Wisata");
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Mohon Bersabar...");
        progressDialog.show();

        FirebaseDatabase.getInstance().getReference().keepSynced(true);

        //set reference untuk database
        reference = FirebaseDatabase.getInstance().getReference("tempat-wisata");

        // filter untuk value tertentu yang akan diambil
        if (cari.equals("")){
            query = reference.orderByChild("kategori").equalTo(kategori.toString());
        } else {
            query = reference.orderByChild("namaTempat").equalTo(cari.toString());
        }

        arrayTempatWisata = new ArrayList<>();
        listWisata = (ListView) findViewById(R.id.listView1);

        //pemanggilan method untuk mengambil data dari firebase
        ambilData();

        listWisata.setSelected(true);
        listWisata.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View view, int position, long arg3) {
                String namaTempat = ((TextView)view.findViewById(R.id.nama_tempat_wisata)).getText().toString();
                String jarak = ((TextView)view.findViewById(R.id.jarak_tempat_wisata)).getText().toString();
                Intent i = new Intent(ListWisataActivity.this, DetailWisataActivity.class);
                i.putExtra("namaTempat", namaTempat);
                i.putExtra("jarak", jarak);
                startActivity(i);
            }
        });

    }

    //method untuk mengambil data dari firebase
    public void ambilData(){
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataWisata: dataSnapshot.getChildren()){
                    TempatWisata tempatWisata = dataWisata.getValue(TempatWisata.class);
                    tempatWisata.setJarak(hitungJarak(tempatWisata.getLatitude(), tempatWisata.getLongitude()));
                    arrayTempatWisata.add(tempatWisata);
                }
                listWisata.setAdapter(new AdapterListWisata(ListWisataActivity.this, arrayTempatWisata));
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("message", "Gagal Mengambil Data" + databaseError);
            }
        });
    }

    //method menghitung jarak antara current location user dan tempat wisata yang bersangkutan
    public float hitungJarak(double latitudeTujuan, double longitudeTujuan){
        Location lokasiAwal = new Location("current");
        lokasiAwal.setLatitude(latitude);
        lokasiAwal.setLongitude(longitude);

        Location lokasiTujuan = new Location("tujuan");
        lokasiTujuan.setLatitude(latitudeTujuan);
        lokasiTujuan.setLongitude(longitudeTujuan);
        return lokasiAwal.distanceTo(lokasiTujuan)/1000;
    }

    //method untuk mengambil lokasi dari user yang bersangkutan
    public void getLocation(){
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location location =locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if(location != null){
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                } else {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permission, grantResult);

        switch (requestCode){
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }

}