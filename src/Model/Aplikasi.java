/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author The Keong's
 */
public class Aplikasi {
    private ArrayList<Barang> lBarang;
    private ArrayList<Tanah> lTanah;
    private ArrayList<Barang> br ;
    private ArrayList<Tanah> tmpTanah ;
    private Database d= new Database();
    private  Admin adm = new Admin("admin","admin", "radit", "no", "085642286535", "a");;
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

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

    public Barang getBarang(String nama) {
        for(int x = 0; x<lBarang.size();x++){
            if(lBarang.get(x).getIdBarang()== nama){
                return lBarang.get(x);
            }
        } return null;
    }
    public Tanah getTanah(String ID) {
        for(int x = 0; x<lTanah.size();x++){
            if(lTanah.get(x).getIdTanah()== ID){
                return lTanah.get(x);
            }
        } return null;
    }
    
    public Tanah getTmpTanah(int i){
        return lTanah.get(i);
    }
    
    public Barang getTmpBarang(int i){
        return br.get(i);
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
    
    public String[][] getListOutKonfirmasiBarang(){
        br = new ArrayList();
        for(int x = 0; x<lBarang.size();x++){
            if(lBarang.get(x).getKonfirmasi()=="WAITING"){
                br.add(lBarang.get(x));
            }
        }
        String out[][] = new String[br.size()][6];
        for (int i = 0;i < br.size();i++){
                out[i][0] = br.get(i).getIdBarang();
                out[i][1] = br.get(i).getNamaBarang();
                out[i][2] = Integer.toString(br.get(i).getStok());
                out[i][3] = br.get(i).getStatus();
                out[i][4] = format.format(br.get(i).getTanggal());
                out[i][5] = adm.getPegawai3(br.get(i).getIdPegawai()).getNama();
            }
        return out;
    }
    
    public String[][] getListOutKonfirmasiTanah(){
        tmpTanah= new ArrayList();
        for(int x = 0; x<lTanah.size();x++){
            if(lTanah.get(x).getKonfirmasi()=="WAITING"){
                tmpTanah.add(lTanah.get(x));
            }
        }
        String out[][] = new String[tmpTanah.size()][6];
        for (int i = 0;i < tmpTanah.size();i++){
                out[i][0] = tmpTanah.get(i).getIdTanah();
                out[i][1] = tmpTanah.get(i).getNamaPemilik();
                out[i][2] = tmpTanah.get(i).getLokasi();
                out[i][3] = Integer.toString(tmpTanah.get(i).getUkuran());
                out[i][4] = format.format(tmpTanah.get(i).getTanggal());
                out[i][5] = adm.getPegawai3(tmpTanah.get(i).getIdPegawai()).getNama();
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
    
    public void knfrmBarang(Barang b,String status){
        adm.konfirmasiBarang(b, status);
    }
    
    public void knfrmTanah(Tanah t,String status){
        adm.konfirmasiTanah(t, status);
    }
    
}
