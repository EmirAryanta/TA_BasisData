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
public class member extends manusia{
    private int idMember = 0;
    private int index_id = 0;
    private registrasi regis;
    
    public member(){
        
    }

    public void insert(int id, String nama, String gender, String alamat, String notelp){
        this.idMember = id;
        this.nama = nama;
        this.gender = gender;
        this.alamat = alamat;
        this.noTelp = notelp;
    }

    public registrasi getRegis() {
        return regis;
    }

    public void setRegis(registrasi regis) {
        this.regis = regis;
    }
    
    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIndex_id() {
        return index_id;
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
    
}
