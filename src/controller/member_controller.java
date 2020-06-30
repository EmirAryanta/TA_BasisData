/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.table.DefaultTableModel;
import model.buku;
import model.member;
import model.pegawai;
import model.registrasi;
import database.Koneksi;

/**
 *
 * @author unknown
 */
public class member_controller {
    public member[] member = new member[100];
    Koneksi koneksi = new Koneksi();
    int index=1;
    
    public void insert(String nama, String gender, String alamat, String notelp){
        member mbr = new member();
        mbr.insert(index, nama, gender, alamat, notelp);
        koneksi.ManipulasiData("insert into pembeli_06999 values ("+index+",'"+nama+"','"+gender+ "','"+alamat+"',"+notelp+",null)");
        System.out.println(index);
        member[index] = mbr;
    }
    public void insert_regis(registrasi reg){
        String x ="update pembeli_06999 set no_registrasi = "+reg.getNo_reg()+" where id_pembeli = "+index;
        System.out.println(x);
        koneksi.ManipulasiData(x);
        member[index].setRegis(reg);
        index++;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
 
    public member cari_member(int cari){
        member temp = null;
        int temp1;
        for(int i=1;i<index;i++){
            temp1 =member[i].getIdMember();
            if(temp1==cari){
                temp=member[i];
            }
        }
        return temp;
    }
    public member cari_member_regis(int cari){
        member temp = null;
        int temp1;
        for(int i=1;i<=index;i++){
            temp1 =member[i].getIdMember();
            if(temp1==cari){
                temp=member[i];
            }
        }
        return temp;
    }
    
    public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" ID Member");
        model.addColumn(" Nama");
        model.addColumn(" Gender");
        model.addColumn(" Alamat");
        model.addColumn(" No Telp");
        model.addColumn(" No reg");
        model.addColumn(" Tgl reg");
        model.addColumn(" Pegawai");
        
        for(int i=1 ;i<index;i++){
            Object data[] = new Object[8];
            data[0] = member[i].getIdMember();
            data[1] = member[i].getNama();
            data[2] = member[i].getGender();
            data[3] = member[i].getAlamat();
            data[4] = member[i].getNoTelp();
            data[5] = member[i].getRegis().getNo_reg();
            data[6] = member[i].getRegis().getTgl();
            data[7] = member[i].getRegis().getPegawai().getNama();
            model.addRow(data);
        }
        return model;
    }
    
    
}
