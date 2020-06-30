/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.main;
import javax.swing.*;
import database.Koneksi;
import controller.getData;
/**
 *
 * @author unknown
 */
public class Toko_buku {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        main gui = new main();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        new getData();
        // TODO code application logic here
    }
    
}
