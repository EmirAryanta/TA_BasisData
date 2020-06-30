/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.table.DefaultTableModel;
import model.*;
import database.Koneksi;
/**
 *
 * @author unknown
 */
public class detail_transaksi_controller {
    public detail_transaksi dtrs[] = new detail_transaksi[1000];
    public int index=1;
    Koneksi koneksi = new Koneksi();
    
    public void insert(int bk, int qnt,String tgl){
        detail_transaksi det = new detail_transaksi();
        det.insert(bk, qnt, tgl);
        dtrs[index]=det;
        index++;
    }

    public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" No Transaksi");
        model.addColumn(" ID Buku");
        model.addColumn(" Quantity");
        model.addColumn(" Tanggal");
        
        for(int i=1 ;i<index;i++){
            Object data[] = new Object[3];
            //data[0] = dtrs[i].getTransaksi().getNo_transaksi();
            data[0] = dtrs[i].getBuku().getIdBuku();
            data[1] = dtrs[i].getQnt();
            data[2] = dtrs[i].getTgl();
            model.addRow(data);
        }
        return model;
    }

    public detail_transaksi[] getDtrs() {
        index=1;
        return dtrs;
    }

    public void setDtrs(detail_transaksi[] dtrs) {
        this.dtrs = dtrs;
    }
    
}
