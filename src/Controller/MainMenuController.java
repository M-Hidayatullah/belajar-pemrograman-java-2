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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M.Hidayatullah
 */
public class MainMenuController implements ActionListener{
    MainMenuView view;
    Database con;

    public MainMenuController() throws SQLException {
        this.view = new MainMenuView();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_tmbh_wisata())){
            try {
                TambahWisataController m = new TambahWisataController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(source.equals(view.getBtn_ubh_wisata())){
            try {
                LihatWisataController c = new LihatWisataController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_tmbh_pel())){
            try {
                TambahPelangganController c = new TambahPelangganController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_ubh_pel())){
            try {
                LihatPelangganController c = new LihatPelangganController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_tmbh_kend())){
            try {
                TambahKendaraanController c = new TambahKendaraanController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_ubh_kend())){
            try {
                LihatKendaraanController c = new LihatKendaraanController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_tmbh_pems())){
            try {
                TambahPemesananController c = new TambahPemesananController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_ubh_pems())){
            try {
                LihatPemesananController c = new LihatPemesananController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
