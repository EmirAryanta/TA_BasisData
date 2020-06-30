/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author unknown
 */
public class registrasi {
    private int no_reg;
    private String tgl;
    private pegawai pegawai;
    private member member;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();

       public void insert(int reg, pegawai Pgw, member Member){
    this.no_reg = reg;
    this.pegawai = Pgw;
    this.member = Member;
    this.tgl = df.format(date);
    }
    
    public int getNo_reg() {
        return no_reg;
    }

    public void setNo_reg(int no_reg) {
        this.no_reg = no_reg;
    }

    public String getTgl() {
        //tgl = df.format(date);
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public member getMember() {
        return member;
    }

    public void setMember(member member) {
        this.member = member;
    }

    
}
