/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
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
    private Database db= new Database();
    
    private String currentView;
    private String idSeleksi = "";
    private String tmp = "";
    private String namaPeg = "";
    private String status = "";
    private int stk;
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
                stk = model.getTmpBarang(adm.getSelectedKonfirmasi()).getStok();
                status = model.getTmpBarang(adm.getSelectedKonfirmasi()).getStatus();
                namaPeg = model.getTmpBarang(adm.getSelectedKonfirmasi()).getNamaBarang();
                model.setTmp(model.getTmpBarang(adm.getSelectedKonfirmasi()).getKonfirmasi());
                //System.out.println(idSeleksi);
            }else if (adm.getKonfirmasi()=="Tanah"){
                idSeleksi = model.getTmpTanah(adm.getSelectedKonfirmasi()).getIdTanah();
                namaPeg = model.getTmpTanah(adm.getSelectedKonfirmasi()).getNamaPemilik();
                model.setTmp(model.getTmpTanah(adm.getSelectedKonfirmasi()).getKonfirmasi());
                //System.out.println(namaPeg);
                //System.out.println(idSeleksi);
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
                    peg.setEmptyTabelSearchTanah();
                    peg.setListOutMutasiTanah(model.getListOutMutasiTanah());
                    peg.setEmptyTabelSearchBarang();
                    peg.setListOutMutasiBarang(model.getListOutMutasiBarang());
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
            }else if (source.equals(adm.konformasiPressed())){
                if(idSeleksi==""){
                    JOptionPane.showMessageDialog(null, "Pilih data yang mau di konfirmasi", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (adm.getKonfirmasi()== "Barang" && model.getTmp().equals("Input Baru")){
                    model.knfrmBarang(model.getBarang(idSeleksi),"DiTerima");
                    adm.setListOutBarang(model.getListOutKonfirmasiBarang());
                    JOptionPane.showMessageDialog(null, "Barang Berhasil DiTerima");
                }else if (adm.getKonfirmasi().equals("Barang") && model.getTmp().equals("Mutasi")){
                    int choice = JOptionPane.showOptionDialog(null, 
                    "Pegawai ingin mengubah Stok dari "+stk+" menjadi "+model.getMutasi2(namaPeg).getStok()+" Dan Mengubah Status dari "+
                     status+"menjadi "+model.getMutasi2(namaPeg).getStatus(), 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, null, null);
                    if (choice == JOptionPane.YES_OPTION){
                        model.knfrmBarang(model.getBarang(idSeleksi), "DiTerima1");
                        model.getBarang(idSeleksi).setStok(model.getMutasi2(namaPeg).getStok());
                        model.getBarang(idSeleksi).setStatus(model.getMutasi2(namaPeg).getStatus());
                        db.updateBarang(idSeleksi, model.getMutasi2(namaPeg).getStok(), model.getMutasi2(namaPeg).getStatus());
                        adm.setListOutBarang(model.getListOutKonfirmasiBarang());
                        JOptionPane.showMessageDialog(null, "Mutasi data Barang Berhasil DiTerima");
                    }
                } else if (adm.getKonfirmasi().equals("Tanah") && model.getTmp().equals("Input Baru")){
                    model.knfrmTanah(model.getTanah(idSeleksi), "DiTerima");
                    adm.setListOutTanah(model.getListOutKonfirmasiTanah());
                    JOptionPane.showMessageDialog(null, "Tanah Berhasil DiTerima");
                } else if (adm.getKonfirmasi().equals("Tanah") && model.getTmp().equals("Mutasi")){
                    int choice = JOptionPane.showOptionDialog(null, 
                    "Pegawai ingin mengubah Nama Pemilik dari "+namaPeg+" menjadi "+model.getMutasi(namaPeg), 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, null, null);
                    if (choice == JOptionPane.YES_OPTION){
                        model.knfrmTanah(model.getTanah(idSeleksi), "DiTerima1");
                        model.getTanah(idSeleksi).setNamaPemilik(model.getMutasi(namaPeg));
                        db.updateTanah(idSeleksi, model.getMutasi(namaPeg));
                        adm.setListOutTanah(model.getListOutKonfirmasiTanah());
                        JOptionPane.showMessageDialog(null, "Mutasi data Tanah Berhasil DiTerima");
                    }
                } 
            }else if (source.equals(adm.tolekPressed())){
                if (adm.getKonfirmasi()== "Barang" && model.getTmp().equals("Input Baru")){
                    model.knfrmBarang(model.getBarang(idSeleksi),"DiTolak");
                    adm.setListOutBarang(model.getListOutKonfirmasiBarang());
                    JOptionPane.showMessageDialog(null, "Tanah Berhasil DiTolak");
                }else if (adm.getKonfirmasi()== "Barang" && model.getTmp().equals("Mutasi")){
                    model.knfrmBarang(model.getBarang(idSeleksi),"DiTolak");
                    adm.setListOutBarang(model.getListOutKonfirmasiBarang());
                    JOptionPane.showMessageDialog(null, "Tanah Berhasil DiTolak");
                } else if (adm.getKonfirmasi()== "Tanah" && model.getTmp().equals("input Baru")){
                    model.knfrmTanah(model.getTanah(idSeleksi), "DiTolak");
                    adm.setListOutTanah(model.getListOutKonfirmasiTanah());
                    JOptionPane.showMessageDialog(null, "Tanah Berhasil DiTolak");
                } else if (adm.getKonfirmasi()== "Tanah" && model.getTmp().equals("Mutasi")){
                    model.knfrmTanah(model.getTanah(idSeleksi), "DiTolak1");
                    adm.setListOutTanah(model.getListOutKonfirmasiTanah());
                    JOptionPane.showMessageDialog(null, "Mutasi Tanah Berhasil DiTolak");
                }
            }else if(source.equals(adm.tLihatPressed())){
                String tgl = adm.getBulan() + "/" + adm.getTahun();
                if(adm.jLaporan().equals("Barang")){
                    adm.setListOutLaporanBarang(model.getListOutLaporanBarang(tgl),model.getListOutLaporanBarang(tgl).length);
                } else if (adm.jLaporan().equals("Tanah")){
                    adm.setListOutLaporanTanah(model.getListOutLaporanTanah(tgl));
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
                    model.setTmp("Tunggu Konfirmasi");
                    peg.setListOutTanah(model.getListOutTanah());
                    peg.refresh();
                    JOptionPane.showMessageDialog(null, "Tanah berhasil ditambahkan");
                }
            } else if(source.equals(peg.cTanahPressed())){
                if(peg.sNamaPemilik().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else if(model.getTanah2(peg.sNamaPemilik())==null){
                    JOptionPane.showMessageDialog(null, "Data Tanah Tidak diTemukan atau Data Belum Di Konfirmasi Admin", "Peringatan", JOptionPane.ERROR_MESSAGE);                    
                    peg.refresh();
                    peg.setEmptyTabelSearchTanah();
                } else{
                    T = model.getTanah2(peg.sNamaPemilik());
                    peg.setListOutSearchTanah(model.getListOutSearchTanah(T));
                }
            } else if(source.equals(peg.mTanahPressed())){
                if(peg.mNamaPemilik().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan Data Baru Tidak Boleh Kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.knfrmTanah(T, "Tunggu Konfirmasi1");
                    model.addMutasi(T.getNamaPemilik(), peg.mNamaPemilik());
                    model.setTmp("Tunggu Konfirmasi1");
                    JOptionPane.showMessageDialog(null, "Mutasi Diajukan");
                    peg.setListOutMutasiTanah(model.getListOutMutasiTanah());
                    peg.setEmptyTabelSearchTanah();
                    peg.refresh();
                }
            } else if(source.equals(peg.cBarangPressed())){
                if(peg.sNamaBarang().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else if (model.getBarang2(peg.sNamaBarang())==null){
                    JOptionPane.showMessageDialog(null, "Data Barang Tidak diTemukan atau Data Belum Di Konfirmasi Admin", "Peringatan", JOptionPane.ERROR_MESSAGE); 
                    peg.setEmptyTabelSearchBarang();
                    peg.refresh();
                } else {
                    b = model.getBarang2(peg.sNamaBarang());
                    peg.setListOutSearchBarang(model.getListOutSearchBarang(b));
                }
            } else if(source.equals(peg.mBarangPressed())){
                if(peg.getMutasiStok()==0){
                    JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else{
                    model.knfrmBarang(b, "Tunggu Konfirmasi1");
                    model.addMutasi2(b.getNamaBarang(), peg.getMutasiStok(), peg.getMutasiStatus());
                    model.setTmp("Tunggu Konfirmasi1");
                    JOptionPane.showMessageDialog(null, "Mutasi Diajukan");
                    peg.setListOutMutasiBarang(model.getListOutMutasiBarang());
                    peg.setEmptyTabelSearchBarang();
                    peg.refresh();
                }
            }
        }
    }
    
    
}
