/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author The Keong's
 */
public class vAdmin extends javax.swing.JPanel {

    /**
     * Creates new form vAdmin
     */
    public vAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bNama = new javax.swing.JTextField();
        bUsername = new javax.swing.JTextField();
        bEmail = new javax.swing.JTextField();
        bNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPegawai = new javax.swing.JTable();
        tmbah = new javax.swing.JButton();
        bPass = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pKonfirmasi = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tKonfirmasi = new javax.swing.JTable();
        bKonfirmasi = new javax.swing.JButton();
        bTolak = new javax.swing.JButton();
        bCek = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        sView = new javax.swing.JComboBox();
        bTampil = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tView = new javax.swing.JTable();
        Bulan = new javax.swing.JPanel();
        cbBulan = new javax.swing.JComboBox();
        tLihat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tLaporan = new javax.swing.JTable();
        cbTahun = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        bCetak = new javax.swing.JButton();
        cbLaporan = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        jLabel13.setText("jLabel13");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Selamat Datang ADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel3)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Main", jPanel1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tambah Pegawai");

        bNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama");

        jLabel7.setText("Username");

        jLabel8.setText("Password");

        jLabel9.setText("Email");

        jLabel10.setText("No. HP");

        tPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tPegawai);

        tmbah.setText("Tambah");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addComponent(bNo)
                    .addComponent(bEmail)
                    .addComponent(bPass, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(bUsername)
                    .addComponent(bNama))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tmbah)
                        .addGap(65, 65, 65))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(bNama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(bUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(bPass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNo)))
                .addGap(18, 18, 18)
                .addComponent(tmbah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pegawai", jPanel2);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Konfirmasi");

        pKonfirmasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Barang", "Tanah", "Mutasi" }));
        pKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pKonfirmasiActionPerformed(evt);
            }
        });

        tKonfirmasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tKonfirmasi);

        bKonfirmasi.setText("Konfirmasi");

        bTolak.setText("Tolak");

        bCek.setText("CeK");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pKonfirmasi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCek))
                        .addGap(383, 383, 383))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(bKonfirmasi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bTolak)
                        .addGap(63, 63, 63))))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(28, 28, 28)
                .addComponent(pKonfirmasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(bCek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bKonfirmasi)
                    .addComponent(bTolak))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Konfirmasi", jPanel3);

        sView.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tanah", "Barang" }));

        bTampil.setText("Tampilkan");

        tView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tView);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(sView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bTampil))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTampil))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lihat Data", jPanel4);

        cbBulan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Des" }));

        tLihat.setText("Lihat");

        tLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tLaporan);

        cbTahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016" }));

        jLabel14.setText("Bulan");

        bCetak.setText("Cetak");

        cbLaporan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Barang", "Tanah", "Mutasi" }));
        cbLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLaporanActionPerformed(evt);
            }
        });

        jLabel15.setText("Jenis Laporan");

        javax.swing.GroupLayout BulanLayout = new javax.swing.GroupLayout(Bulan);
        Bulan.setLayout(BulanLayout);
        BulanLayout.setHorizontalGroup(
            BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BulanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BulanLayout.createSequentialGroup()
                        .addComponent(tLihat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCetak)
                        .addGap(57, 57, 57))
                    .addGroup(BulanLayout.createSequentialGroup()
                        .addGroup(BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BulanLayout.createSequentialGroup()
                                .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(BulanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );
        BulanLayout.setVerticalGroup(
            BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BulanLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(BulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLihat)
                    .addComponent(bCetak))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Laporan", Bulan);

        LogOut.setText("Log out");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bNoActionPerformed

    private void pKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pKonfirmasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pKonfirmasiActionPerformed

    private void cbLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLaporanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bulan;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton bCek;
    private javax.swing.JButton bCetak;
    private javax.swing.JTextField bEmail;
    private javax.swing.JButton bKonfirmasi;
    private javax.swing.JTextField bNama;
    private javax.swing.JTextField bNo;
    private javax.swing.JPasswordField bPass;
    private javax.swing.JButton bTampil;
    private javax.swing.JButton bTolak;
    private javax.swing.JTextField bUsername;
    private javax.swing.JComboBox cbBulan;
    private javax.swing.JComboBox cbLaporan;
    private javax.swing.JComboBox cbTahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox pKonfirmasi;
    private javax.swing.JComboBox sView;
    private javax.swing.JTable tKonfirmasi;
    private javax.swing.JTable tLaporan;
    private javax.swing.JButton tLihat;
    private javax.swing.JTable tPegawai;
    private javax.swing.JTable tView;
    private javax.swing.JButton tmbah;
    // End of variables declaration//GEN-END:variables

    /*-----------------------------Pegawai--------------------------------------*/
    public String getNama(){
        return bNama.getText();
    }
    
    public String getUsername(){
        return bUsername.getText();
    }
    
    public String getPass(){
        return bPass.getText();
    }
    
    public String getEmail(){
        return bEmail.getText();
    }
    
    public String getNohp(){
        return bNo.getText();
    }
    
    public Object tambahPressed(){
        return tmbah;
    }
    

    public void setListOutPegawai(String[][] list){
        String[] judul = {"ID","Username","Password","Nama","Email","No HP"};
        String[][] isi = new String[list.length][6];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
            isi[i][5] = list[i][5];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tPegawai.setModel(tableModel);
        tPegawai.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
    
    /*-----------------------------Konfirmasi----------------------*/
    
    public String getKonfirmasi(){
        return (String) pKonfirmasi.getSelectedItem();
    }
    public Object cekPressed(){
        return bCek;
    }
    public Object konformasiPressed(){
        return bKonfirmasi; 
    }
    public Object tolekPressed(){
        return bTolak;
    }
    public Object tabelKonfirmasiSelected(){
        return tKonfirmasi;
    }
    public int getSelectedKonfirmasi(){
        return tKonfirmasi.getSelectedRow();
    }
    public void setListOutBarang(String[][] list){
        String[] judul = {"ID","Nama","Stok","Status","Tanggal","Nama Pegawai","Jenis Konfirmasi"};
        String[][] isi = new String[list.length][7];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
            isi[i][5] = list[i][5];
            isi[i][6] = list[i][6];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tKonfirmasi.setModel(tableModel);
        tKonfirmasi.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
    public void setListOutTanah(String[][] list){
        String[] judul = {"ID","Nama Pemilik","Lokasi","Ukuran","Tanggal","Nama Pegawai","Jenis Konfirmasi"};
        String[][] isi = new String[list.length][7];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
            isi[i][5] = list[i][5];
            isi[i][6] = list[i][6];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tKonfirmasi.setModel(tableModel);
        tKonfirmasi.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
    
    /*--------------------------Laporan-------------------------*/
    public Object tLihatPressed(){
        return tLihat;
    }
    public String getTahun(){
        return (String) cbTahun.getSelectedItem();
    }
    public Object bCetakPressed(){
        return bCetak;
    }
    
    public String jLaporan(){
        return (String) cbLaporan.getSelectedItem();
    }
    public String getBulan(){
        if (cbBulan.getSelectedItem().equals("Jan")) return "01";
        else if (cbBulan.getSelectedItem().equals("Feb")) return "02";
        else if (cbBulan.getSelectedItem().equals("Mar")) return "03";
        else if (cbBulan.getSelectedItem().equals("Apr")) return "04";
        else if (cbBulan.getSelectedItem().equals("May")) return "05";
        else if (cbBulan.getSelectedItem().equals("Jun")) return "06";
        else if (cbBulan.getSelectedItem().equals("Jul")) return "07";
        else if (cbBulan.getSelectedItem().equals("Aug")) return "08";
        else if (cbBulan.getSelectedItem().equals("Sep")) return "09";
        else if (cbBulan.getSelectedItem().equals("Oct")) return "10";
        else if (cbBulan.getSelectedItem().equals("Nov")) return "11";
        else return "12";
    }
    public void setListOutLaporanBarang(String[][] list, int j){
        String[] judul = {"ID","Nama","Stok","Status","Tanggal","Nama Pegawai","Status Konfirmasi"};
        String[][] isi = new String[j][7];
        for (int i = 0; i < j; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
            isi[i][5] = list[i][5];
            isi[i][6] = list[i][6];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tLaporan.setModel(tableModel);
    }
    public void setListOutLaporanTanah(String[][] list){
        String[] judul = {"ID","Nama Pemilik","Lokasi","Ukuran","Tanggal","Nama Pegawai","Status Konfirmasi"};
        String[][] isi = new String[list.length][7];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
            isi[i][5] = list[i][5];
            isi[i][6] = list[i][6];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tLaporan.setModel(tableModel);
    }
    /*-------------------------lihat data------------------------*/
    public String getView(){
        return (String) sView.getSelectedItem();
    }
    public Object TampilPressed(){
        return bTampil;
    }
    public void setListOutLihatBarang(String[][] list){
        String[] judul = {"ID","Nama","Stok","Status","Tanggal",};
        String[][] isi = new String[list.length][5];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tView.setModel(tableModel);
        tView.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
    public void setListOutLihatTanah(String[][] list){
        String[] judul = {"ID","Nama Pemilik","Lokasi","Ukuran","Tanggal"};
        String[][] isi = new String[list.length][5];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tView.setModel(tableModel);
        tView.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
    /*-----------------------------Tool--------------------------*/
    public Object LOpressed(){
        return LogOut;
    }
     public void refresh() {
        bNama.setText("");
        bPass.setText("");
        bEmail.setText("");
        bNo.setText("");
        bUsername.setText("");
        pKonfirmasi.setSelectedIndex(0);
    }
    public void addListener(ActionListener e) {
        tmbah.addActionListener(e);
        bCek.addActionListener(e);
        bKonfirmasi.addActionListener(e);
        bTolak.addActionListener(e);
        LogOut.addActionListener(e);
        tLihat.addActionListener(e);
        bCetak.addActionListener(e);
        bTampil.addActionListener(e);
    }
    public void addAdapter(MouseAdapter e) {
        tKonfirmasi.addMouseListener(e);
    }
}
