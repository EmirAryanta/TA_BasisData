/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.buku;

/**
 *
 * @author unknown
 */
public class buku_controller {
     public buku[] BK = new buku[100];
     Koneksi koneksi = new Koneksi();
    //int indexRt =0;
    int index = 1;
    int angka =1;
    int id;
    String jdl;
    String penerbit;
    int thn;
    int harga;

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    
       
    public void insert(String nama, int thn, String penerbit, int harga){
        buku bk = new buku();
        System.out.println(harga);
        bk.insertBuku(index, nama, thn, penerbit, harga);
        String x="INSERT INTO BUKU_06999 VALUES ("+index+",'"+nama+"','"+penerbit+"',"+thn+","+harga+")";
        System.out.println(x);
        this.koneksi.ManipulasiData(x);
        BK[index] = bk;
        index++;
        //BK[1].setIndexId(index);
    }

    public buku search(int cari){
        buku temp = null;
        for(int x=1;x<index;x++){
            if(BK[x].getIdBuku()==cari){
                temp = BK[x];
        }}  
        return temp;
    }
    
    public void delete(int cari){
        buku temp=null;
        boolean ketemu=false;
        for(int i=1; i<index;i++){
            ketemu=true;
            }
        if(ketemu==true){
            String x="DELETE FROM BUKU_06999 WHERE ID_BUKU = "+cari;
            koneksi.ManipulasiData(x);
            index--;
            ketemu = false;
            try {
                getDataBuku();
            } catch (SQLException ex) {
                Logger.getLogger(buku_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(int cari,String nama,int tahun,String penerbit,int harga){
        boolean ketemu=false;
        for(int x=1;x<index;x++){
            if(BK[x].getIdBuku()==cari){
                BK[cari].setJdl_buku(nama);
                BK[cari].setThn_terbit(tahun);
                BK[cari].setPenerbit(penerbit);
                BK[cari].setHarga(harga);
                ketemu = true;
    }}  
        if (ketemu==true) {
            koneksi.ManipulasiData("update buku_06999 set judul_buku = '"+nama+"', penerbit = '"+penerbit+"', tahun_terbit = "+tahun+", harga = "+harga+" where id_buku = "+cari);
            ketemu = false;
        }
    
    }

    public  DefaultTableModel cetaktabel() throws SQLException{
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" ID Buku");
        model.addColumn(" Judul Buku");
        model.addColumn(" Tahun Terbit");
        model.addColumn(" Penerbit");
        model.addColumn(" Harga");

        ResultSet rs = koneksi.GetData("select * from buku_06999" );
        while (rs.next()) {
            Object data[] = new Object[5];
            data[0] = rs.getInt("ID_BUKU");
            data[1] = rs.getString("JUDUL_BUKU");
            data[2] = rs.getString("PENERBIT");
            data[3] = rs.getInt("TAHUN_TERBIT");
            data[4] = rs.getInt("HARGA");
            model.addRow(data);
            }
        /*for(int i=1;i<index;i++){
        Object data[] = new Object[5];
        data[0]=BK[i].getIdBuku();
        data[1]=BK[i].getJudul();
        data[2]=BK[i].getThnTbt();
        data[3]=BK[i].getPenerbit();
        data[4]=BK[i].getHarga();
        model.addRow(data);
        }*/
        return model;
    }
    
        public void getDataBuku() throws SQLException{
        index=1;
        ResultSet rs = koneksi.GetData("select * from buku_06999" );
        while (rs.next()) {
            buku b = new buku();
            b.setId_buku(rs.getInt("ID_BUKU"));
            b.setJdl_buku(rs.getString("JUDUL_BUKU"));
            b.setPenerbit(rs.getString("PENERBIT"));
            b.setThn_terbit(rs.getInt("TAHUN_TERBIT"));
            b.setHarga(rs.getInt("HARGA"));
            BK[index]=b;;
            index++;
            }
    }
    
}
