package com.example.reza.tourdepvjmine.db;

public class Query {

    private static final int WISATA_ALAM = 1;
    private static final int WISATA_KULINER = 2;
    private static final int WISATA_KOLAM_RENANG = 3;
    private static final int WISATA_TAMAN = 4;
    private static final int WISATA_SENI_BUDAYA = 5;
    private static final int WISATA_SEJARAH = 6;

    public static final String CREATE_TABLE_WISATA = "CREATE TABLE wisata(id_wisata integer primary key autoincrement, " +
            "nama_wisata text null, jam_buka text null, jam_tutup text null, deskripsi_wisata text null, " +
            "fasilitas text null, harga_masuk integer null, kontak_pengelola text null, lat real null, long real null, " +
            "alamat text null, foto Integer null, kategori_wisata integer null, id_lokasi integer null);";
    public static final String CREATE_TABLE_LOKASI = "CREATE TABLE lokasi(id_lokasi integer primary key, " +
            "nama_lokasi text null, latitude real null, longitude real null);";
    public static final String CREATE_TABLE_FEEDBACK = "CREATE TABLE feedback(kode_feedback integer primary key autoincrement, " +
            "ulasan_feedback text null, nama_pemberi_feedback text null);";

    public static final String INSERT_KAWAH_PUTIH = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Kawah Putih', '-7.166783', '107.401996','Lembang,Kabupaten Bandung Barat','kawahputih',"+WISATA_ALAM+");";
    public static final String INSERT_TOKO_YOU = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Toko You', '-6.895090', '107.614723','Jl. Hasanudin No.12, Lebakgede, Coblong, Kota Bandung, Jawa Barat 40132','tokoyou',"+WISATA_KULINER+");";
    public static final String INSERT_LAWANGWANGI = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Lawangwangi Creative Space Cafe', '-6.847880', '107.627469','Jalan Dago Giri No. 99A, Mekarwangi, Lembang, Mekarwangi, Lembang, Bandung, Jawa Barat 40391','lawangwangi',"+WISATA_KULINER+");";
    public static final String INSERT_TANGKUBAN_PERAHU = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Tangkuban Perahu', '-6.767213', '107.622624','Desa Cikahuripan, Kecamatan Lembang, Kabupaten Bandung Barat, Jawa Barat ','tangkuban_perahu',"+WISATA_ALAM+");";
    public static final String INSERT_SITU_PATENGGANG = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('situ Patenggang', '-7.166965', '107.357534','Jalan Raya Ciwidey-Rancabali, Desa Patengan, Kec. Rancabali, Kab. Bandung, Jawa Barat 40973','situ_patenggang',"+WISATA_ALAM+");";
    public static final String INSERT_BATAGOR_H = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Batagor H.Ihsan', '-6.928791', '107.599390','Jalan Bojongloa No.38, Panjunan, Astanaanyar Panjunan ,Astanaanyar','batagor_hj_ihsan',"+WISATA_KULINER+");";
    public static final String INSERT_KARANG_SETRA = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Karang Setra', '-6.878167', '107.594626','jalan sirnagalih KM.4.5 No.15 Gegerkalong, Sukasari, Kota Bandung','karangsetra',"+WISATA_KOLAM_RENANG+");";
    public static final String INSERT_TAMAN_JOMBLO = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Taman Jomblo', '-6.898110', '107.609254','jl.taman sari no.66,lb.siliwangi,coblong ,kota bandung','tamanjomblo',"+WISATA_TAMAN+");";
    public static final String INSERT_AMAZING_ART = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Amazing Art World', '-6.851784', '107.595607','jl.setiabudhi No.293, isola,sukasari,kota bandung','amazingartworld',"+WISATA_SENI_BUDAYA+");";
    public static final String INSERT_MUSEUM_GEOLOGI = "INSERT INTO wisata (nama_wisata, lat, long, alamat, foto, kategori_wisata) VALUES ('Museum Geologi', '-6.900708', '107.621491','Jl.Diponegoro no.57 cihaurgeulis, cibeunying kaler, kota bandung','museum_geologi_bandung',"+WISATA_SEJARAH+");";
}
