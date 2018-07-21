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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reza.tourdepvjmine.R;
import com.example.reza.tourdepvjmine.adapter.AdapterListWisata;
import com.example.reza.tourdepvjmine.model.TempatWisata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

/**
 *
 * @author Reza Dwi Kurniawan & Maulana Ibrahim
 */

public class DetailWisataActivity extends AppCompatActivity {
    Resources resources;
    ImageView image, collapsingImage;
    TextView alamatTempat, deskripsiTempat, kontakPengelola, jamOperasional, hargaTiket, fasilitas;

    private TempatWisata tempatWisata;
    CollapsingToolbarLayout collapsingToolbarLayout;
    private DatabaseReference reference;

    private String namaTempat, jarak;
    private Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        tempatWisata = new TempatWisata();

        Toolbar toolbarDetail = (Toolbar) findViewById(R.id.toolbarIdDetail);
        setSupportActionBar(toolbarDetail);

        toolbarDetail.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbarDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //mengambil passing parameter dari Activity list
        Intent intent = getIntent();
        namaTempat = intent.getStringExtra("namaTempat");
        jarak = intent.getStringExtra("jarak");

        //set refference untuk database firebase
        reference = FirebaseDatabase.getInstance().getReference("tempat-wisata");

        // filter untuk value tertentu yang akan diambil
        query = reference.orderByChild("namaTempat").equalTo(namaTempat);

        collapsingImage = (ImageView) findViewById(R.id.collapsing_image);
        alamatTempat = (TextView)findViewById(R.id.alamat_tempat_wisata_detail);
        deskripsiTempat = (TextView)findViewById(R.id.deskripsi);
        kontakPengelola = (TextView)findViewById(R.id.kontak_pengelola);

        //reference.child("rating").setValue(4);

        //memanggil method untuk mengambil data di firebase
        ambilData();

        image = (ImageView) findViewById(R.id.maps);
        image.setClickable(true);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailWisataActivity.this,MapsActivity.class);
                i.putExtra("latitude",tempatWisata.getLatitude());
                i.putExtra("longitude",tempatWisata.getLongitude());
                i.putExtra("jarak", jarak);
                startActivity(i);
            }
        });

        resources = getResources();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_detail);
    }

    //method untuk set data yang di ambil dari firebase ke activity detail
    public void setData(TempatWisata tempatWisata){
        alamatTempat.setText(tempatWisata.getAlamat());
        deskripsiTempat.setText(tempatWisata.getDeskripsi());
        if(tempatWisata.getKontakPengelola().equals("-")){
            kontakPengelola.setText("Tidak Tersedia");
        } else {
            kontakPengelola.setText(tempatWisata.getKontakPengelola());
        }
    }

    //method untuk mengambil data dari firebase
    public void ambilData(){
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataWisata: dataSnapshot.getChildren()){
                    tempatWisata = dataWisata.getValue(TempatWisata.class);
                }
                collapsingToolbarLayout.setTitle(tempatWisata.getNamaTempat());
                setData(tempatWisata);
                Glide.with(DetailWisataActivity.this).load(tempatWisata.getFoto()).into(collapsingImage);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("message", "Gagal Mengambil Data" + databaseError);
            }
        });
    }
}