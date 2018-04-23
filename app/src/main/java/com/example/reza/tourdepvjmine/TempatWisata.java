package com.example.reza.tourdepvjmine;

public class TempatWisata {
    private String namaTempat;
    private String Alamat;
    private double latitude;
    private double longitude;
    private  Float jarak;

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Float getJarak() {
        return jarak;
    }

    public void setJarak(Float jarak) {
        this.jarak = jarak;
    }
}