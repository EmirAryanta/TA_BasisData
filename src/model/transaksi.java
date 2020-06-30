/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author unknown
 */
public class transaksi {
    private int no_transaksi = 0;
    private detail_transaksi[] detail;
    /*    private String tanggal;
    private String buku;*/
    private member member;
    private pegawai pegawai;
    private double total;
    private double bayar;
    private double kembali;
    private int index;
    private int jumlah;
    
    public void insert(int no, member mbr, pegawai pgw, double total, double bayar, double kembali, detail_transaksi[] detail,int jumlah){
        this.no_transaksi=no;
        this.bayar=bayar;
        this.pegawai=pgw;
        this.member=mbr;
        this.total=total;
        this.kembali=kembali;
        this.detail=detail;
        this.jumlah=jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    

    public detail_transaksi[] getDetail() {
        return detail;
    }

    public void setDetail(detail_transaksi[] detail) {
        this.detail = detail;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    
    public int getNo_transaksi() {
        return no_transaksi;
    }

    public void setNo_transaksi(int no_transaksi) {
        this.no_transaksi = no_transaksi;
    }

    public member getMember() {
        return member;
    }

    public void setMember(member member) {
        this.member = member;
    }

    public pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBayar() {
        return bayar;
    }


    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    public double getKembali() {
        return kembali;
    }

    public void setKembali(double kembali) {
        this.kembali = kembali;
    }
    
}
