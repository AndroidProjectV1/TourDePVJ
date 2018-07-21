package com.example.reza.tourdepvjmine.model;

/**
 *
 * @author Reza Dwi Kurniawan
 */

public class TempatWisata {
    private String namaTempat;
    private String alamat;
    private String kategori;
    private String deskripsi;
    private String kontakPengelola;
    private double latitude;
    private double longitude;
    private String foto;
    private float jarak;

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getJarak() {
        return jarak;
    }

    public void setJarak(float jarak) {
        this.jarak = jarak;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKontakPengelola() {
        return kontakPengelola;
    }

    public void setKontakPengelola(String kontakPengelola) {
        this.kontakPengelola = kontakPengelola;
    }
}