/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.pegawai;

/**
 *
 * @author unknown
 */
public class pegawai_controller {
    public pegawai[] PGW = new pegawai[100];
    Koneksi koneksi = new Koneksi();
    int indexP = 1;
    int IDLogin =1;
    

    public int getIndexP() {
        return indexP;
    }

    public void setIndexP(int indexP) {
        this.indexP = indexP;
    }
      
  
       
    public void insert(String nama, String telp, String alamat, String gndr, String jabatan, String username, String password){
        pegawai pgw = new pegawai();
        pgw.insertPegawai(indexP, nama, telp, alamat, gndr, jabatan, username, password);
        PGW[indexP] = pgw;
        koneksi.ManipulasiData("insert into pegawai_06999 values ("+indexP+", '"+nama+"', '"+gndr+"', '"+alamat+"', "+telp+", '"+username+"', '"+password+"', '"+jabatan+"')");
        //System.out.println(PGW[indexP].getNama());
        indexP++;
        //PGW[1].setIndexId(indexP);
    }

    public String login(String user, String pass){
    String hasil = null;
        for(int i=1;i<indexP;i++){
            if(PGW[i].getUsername().equalsIgnoreCase(user) && PGW[i].getPassword().equalsIgnoreCase(pass)){
            hasil = PGW[i].getJabatan();
            IDLogin = PGW[i].getIdPegawai();
            }
        }
    return hasil;
    }
    
    public pegawai search(int cari){
        pegawai temp = null;
        int temp1=0;
        for(int x=1;x<indexP;x++){
            temp1 = PGW[x].getIdPegawai();
            if(temp1==cari){
            temp = PGW[x];
        }}  
        return temp;
    }
    
        
    public void delete(int cari){
        pegawai temp=null;
        boolean ketemu=false;
        for(int i=1; i<indexP;i++){
            if(PGW[i].getIdPegawai()==cari){
                ketemu=true;
            }
        }
        if(ketemu==true){
            koneksi.ManipulasiData("delete from pegawai_06999 where id_pegawai = "+cari);
            indexP--;
            ketemu = false;
        }
    }
    
    public void update(int cari,String nama, String telp, String alamat, String gndr, String jabatan, String username, String password){
        for(int x=1;x<indexP;x++){
            if(PGW[x].getIdPegawai()==cari){
                PGW[x].setNama(nama);
                PGW[x].setNoTelp(telp);
                PGW[x].setGender(gndr);
                PGW[x].setJabatan(jabatan);
                PGW[x].setUsername(username);
                PGW[x].setPassword(password);
                koneksi.ManipulasiData("update pegawai_06999 set nama = '"+nama+"', jenis_kelamin = '"
                        + gndr+"', alamat = '"+alamat+"', no_telp = '"+telp+"', username = '"+username+"',"
                        + "password = '"+password+"', jabatan = '"+jabatan+"' where id_pegawai = "+cari);
                }}
    }
    


    public DefaultTableModel viewTabel() throws SQLException{
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" ID Pegawai");
        model.addColumn(" Nama");
        model.addColumn(" Gender");
        model.addColumn(" Alamat");
        model.addColumn(" No Telp");
        model.addColumn(" Jabatan");
        model.addColumn(" Username");
        model.addColumn(" Password");
        
        ResultSet rs = koneksi.GetData("select * from pegawai_06999");
        while (rs.next()){
            Object data[] = new Object[8];
            data[0] = rs.getInt("ID_PEGAWAI");
            data[1] = rs.getString("NAMA");
            data[2] = rs.getString("JENIS_KELAMIN");
            data[3] = rs.getString("ALAMAT");
            data[4] = rs.getString("NO_TELP");
            data[5] = rs.getString("USERNAME");
            data[6] = rs.getString("PASSWORD");
            data[7] = rs.getString("JABATAN");
            model.addRow(data);
        }
        
        /*for(int i=1 ;i<indexP;i++){
        Object data[] = new Object[8];
        data[0] = PGW[i].getIdPegawai();
        data[1] = PGW[i].getNama();
        data[2] = PGW[i].getGender();
        data[3] = PGW[i].getAlamat();
        data[4] = PGW[i].getNoTelp();
        data[5] = PGW[i].getJabatan();
        data[6] = PGW[i].getUsername();
        data[7] = PGW[i].getPassword();
        model.addRow(data);
        }*/
        return model;
    }

    public int getIDLogin() {
        return IDLogin;
    }
    
        public void getDataPegawai() throws SQLException {
        indexP=1;
        ResultSet rs = koneksi.GetData("select * from pegawai_06999");
        while (rs.next()){
            pegawai p = new pegawai();
            p.setIdPegawai(rs.getInt("ID_PEGAWAI"));
            p.setNama(rs.getString("NAMA"));
            p.setGender(rs.getString("JENIS_KELAMIN"));
            p.setAlamat(rs.getString("ALAMAT"));
            p.setNoTelp(rs.getString("NO_TELP"));
            p.setUsername(rs.getString("USERNAME"));
            p.setPassword(rs.getString("PASSWORD"));
            p.setJabatan(rs.getString("JABATAN"));
            PGW[indexP]=p;
        }
    }
    
    }

