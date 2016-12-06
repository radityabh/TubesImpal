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
    private ArrayList<Mutasi> mutasi;
    private ArrayList<Barang> lBarang;
    private ArrayList<Tanah> lTanah;
    private ArrayList<Barang> br ;
    private ArrayList<Tanah> tmpTanah ;
    private Database d= new Database();
    private  Admin adm = new Admin("admin","admin", "radit", "no", "085642286535", "a");;
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private String tmp;

    public Aplikasi() {
        adm.setPegawai(d.readAllPegawai());
        lBarang = new ArrayList();
        lTanah = new ArrayList();
        mutasi = new ArrayList();
        lBarang = d.readAllBarang();
        lTanah = d.readAllTanah();
    }
    
    
    
    public void addBarang(String namaBarang,String status,Date tanggal,String idPegawai,int stok, String Konfirmasi){
      
        String i = "B-"+(lBarang.size()+1);
        Barang b = new Barang(i, namaBarang, status, tanggal, idPegawai,stok , Konfirmasi);
        this.lBarang.add(b);
        d.saveBarang(i, namaBarang, status, tanggal, idPegawai, stok, Konfirmasi);
    }
    
    public void addMutasi(String namaAwal, String namaAkhir){
        Mutasi m = new Mutasi(namaAwal, namaAkhir);
        mutasi.add(m);
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
        d.saveTanah(s, lokasi, namaPemilik, Ukuran, idPegawai, Tanggal, Konfirmasi);
    }
    
    public boolean loginPegawai(String Username, String pass){
        if (adm.getPegawai2(Username, pass)!=null){
            return true;
        }
        return false;
    }

    public Barang getBarang(String id) {
        for(int x = 0; x<lBarang.size();x++){
            if(lBarang.get(x).getIdBarang()== id){
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
    
    public Tanah getTanah2(String nama) {
        for(int x = 0; x<lTanah.size();x++){
            if(lTanah.get(x).getNamaPemilik().equals(nama) && lTanah.get(x).getKonfirmasi().equals("DiTerima")){
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
            if(lBarang.get(x).getKonfirmasi().equals("Tunggu Konfirmasi")){
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
            if(lTanah.get(x).getKonfirmasi().equals("Tunggu Konfirmasi") || lTanah.get(x).getKonfirmasi().equals("Tunggu Konfirmasi1")){
                tmpTanah.add(lTanah.get(x));
            }
        }
        String out[][] = new String[tmpTanah.size()][7];
        for (int i = 0;i < tmpTanah.size();i++){
                out[i][0] = tmpTanah.get(i).getIdTanah();
                out[i][1] = tmpTanah.get(i).getNamaPemilik();
                out[i][2] = tmpTanah.get(i).getLokasi();
                out[i][3] = Integer.toString(tmpTanah.get(i).getUkuran());
                out[i][4] = format.format(tmpTanah.get(i).getTanggal());
                out[i][5] = adm.getPegawai3(tmpTanah.get(i).getIdPegawai()).getNama();
                if (tmpTanah.get(i).getKonfirmasi().equals("Tunggu Konfirmasi")){
                    out[i][6] = "Input Baru";
                }else{
                    out[i][6] = "Mutasi";
                }
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
                if (lTanah.get(i).getKonfirmasi().equals("Tunggu Konfirmasi"))
                    out[i][4] = lTanah.get(i).getKonfirmasi();
                else if(lTanah.get(i).getKonfirmasi().equals("DiTolak1"))
                     out[i][4] = "DiTerima";
                else
                    out[i][4] = "DiTerima";
            }
        return out;
    }
    
    public String[][] getListOutSearchTanah(Tanah t){
        String out[][] = new String[1][4];
        out[0][0] = t.getIdTanah();
        out[0][1] = t.getNamaPemilik();
        out[0][2] = t.getLokasi();
        out[0][3] = Integer.toString(t.getUkuran());
        return out;
    }
    
    public String[][] getListOutMutasiTanah(){
        String out[][] = new String[lTanah.size()][5];
        for (int i = 0;i < lTanah.size();i++){
            if (!lTanah.get(i).getKonfirmasi().equals("Tunggu Konfirmasi") && !lTanah.get(i).getKonfirmasi().equals("DiTerima")){
                out[i][0] = lTanah.get(i).getIdTanah();
                out[i][1] = lTanah.get(i).getNamaPemilik();
                out[i][2] = lTanah.get(i).getLokasi();
                out[i][3] = Integer.toString(lTanah.get(i).getUkuran());
                if (lTanah.get(i).getKonfirmasi().equals("Tunggu Konfirmasi1"))
                    out[i][4] = "Tunggu Konfirmasi";
                else if(lTanah.get(i).getKonfirmasi().equals("DiTolak1"))
                     out[i][4] = "DiTolak";
                else if(lTanah.get(i).getKonfirmasi().equals("DiTerima1"))
                    out[i][4] = "DiTerima";
            }
        }
        return out;
    }
    
    public void knfrmBarang(Barang b,String status){
        adm.konfirmasiBarang(b, status);
        d.konfirmasiBarang(b.getIdBarang(), status);
    }
    
    public void knfrmTanah(Tanah t,String status){
        adm.konfirmasiTanah(t, status);
        d.konfirmasiTanah(t.getIdTanah(), status);
    }

    public String getTmp() {
        return tmp;
    }
    public void setTmp(String Status){
        if (Status.equals("Tunggu Konfirmasi"))
                this.tmp="Input Baru";
        else if (Status.equals("Tunggu Konfirmasi1"))
            this.tmp="Mutasi";
    }
}
