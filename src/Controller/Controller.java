/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
    private String namaSeleksi = "";
    private String lokasiSeleksi = "";
    private String tujuanSeleksi = "";
    private JPanel mainPanel;
    private boolean posisi;
    
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
        peg.addListener(this);
        
        mainPanel=view.getMainPanel();
        mainPanel.add(l,"0");
        mainPanel.add(adm,"1");
        mainPanel.add(peg,"2");
        currentView = "0";
        
        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
        view.addListener(this);
    }
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnExit())){
            System.exit(0);
        }
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
            }
        } else if (currentView.equals("2")){
            
        }
    }
    
    
}
