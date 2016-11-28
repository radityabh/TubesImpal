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
public class Barang {
    private String idBarang;
    private String namaBarang;
    private String status;
    private Date tanggal;
    private String idPegawai;
    private int stok;
    private String lokasi;

    public Barang(String idBarang, String namaBarang, String status, Date tanggal, String idPegawai, int stok, String lokasi) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.status = status;
        this.tanggal = tanggal;
        this.idPegawai = idPegawai;
        this.stok = stok;
        this.lokasi = lokasi;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
    
    
}
