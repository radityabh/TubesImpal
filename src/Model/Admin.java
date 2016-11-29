/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.util.ArrayList;

/**
 *
 * @author The Keong's
 */
public class Admin extends User{
    private ArrayList<Pegawai> daftarPegawai= new ArrayList<>();
    private int i;  
    private String id;
    Database d = new Database();

    public Admin(String Username, String Password, String Nama, String Email, String noHp, String idUser) {
        super(Username, Password, Nama, Email, noHp, idUser);
    }
    public void addPegawai(String Username, String Password, String Nama, String Email, String noHp){
        i=daftarPegawai.size()+1;
        id = "P-"+i;
        Pegawai p = new Pegawai(Username,Password,Nama ,Email,noHp,id);
        d.savePegawai(Username, Password, Nama, Email, noHp, id);
        daftarPegawai.add(p);
    }

    public ArrayList<Pegawai> getPegawai() {
        return daftarPegawai;
    }

    public void setPegawai(ArrayList<Pegawai> pegawai) {
        this.daftarPegawai = pegawai;
    }
    
    public Pegawai getPegawai2(String Username, String pass){
        for(int i=0;i<daftarPegawai.size();i++){
           if ((daftarPegawai.get(i).getUsername().equals(Username)) && (daftarPegawai.get(i).getPassword().equals(pass)))
               return daftarPegawai.get(i);
       }return null;
    }
    
    public String[][] getListOutPegawai(){
        String out[][] = new String[daftarPegawai.size()][6];
        for (int i = 0;i < daftarPegawai.size();i++){
                out[i][0] = daftarPegawai.get(i).getIdUser();
                out[i][1] = daftarPegawai.get(i).getUsername();
                out[i][2] = daftarPegawai.get(i).getPassword();
                out[i][3] = daftarPegawai.get(i).getNama();
                out[i][4] = daftarPegawai.get(i).getEmail();
                out[i][5] = daftarPegawai.get(i).getNoHp();
            }
        return out;
    }
    
    public void konfirmasiBarang(Barang b, String kon){
        b.setKonfirmasi(kon);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
