/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author The Keong's
 */
public class Tanah {
    private String idTanah;
    private String lokasi;
    private String namaPemilik;
    private int Ukuran;
    private String idPegawai;
    private Date tanggal;

    public Tanah(String idTanah, String lokasi, String namaPemilik, int Ukuran, String idPegawai, Date tanggal) {
        this.idTanah = idTanah;
        this.lokasi = lokasi;
        this.namaPemilik = namaPemilik;
        this.Ukuran = Ukuran;
        this.idPegawai = idPegawai;
        this.tanggal = tanggal;
    }
    
    

    public String getIdTanah() {
        return idTanah;
    }

    public void setIdTanah(String idTanah) {
        this.idTanah = idTanah;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public int getUkuran() {
        return Ukuran;
    }

    public void setUkuran(int Ukuran) {
        this.Ukuran = Ukuran;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
