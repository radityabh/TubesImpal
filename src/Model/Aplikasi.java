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
        lBarang = new ArrayList();
        lTanah = new ArrayList();
    }
    
    
    
    public void addBarang(String namaBarang,String status,Date tanggal,String idPegawai,int stok, String Konfirmasi){
      
        String i = "B-"+(lBarang.size()+1);
        Barang b = new Barang(i, namaBarang, status, tanggal, idPegawai,stok , Konfirmasi);
        this.lBarang.add(b);
    }
    
    
    public void ubahStatusBarang(String namaBarang, String status){
        for (int i = 0; i < lBarang.size(); i++) {
            if (lBarang.get(i).getNamaBarang().equals(namaBarang)){
                lBarang.get(i).setStatus(status);
            }
        }
    }
    
    public void addTanah(String lokasi,String namaPemilik,int Ukuran,String idPegawai,Date Tanggal,String Konfirmasi){
        String s="T-"+(lTanah.size()+1);
        Tanah t = new Tanah(s, lokasi, namaPemilik, Ukuran, idPegawai, Tanggal, Konfirmasi);
        this.lTanah.add(t);
    }
    
    public boolean loginPegawai(String Username, String pass){
        if (adm.getPegawai2(Username, pass)!=null){
            return true;
        }
        return false;
    }
    
    public void addPegawai(String Username, String Password, String Nama, String Email, String noHp){
        adm.addPegawai(Username, Password, Nama, Email, noHp);
    }
    
    public Pegawai getPegawai(String Username, String pass){
        return adm.getPegawai2(Username, pass);
    }
    
    public String[][] outlistPegawai(){
        return adm.getListOutPegawai();
    }
    
    public String[][] getListOutBarang(){
        String out[][] = new String[lBarang.size()][5];
        for (int i = 0;i < lBarang.size();i++){
                out[i][0] = lBarang.get(i).getIdBarang();
                out[i][1] = lBarang.get(i).getNamaBarang();
                out[i][2] = Integer.toString(lBarang.get(i).getStok());
                out[i][3] = lBarang.get(i).getStatus();
                out[i][4] = lBarang.get(i).getKonfirmasi();
            }
        return out;
    }
    
    public String[][] getListOutTanah(){
        String out[][] = new String[lTanah.size()][5];
        for (int i = 0;i < lTanah.size();i++){
                out[i][0] = lTanah.get(i).getIdTanah();
                out[i][1] = lTanah.get(i).getNamaPemilik();
                out[i][2] = lTanah.get(i).getLokasi();
                out[i][3] = Integer.toString(lTanah.get(i).getUkuran());
                out[i][4] = lTanah.get(i).getKonfirmasi();
            }
        return out;
    }
}
