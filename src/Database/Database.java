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
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
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
    private String FILE = "c:/hasil/LaporanBarang.pdf";
    private String FILE2 = "c:/hasil/LaporanTanah.pdf";
        private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                        Font.BOLD);
        private Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.NORMAL, BaseColor.RED);
        private Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
                        Font.BOLD);
        private Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                        Font.BOLD);


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
    public void updateBarang(String id, int stok,String status){
        String s = "update barang set stok = "+stok+", status = '"+status+"' where idBarang = '"+id+"'";
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
    public void updateTanah(String id,String nama){
        String s = "update tanah set namaPemilik = '"+nama+"' where idTanah = '"+id+"'";
        try {
            query(s);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void cetakBarang(String[][] list){
        try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE));
                        document.open();
                        addContentBarang(document,list);
                        document.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
    }
    public void addContentBarang(Document document,String[][] list) throws DocumentException {

                // Second parameter is the number of the chapter

                Paragraph subPara = new Paragraph("Laporan Invertaris Barang", catFont);

                createTableBarang(subPara,list);

                document.add(subPara);


                // now add all this to the document
                //document.add(test);

        }
     
    public void createTableBarang(Paragraph subCatPart, String[][] list)
                        throws BadElementException {
                PdfPTable table = new PdfPTable(7);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("ID"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Nama"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Stok"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Status"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Tanggal"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Nama Pegawai"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Status Konfirmasi"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                table.setHeaderRows(1);
                 for (int i = 0; i < list.length; i++){
                    table.addCell(list[i][0]);
                    table.addCell(list[i][1]);
                    table.addCell(list[i][2]);
                    table.addCell(list[i][3]);
                    table.addCell(list[i][4]);
                    table.addCell(list[i][5]);
                    table.addCell(list[i][6]);
        }
                subCatPart.add(table);

        }
    
    public void cetakTanah(String[][] list){
        try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(FILE2));
                        document.open();
                        addContentTanah(document,list);
                        document.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
    }
    public void addContentTanah(Document document,String[][] list) throws DocumentException {

                // Second parameter is the number of the chapter

                Paragraph subPara = new Paragraph("Laporan Invertaris Tanah", catFont);

                createTableTanah(subPara,list);

                document.add(subPara);


                // now add all this to the document
                //document.add(test);

        }
     
    public void createTableTanah(Paragraph subCatPart, String[][] list)
                        throws BadElementException {
                PdfPTable table = new PdfPTable(7);

                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("ID"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Nama Pemilik"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Lokasi"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Ukuran"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Tanggal"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Nama Pegawai"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Status Konfirmasi"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                table.setHeaderRows(1);
                 for (int i = 0; i < list.length; i++){
                    table.addCell(list[i][0]);
                    table.addCell(list[i][1]);
                    table.addCell(list[i][2]);
                    table.addCell(list[i][3]);
                    table.addCell(list[i][4]);
                    table.addCell(list[i][5]);
                    table.addCell(list[i][6]);
        }
                subCatPart.add(table);

        }
    
}
