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
public class buku {
    
    private int id_buku = 0;
    private int index_id = 0;
    private String jdl_buku;
    private int thn_terbit;
    private String penerbit;
    private int harga;
    
    public buku(){
        
    }
    
    public void insertBuku(int id, String jdl, int thn, String pnrbt, int harga){
        this.id_buku = id;
        this.jdl_buku = jdl;
        this.thn_terbit = thn;
        this.penerbit = pnrbt;
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public int getIdBuku(){
        return id_buku;
    }
    
    public String getJudul(){
        return jdl_buku;
    }
    
    public int getThnTbt(){
        return thn_terbit;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setId_buku(int id_buku) {
        this.id_buku = id_buku;
    }

    public void setJdl_buku(String jdl_buku) {
        this.jdl_buku = jdl_buku;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setThn_terbit(int thn_terbit) {
        this.thn_terbit = thn_terbit;
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }

    public int getIndex_id() {
        return index_id;
    }
    
    
    
}
