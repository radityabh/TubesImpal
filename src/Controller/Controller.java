/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Barang;
import Model.Pegawai;
import Model.Tanah;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.PanelContainer;
import view.vAdmin;
import view.vLogin;
import view.vPegawai;

/**
 *
 * @author The Keong's
 */
public class Controller extends MouseAdapter implements ActionListener {
    private Aplikasi model;
    private PanelContainer view;
    
    private String currentView;
    private String idSeleksi = "";
    private String lokasiSeleksi = "";
    private String tujuanSeleksi = "";
    private JPanel mainPanel;
    private boolean posisi;
    private Pegawai p;
    private Barang b;
    private Tanah T;
    private Date d;
    
    private vLogin l;
    private vAdmin adm;
    private vPegawai peg;
    
    public Controller(Aplikasi model){
        this.model = model;
        this.view = new PanelContainer();
        
        l = new vLogin();
        adm = new vAdmin();
        peg = new vPegawai();
        
        l.addListener(this);
        adm.addListener(this);
        adm.addAdapter(this);
        peg.addListener(this);
        
        
        mainPanel=view.getMainPanel();
        mainPanel.add(l,"0");
        mainPanel.add(adm,"1");
        mainPanel.add(peg,"2");
        currentView = "0";
        
        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
    }
    
    
    @Override
     public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(adm.tabelKonfirmasiSelected())&&adm.getSelectedKonfirmasi() >= 0){
            if(adm.getKonfirmasi()=="Barang"){
                idSeleksi = model.getTmpBarang(adm.getSelectedKonfirmasi()).getIdBarang();
            }else if (adm.getKonfirmasi()=="Tanah"){
                idSeleksi = model.getTmpTanah(adm.getSelectedKonfirmasi()).getIdTanah();
            }
                   
        }
     }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (currentView.equals("0")){
            if(source.equals(l.masukButtonPressed())){
                if(l.getUsername().equals("")||l.getPassword().equals("")){
                    JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else if (l.getUsername().equals("admin") && l.getPassword().equals("admin")){
                    adm.refresh();
                    currentView="1";
                    view.getCardLayout().show(mainPanel, currentView);
                    adm.setListOutPegawai(model.outlistPegawai());
                } else if(model.loginPegawai(l.getUsername(), l.getPassword())){
                    peg.refresh();
                    currentView="2";
                    view.getCardLayout().show(mainPanel, currentView);
                    p = model.getPegawai(l.getUsername(), l.getPassword());
                    peg.setListOutBarang(model.getListOutBarang());
                    peg.setListOutTanah(model.getListOutTanah());
                    
                } else if (!model.loginPegawai(l.getPassword(), l.getPassword())){
                    JOptionPane.showMessageDialog(null, "User tidak ada atau username dan pass salah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }   
                
            }
        } else if (currentView.equals("1")){
            if (source.equals(adm.tambahPressed())){
                if(adm.getNama().equals("")||adm.getUsername().equals("")||adm.getPass().equals("")||adm.getEmail().equals("")||adm.getNohp().equals("")){
                    JOptionPane.showMessageDialog(null, "Cek Kembali inputan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.addPegawai(adm.getUsername(),adm.getPass() , adm.getNama(), adm.getEmail(), adm.getNohp());
                    JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil");
                    adm.setListOutPegawai(model.outlistPegawai());
                }
                    
            } else if (source.equals(adm.LOpressed())){
                currentView="0";
                view.getCardLayout().show(mainPanel, currentView);
                l.refresh();
            } else if (source.equals(adm.cekPressed())){
                if (adm.getKonfirmasi()== "Barang"){
                    adm.setListOutBarang(model.getListOutKonfirmasiBarang());
                } else if(adm.getKonfirmasi()== "Tanah"){
                    adm.setListOutTanah(model.getListOutKonfirmasiTanah());
                }
            } else if(idSeleksi==""){
                JOptionPane.showMessageDialog(null, "Pilih data yang mau di konfirmasi", "Peringatan", JOptionPane.ERROR_MESSAGE);
            }else if (source.equals(adm.konformasiPressed())){
                if (adm.getKonfirmasi()== "Barang"){
                    model.knfrmBarang(model.getBarang(idSeleksi),"DiTerima");
                    adm.setListOutBarang(model.getListOutKonfirmasiBarang());
                    JOptionPane.showMessageDialog(null, "Barang Berhasil DiTerima");
                } else if (adm.getKonfirmasi()== "Tanah"){
                    model.knfrmTanah(model.getTanah(idSeleksi), "DiTerima");
                    adm.setListOutTanah(model.getListOutKonfirmasiTanah());
                    JOptionPane.showMessageDialog(null, "Tanah Berhasil DiTerima");
                }
            }else if (source.equals(adm.tolekPressed())){
                if (adm.getKonfirmasi()== "Barang"){
                    model.knfrmBarang(model.getBarang(idSeleksi),"DiTolak");
                    adm.setListOutBarang(model.getListOutKonfirmasiBarang());
                    JOptionPane.showMessageDialog(null, "Tanah Berhasil DiTolak");
                } else if (adm.getKonfirmasi()== "Tanah"){
                    model.knfrmTanah(model.getTanah(idSeleksi), "DiTolak");
                    adm.setListOutTanah(model.getListOutKonfirmasiTanah());
                    JOptionPane.showMessageDialog(null, "Tanah Berhasil DiTolak");
                }
            }
        } else if (currentView.equals("2")){
            if(source.equals(peg.logoutpressed())){
                currentView="0";
                view.getCardLayout().show(mainPanel, currentView);
                l.refresh();
            } else if (source.equals(peg.tBarangPressed())){
                if (peg.getNBarang().equals("") || peg.getStok()== 0){
                    JOptionPane.showMessageDialog(null, "Cek Kembali inputan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else{
                    d = new Date();
                    model.addBarang(peg.getNBarang(),peg.getStatus(),d,p.getIdUser(),peg.getStok(),"Tunggu Konfirmasi");
                    peg.setListOutBarang(model.getListOutBarang());
                    peg.refresh();
                    JOptionPane.showMessageDialog(null, "Barang berhasil ditambahkan");
                }
            } else if(source.equals(peg.tTanahPressed())){
                if(peg.getNPemilik().equals("") || peg.getLokasi().equals(" ")){
                    JOptionPane.showMessageDialog(null, "Cek Kembali inputan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else{
                    d = new Date();
                    model.addTanah(peg.getLokasi(),peg.getNPemilik(),peg.getUkuran(),p.getIdUser(),d,"Tunggu Konfirmasi");
                    peg.setListOutTanah(model.getListOutTanah());
                    peg.refresh();
                    JOptionPane.showMessageDialog(null, "Tanah berhasil ditambahkan");
                }
            }
        }
    }
    
    
}
