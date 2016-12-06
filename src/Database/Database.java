/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import Model.Aplikasi;
import Model.Barang;
import Model.Pegawai;
import Model.Tanah;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emp. Elesar II
 */
public class Database {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String dbUser = "root";
    private String dbPass = "";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;

    public Database() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/impal", dbUser, dbPass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet getData(String SQLString) {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQLString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void query(String SQLString) throws SQLException {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQLString);
        } catch (SQLException c) {
            throw new SQLException("Error eksekusi query");
        }
    }
    
    public ArrayList<Pegawai> readAllPegawai(){
        ArrayList<Pegawai> daftarPegawai = new ArrayList();
        String s = "Select Username, Password, Nama, Email, noHp, idUser from Pegawai";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                Pegawai p = new Pegawai(rs.getString("Username"),rs.getString("Password"),rs.getString("Nama"),rs.getString("Email"),rs.getString("noHp"),rs.getString("idUser"));
                daftarPegawai.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarPegawai;
    }
    
    public ArrayList<Barang> readAllBarang(){
        ArrayList<Barang> daftarBarang = new ArrayList();
        String s = "Select idBarang, namaBarang, status, tanggal, idPegawai, stok, konfirmasi from barang";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                Barang b;
                try {
                    b = new Barang(rs.getString("idBarang"),rs.getString("namaBarang"),rs.getString("status"),sdf.parse(rs.getString("tanggal")),rs.getString("idPegawai"),rs.getInt("stok"),rs.getString("konfirmasi"));
                    daftarBarang.add(b);
                } catch (ParseException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarBarang;
    }
    
    public ArrayList<Tanah> readAllTanah(){
        ArrayList<Tanah> daftarTanah = new ArrayList();
        String s = "Select idTanah, lokasi, namaPemilik , ukuran, idPegawai, tanggal, konfirmasi from tanah";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                Tanah t;
                try {
                    t = new Tanah(rs.getString("idTanah"),rs.getString("lokasi"),rs.getString("namaPemilik"),rs.getInt("ukuran"),rs.getString("idPegawai"),sdf.parse(rs.getString("tanggal")),rs.getString("konfirmasi"));
                    daftarTanah.add(t);
                } catch (ParseException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daftarTanah;
    }
    
    public void savePegawai(String Username, String Password, String Nama, String Email, String noHp,String id){
        String s = "insert into Pegawai values('"+Username+"','"+Password
                +"','"+Nama+"','"+Email+"','"+noHp+"','"+id+"')";
        try {
            query(s);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void saveBarang(String idBarang, String namaBarang, String status, Date tanggal, String idPegawai, int stok, String konfirmasi){
        String s = "insert into barang values('"+idBarang+"','"+namaBarang
                +"','"+status+"','"+sdf.format(tanggal)+"','"+idPegawai+"',"+stok+",'"+konfirmasi+"')";
        try {
            query(s);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void saveTanah(String idTanah, String lokasi, String namaPemilik, int Ukuran, String idPegawai, Date tanggal, String Konfirmasi){
        String s = "insert into tanah values('"+idTanah+"','"+lokasi
                +"','"+namaPemilik+"',"+Ukuran+",'"+idPegawai+"','"+sdf.format(tanggal)+"','"+Konfirmasi+"')";
        try {
            query(s);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void konfirmasiBarang(String id,String status){
        String s = "update barang set konfirmasi = '"+status+"' where idBarang = '"+id+"'";
        try {
            query(s);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void konfirmasiTanah(String id,String status){
        String s = "update tanah set konfirmasi = '"+status+"' where idTanah = '"+id+"'";
        try {
            query(s);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
