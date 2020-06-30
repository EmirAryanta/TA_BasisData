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
public class pegawai extends manusia{
    private int idPegawai = 0;
    private int indexId = 0;
    private String username;
    private String password;
    private String jabatan;
    
    public pegawai(){
        
    }
    
    public void insertPegawai(int id, String nama, String noTelp, String alamat, String gndr, String jabatan, String username, String password){
    this.idPegawai = id;
    this.nama = nama;
    this.gender = gndr;
    this.alamat = alamat;
    this.noTelp = noTelp;
    this.jabatan = jabatan;
    this.username = username;
    this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getGender() {
        return gender;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public int getIndexId() {
        return indexId;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    
    
}
