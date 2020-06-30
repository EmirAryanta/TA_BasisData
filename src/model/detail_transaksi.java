/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AllObject;

/**
 *
 * @author unknown
 */
public class detail_transaksi {
    //private transaksi transaksi;
    private buku buku;
    private int qnt;
    private String tgl;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void insert(int bk, int qnt,String tgl){
        this.buku = AllObject.buku.search(bk);
        this.qnt = qnt;
        this.tgl = tgl;
    }
    /*    public transaksi getTransaksi() {
    return transaksi;
    }
    
    public void setTransaksi(transaksi transaksi) {
    this.transaksi = transaksi;
    }*/

    public buku getBuku() {
        return buku;
    }

    public void setBuku(buku buku) {
        this.buku = buku;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
}
