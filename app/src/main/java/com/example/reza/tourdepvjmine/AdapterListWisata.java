package com.example.reza.tourdepvjmine;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class AdapterListWisata extends BaseAdapter{

    TempatWisata [] tempatWisata;
    Context context;

    private static LayoutInflater inflater = null;
    public AdapterListWisata(ListWisataActivity listWisataActivity, TempatWisata[] tempatWisata){
        this.tempatWisata = tempatWisata;
        context =listWisataActivity;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tempatWisata.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder{
        TextView textNama;
        TextView textAlamat;
        TextView textJarak;
        ImageView imageViewList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        NumberFormat nm1 = new DecimalFormat("#0.00");
        //Integer gambar = Integer.parseInt("R.drawable.kawahputih");
        //int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);

        View rowView;
            rowView = inflater.inflate(R.layout.list_wisata_layout, null);
            holder.textNama = (TextView) rowView.findViewById(R.id.nama_tempat_wisata);
            holder.textAlamat = (TextView) rowView.findViewById(R.id.alamat_tempat_wisata);
            holder.textJarak = (TextView) rowView.findViewById(R.id.jarak_tempat_wisata);
            holder.imageViewList = (ImageView) rowView.findViewById(R.id.image_view_list);

            holder.textNama.setText(tempatWisata[position].getNamaTempat());
            holder.textAlamat.setText(tempatWisata[position].getAlamat());
            holder.textJarak.setText(nm1.format(tempatWisata[position].getJarak())+" KiloMeter");
            holder.imageViewList.setImageResource(tempatWisata[position].getFoto());
        return rowView;
    }
}
