package com.example.reza.tourdepvjmine.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reza.tourdepvjmine.activity.ListWisataActivity;
import com.example.reza.tourdepvjmine.R;
import com.example.reza.tourdepvjmine.model.TempatWisata;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AdapterListWisata extends BaseAdapter{

    TempatWisata[] tempatWisata;
    Context context;
    Resources resources;

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
        resources = parent.getResources();

        View rowView;
            rowView = inflater.inflate(R.layout.list_wisata_layout, null);
            holder.textNama = (TextView) rowView.findViewById(R.id.nama_tempat_wisata);
            holder.textAlamat = (TextView) rowView.findViewById(R.id.alamat_tempat_wisata);
            holder.textJarak = (TextView) rowView.findViewById(R.id.jarak_tempat_wisata);
            holder.imageViewList = (ImageView) rowView.findViewById(R.id.image_view_list);

            holder.textNama.setText(tempatWisata[position].getNamaTempat());
            holder.textAlamat.setText(tempatWisata[position].getAlamat());
            holder.textJarak.setText(nm1.format(tempatWisata[position].getJarak())+" KiloMeter");
            int resID = resources.getIdentifier(tempatWisata[position].getFoto(), "drawable","com.example.reza.tourdepvjmine");
            Drawable drawable = resources.getDrawable(resID);
            holder.imageViewList.setImageDrawable(drawable);
        return rowView;
    }
}
