package com.example.reza.tourdepvjmine.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListWisataActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private com.google.firebase.database.Query query;
    private ArrayList<TempatWisata> arrayTempatWisata;
    private ListView listWisata;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reference = FirebaseDatabase.getInstance().getReference("tempat-wisata");

        Intent intent = getIntent();
        String kategori = intent.getStringExtra("kategori");

        // filter untuk value tertentu yang akan diambil
        query = reference.orderByChild("kategori").equalTo(kategori.toString());

        arrayTempatWisata = new ArrayList<>();

        listWisata = (ListView) findViewById(R.id.listView1);

        ambilData();

        listWisata.setSelected(true);
        listWisata.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View view, int position, long arg3) {
                Intent i = new Intent(ListWisataActivity.this, DetailWisataActivity.class);
                textView = (TextView)findViewById(R.id.nama_tempat_wisata);
                String namaTempat = textView.getText().toString();
                i.putExtra("namaTempat", namaTempat);
                startActivity(i);
            }
        });

    }


    public void ambilData(){
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataWisata: dataSnapshot.getChildren()){
                    TempatWisata tempatWisata = dataWisata.getValue(TempatWisata.class);
                    arrayTempatWisata.add(tempatWisata);
                }
                listWisata.setAdapter(new AdapterListWisata(ListWisataActivity.this, arrayTempatWisata));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}