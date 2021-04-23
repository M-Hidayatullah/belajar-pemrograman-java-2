/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author M.Hidayatullah
 */
public class TambahPemesananController implements ActionListener, ItemListener{
    Pemesanan model;
    TambahPemesananView view;
    Database con;

    public TambahPemesananController() throws SQLException {
        this.view = new TambahPemesananView();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
        view.loadPelanggan(con.loadAllPelanggan());
        view.getCombo_pel().setSelectedIndex(-1);
        view.loadKendaraan(con.loadAllKendaraan());
        view.getCombo_kend().setSelectedIndex(-1);
        view.loadWisata(con.loadAllWisata()); 
        view.getCombo_wisata().setSelectedIndex(-1);
        view.getTxt_biaya().setText("");
    }
    
    
    public int getSelectedId_Pel(){
        String id_pel = (String)view.getCombo_pel().getSelectedItem();
        id_pel=id_pel.substring(0,1);
        return Integer.parseInt(id_pel);
    }
    
    public int getSelectedId_Wisata() throws SQLException{
        int id_wis = -1;
        String namawis = (String)view.getCombo_wisata().getSelectedItem();
        String query = "SELECT id_wisata from wisata where nama_tempat = '"+namawis+"'";
        ResultSet rs = con.statement.executeQuery(query);
        if(rs.next()){
            id_wis = rs.getInt(1);
        }
        return id_wis;
    }
    
    public String getSelectedPlat(){
        String plat = (String)view.getCombo_kend().getSelectedItem();
        plat=plat.substring(0,7);
        return plat;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_tambah_pesan())){
            try {
                model = new Pemesanan(getSelectedId_Pel(), getSelectedId_Wisata(), con.getLoginpetugas().getId(), getSelectedPlat(), Integer.parseInt(view.getTxt_biaya().getText()), view.getTanggal());
                con.savePemesanan(model);
                JOptionPane.showMessageDialog(view, "Data Pemesanan ditambahkan!");
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TambahPemesananController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TambahPemesananController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        Object source = ie.getSource();
        if(source.equals(view.getCombo_wisata())){
            String c = (String)view.getCombo_wisata().getSelectedItem();
            String query = "SELECT biaya from wisata where nama_tempat = '"+c+"'";
            try {
                ResultSet rs = con.statement.executeQuery(query);
                if(rs.next()){
                    view.getTxt_biaya().setText(String.valueOf(rs.getInt(1)));
                    view.getTxt_biaya().setEditable(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TambahPemesananController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

}
