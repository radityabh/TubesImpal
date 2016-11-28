/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author The Keong's
 */
public class Pegawai extends User{
    public Pegawai(String Username, String Password, String Nama, String Email, String noHp, String idUser) {
        super(Username, Password, Nama, Email, noHp, idUser);
    }

    @Override
    public void setIdUser(String idUser) {
        super.setIdUser(idUser); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdUser() {
        return super.getIdUser(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNoHp(String noHp) {
        super.setNoHp(noHp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNoHp() {
        return super.getNoHp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String Email) {
        super.setEmail(Email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNama(String Nama) {
        super.setNama(Nama); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNama() {
        return super.getNama(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String Password) {
        super.setPassword(Password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUsername(String Username) {
        super.setUsername(Username); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUsername() {
        return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
