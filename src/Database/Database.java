/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import Model.Aplikasi;
import Model.Pegawai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emp. Elesar II
 */
public class Database {

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
    public void savePegawai(String Username, String Password, String Nama, String Email, String noHp,String id){
        String s = "insert into Pegawai values('"+Username+"','"+Password
                +"','"+Nama+"','"+Email+"','"+noHp+"','"+id+"')";
        try {
            query(s);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
 

}
