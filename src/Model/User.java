/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author The Keong's
 */
public class User {
    private String Username;
    private String Password;
    private String Nama;
    private String Email;
    private String noHp;
    private String idUser;

    public User(String Username, String Password, String Nama, String Email, String noHp, String idUser) {
        this.Username = Username;
        this.Password = Password;
        this.Nama = Nama;
        this.Email = Email;
        this.noHp = noHp;
        this.idUser = idUser;
    }
    

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
}
