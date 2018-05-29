package com.example.reza.tourdepvjmine.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reza.tourdepvjmine.activity.ListWisataActivity;
import com.example.reza.tourdepvjmine.R;
import com.example.reza.tourdepvjmine.model.TempatWisata;

import java.util.ArrayList;

public class AdapterListWisata extends BaseAdapter {

    private ArrayList<TempatWisata> tempatWisata;
    private Context context;
    private Resources resources;
    private int resID;
    private Drawable drawable;

    private static LayoutInflater inflater = null;
    public AdapterListWisata(ListWisataActivity listActivity, ArrayList<TempatWisata> tempatWisata){
        this.tempatWisata = tempatWisata;
        context =listActivity;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tempatWisata.size();
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
        ImageView imageView;
        TextView jarak;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        resources = parent.getResources();

        View rowView;
            rowView = inflater.inflate(R.layout.list_wisata_layout, null);
            holder.textNama = (TextView) rowView.findViewById(R.id.nama_tempat_wisata);
            holder.textAlamat = (TextView) rowView.findViewById(R.id.alamat_tempat_wisata);
            holder.imageView = (ImageView) rowView.findViewById(R.id.image_view_list);
            holder.jarak = (TextView) rowView.findViewById(R.id.jarak_tempat_wisata);

            holder.textNama.setText(tempatWisata.get(position).getNamaTempat());
            holder.textAlamat.setText(tempatWisata.get(position).getAlamat());
            //holder.jarak.setText(tempatWisata.get(position).getFoto());
            Glide.with(context).load(tempatWisata.get(position).getFoto()).into(holder.imageView);
        return rowView;
    }
}