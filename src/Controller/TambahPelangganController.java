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
import javax.swing.JOptionPane;

/**
 *
 * @author M.Hidayatullah
 */
public class TambahPelangganController implements ActionListener{
    Pelanggan model;
    TambahPelangganView view;
    Database con;

    public TambahPelangganController() throws SQLException {
        this.view = new TambahPelangganView();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_tmbh_pel())){
            String nama = view.getTxt_nama().getText();
            String asl = view.getTxt_asal().getText();
            String no = view.getTxt_notelp().getText();
            model = new Pelanggan(nama, asl, no);
            try {
                con.savePelanggan(model);
                JOptionPane.showMessageDialog(view, "Data Pelanggan ditambahkan!");
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TambahPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(UbahWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
