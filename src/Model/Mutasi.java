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
public class Mutasi {
    private String namaAsal;
    private String namaBaru;
    private int stok;
    private String Status;

    public Mutasi(String namaAsal, int stok, String Status) {
        this.namaAsal = namaAsal;
        this.stok = stok;
        this.namaBaru= "";
        this.Status = Status;
    }
    

    public Mutasi(String namaAsal, String namaBaru) {
        this.namaAsal = namaAsal;
        this.namaBaru = namaBaru;
    }

    Mutasi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public String getNamaAsal() {
        return namaAsal;
    }

    public void setNamaAsal(String namaAsal) {
        this.namaAsal = namaAsal;
    }

    public String getNamaBaru() {
        return namaBaru;
    }

    public void setNamaBaru(String namaBaru) {
        this.namaBaru = namaBaru;
    }
    
    
}
