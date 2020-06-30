/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import database.Koneksi;
import java.sql.*;
import java.text.*;
/**
 *
 * @author unknown
 */
public class getData {
    Koneksi koneksi;
    SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
    Date tgl;
    public getData() throws SQLException{
    koneksi = new Koneksi();
    getDataBuku();
    getDataPegawai();
    getDataRegistrasi();
    getDataTransaksi();
    }
    
    public void getDataBuku() throws SQLException{
        int index=1;
        ResultSet rs = koneksi.GetData("select * from buku_06999" );
        while (rs.next()) {
            buku b = new buku();
            b.setId_buku(rs.getInt("ID_BUKU"));
            b.setJdl_buku(rs.getString("JUDUL_BUKU"));
            b.setPenerbit(rs.getString("PENERBIT"));
            b.setThn_terbit(rs.getInt("TAHUN_TERBIT"));
            b.setHarga(rs.getInt("HARGA"));
            AllObject.buku.BK[index]=b;;
            index++;
            AllObject.buku.setIndex(index);
            }
    }
    
    public void getDataPegawai() throws SQLException {
        int index=1;
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
            AllObject.pegawai.PGW[index]=p;
            index++;
            AllObject.pegawai.setIndexP(index);
        }
    }
    
    public void getDataRegistrasi() throws SQLException{
        int index=1;
        ResultSet rs = koneksi.GetData("SELECT * from view_regis");
        while(rs.next()){
            pegawai p = new pegawai();
            p.setIdPegawai(rs.getInt("ID_PEGAWAI"));
            p.setNama(rs.getString("NAMA_PEGAWAI"));
            p.setGender(rs.getString("GENDER_PEGAWAI"));
            p.setAlamat(rs.getString("ALAMAT_PEGAWAI"));
            p.setNoTelp(rs.getString("NO_TELP_PEGAWAI"));
            p.setJabatan(rs.getString("JABATAN"));
            p.setUsername(rs.getString("USERNAME"));
            p.setPassword(rs.getString("PASSWORD"));
            
            member m = new member();
            m.setIdMember(rs.getInt("ID_PEMBELI"));
            m.setNama(rs.getString("NAMA_PEMBELI"));
            m.setGender(rs.getString("GENDER_PEMBELI"));
            m.setAlamat(rs.getString("ALAMAT_PEMBELI"));
            m.setNoTelp(rs.getString("NO_TELP_PEMBELI"));

            registrasi r = new registrasi();
            r.setNo_reg(rs.getInt("NO_REGISTRASI"));
            r.setTgl(date.format(rs.getDate("O6999_TANGGAL")));
            r.setPegawai(p);
            r.setMember(m);
            m.setRegis(r);
            r.getMember().setRegis(r);
            AllObject.member.member[index]=m;
            AllObject.regis.reg[index]=r;
            index++;
            AllObject.regis.setIndex(index);
            AllObject.member.setIndex(index);
        }
    }
    
    public void getDataTransaksi() throws SQLException {
        int index=1;
        int x=1;
        ResultSet rs = koneksi.GetData("select * from transaksi_06999");
        while (rs.next()){
            transaksi t = new transaksi();
            t.setNo_transaksi(rs.getInt("NO_TRANSAKSI"));
            t.setBayar(rs.getInt("TOTAL_BAYAR"));
            t.setKembali(rs.getInt("KEMBALI"));
            t.setTotal(rs.getInt("TOTAL_HARGA"));
            t.setMember(AllObject.member.cari_member(rs.getInt("ID_PEMBELI")));
            t.setPegawai(AllObject.pegawai.search(rs.getInt("ID_PEGAWAI")));
            ResultSet rsD = koneksi.GetData("select * from detail_transaksi_06999 join " +
            "buku_06999 on detail_transaksi_06999.id_buku = buku_06999.id_buku " +
            "where detail_transaksi_06999.no_transaksi = " + rs.getInt("NO_TRANSAKSI"));
            detail_transaksi[] dt = new detail_transaksi[100];
            while(rsD.next()){
                buku b = new buku();
                b.setId_buku(rsD.getInt("ID_BUKU"));
                b.setJdl_buku(rsD.getString("JUDUL_BUKU"));
                b.setPenerbit(rsD.getString("PENERBIT"));
                b.setThn_terbit(rsD.getInt("TAHUN_TERBIT"));
                b.setHarga(rsD.getInt("HARGA"));
                
                detail_transaksi d = new detail_transaksi();
                d.setBuku(b);
                tgl = rsD.getDate("TANGGAL");
                d.setTgl(date.format(tgl));
                d.setQnt(rsD.getInt("QUANTITY"));
                dt[x]=d;
                x++;
            }
            t.setJumlah(x-1);
            t.setDetail(dt);
            x=1;
            AllObject.transaksi.trs[index]=t;
            index++;
            AllObject.transaksi.setIndex(index);
        }
    }
}
