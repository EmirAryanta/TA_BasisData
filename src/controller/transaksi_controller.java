/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.*;
import javax.swing.JOptionPane;
import database.Koneksi;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author unknown
 */
public class transaksi_controller {
    public transaksi[] trs = new transaksi[1000];
    Koneksi koneksi = new Koneksi();
    int index = 1;
    SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
    Date tgl;
 
    
    public void insert(int no, member mbr, pegawai pgw, double total, double bayar, double kembali, detail_transaksi[] detail,int jumlah){
        transaksi trs = new transaksi();
        trs.insert(no, mbr, pgw, total, bayar, kembali, detail, jumlah);
        this.trs[index]=trs;
        koneksi.ManipulasiData("insert into transaksi_06999 values ("+index+","+mbr.getIdMember()+","+pgw.getIdPegawai()+","+total+","+bayar+","+kembali+")");
        for(int i=1; i<jumlah; i++){
            koneksi.ManipulasiData("insert into detail_transaksi_06999 values ("+index+","+detail[i].getBuku().getIdBuku()+","+detail[i].getQnt()+", sysdate)");
        }
        index++;
    }   
    
    public String cetak_detail(int index){
        detail_transaksi[] det = trs[index].getDetail();
        String text = "================== Nota Pembelian ===================\n";
        text += "No. Transaksi    : " + trs[index].getNo_transaksi() + "\n";
        text += "Tanggal          : " + det[1].getTgl() + "\n";
        text += "Pembeli          : " + trs[index].getMember().getNama() + "\n";
        text += "Pegawai          : " + trs[index].getPegawai().getNama() + "\n";
        text += "============= Detail ==============\n";
        for(int i=1;i<=trs[index].getJumlah();i++){
            text += "Judul Buku  : "+ det[i].getBuku().getJudul() +"\n";
            text += "Harga       : "+ det[i].getBuku().getHarga()+"\n";
            text += "Jumlah      : "+ det[i].getQnt()+"\n";
            text += "--------------------------------"+"\n";
        }
        text += "Total Harga     : "+trs[index].getTotal()+"\n";
        text += "Bayar           : "+trs[index].getBayar()+"\n";
        text += "Kembali         : "+trs[index].getKembali();
        return text;
    }
    public transaksi cari(int cari){
        transaksi temp = null;
        for(int x=1;x<index;x++){
            if(trs[x].getNo_transaksi()==cari){
                temp = trs[x];
            }
        }
        return temp;
    }
    public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" No Transaksi");
        model.addColumn(" ID Member");
        model.addColumn(" ID Pegawai");
        model.addColumn(" Total");
        model.addColumn(" Bayar");
        model.addColumn(" Kembali");
        
        for(int i=1 ;i<index;i++){
            Object data[] = new Object[6];
            System.out.println(trs[i].getBayar());
            data[0] = trs[i].getNo_transaksi();
            data[1] = trs[i].getMember().getIdMember();
            data[2] = trs[i].getPegawai().getIdPegawai();
            data[3] = trs[i].getTotal();
            data[4] = trs[i].getBayar();
            data[5] = trs[i].getKembali();
            model.addRow(data);
        }
        return model;
    }

    public transaksi[] getTrs() {
        return trs;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    

    
}
