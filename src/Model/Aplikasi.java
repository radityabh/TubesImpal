/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author The Keong's
 */
public class Aplikasi {
    private ArrayList<Barang> lBarang;
    private ArrayList<Tanah> lTanah;
    private Database d= new Database();
    private  Admin adm = new Admin("admin","admin", "radit", "no", "085642286535", "a");;

    public Aplikasi() {
        adm.setPegawai(d.readAllPegawai());
        
    }
    
    
    
    public void addBarang(String namaBarang,String status,Date tanggal,String idPegawai,int stok, String lokasi){
        String i= "B-"+lBarang.size()+1;
        Barang b = new Barang(i, namaBarang, status, tanggal, idPegawai,stok , lokasi);
        this.lBarang.add(b);
    }
    
    
    public void ubahStatusBarang(String namaBarang, String status){
        for (int i = 0; i < lBarang.size(); i++) {
            if (lBarang.get(i).getNamaBarang().equals(namaBarang)){
                lBarang.get(i).setStatus(status);
            }
        }
    }
    
    public void addTanah(String lokasi,String namaPemilik,int Ukuran,String idPegawai,Date Tanggal){
        String s="T-"+lTanah.size()+1;
        Tanah t = new Tanah(s, lokasi, namaPemilik, Ukuran, idPegawai, Tanggal);
        this.lTanah.add(t);
    }
    
    public boolean loginPegawai(String Username, String pass){
        if (!adm.getPegawai2(Username, pass).equals(null)){
            return true;
        }
        return false;
    }
    
    public Pegawai getPegawai(String Username, String pass){
        return adm.getPegawai2(Username, pass);
    }
}
