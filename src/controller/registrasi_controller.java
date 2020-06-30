/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.member;
import model.pegawai;
import javax.swing.table.DefaultTableModel;
import model.registrasi;
import database.Koneksi;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author unknown
 */
public class registrasi_controller {
    public registrasi[] reg = new registrasi[100];
    int index=1;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    Koneksi koneksi = new Koneksi();

    
    public void insert(pegawai idPgw, member idMmbr){
        registrasi rgs = new registrasi();
        rgs.insert(index, idPgw, idMmbr);
        String tgl = df.format(date);
        String x="insert into registrasi_06999 values ("+index+",sysdate,"+idMmbr.getIdMember()+","+idPgw.getIdPegawai()+")";
        koneksi.ManipulasiData(x);
        this.reg[index] = rgs;
        System.out.println(x);
        index++;
    }
    
    public registrasi cari_regis(int cari){
        registrasi temp = null;
        for(int i=1;i<index;i++){
            if(reg[i].getNo_reg()==cari){
                temp=reg[i];
            }
        }
        return temp;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" No reg");
        model.addColumn(" Tgl");
        model.addColumn(" ID Pegawai");
        model.addColumn(" ID Member");
        
        for(int i=1 ;i<index;i++){
            Object data[] = new Object[4];
            data[0] = reg[i].getNo_reg();
            data[1] = reg[i].getTgl();
            data[2] = reg[i].getPegawai().getIdPegawai();
            data[3] = reg[i].getMember().getIdMember();
            model.addRow(data);
        }
        return model;
    }
    
    
}
