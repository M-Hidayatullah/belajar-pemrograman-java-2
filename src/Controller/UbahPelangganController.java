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
public class UbahPelangganController implements ActionListener{
    Pelanggan model;
    UbahPelangganView view;
    Database con;

    public UbahPelangganController() throws SQLException {
        this.view = new UbahPelangganView();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubh_pel())){
            
            try {
                model = new Pelanggan(Integer.parseInt(view.getTxt_id().getText()), view.getTxt_nama().getText(), view.getTxt_asal().getText(), view.getTxt_notelp().getText());
                con.updatePelanggan(model);
                JOptionPane.showMessageDialog(view, "Data Pelanggan sudah diubah!");
                LihatPelangganController v = new LihatPelangganController();
                this.view.setVisible(false); 
            } catch (SQLException ex) {
                Logger.getLogger(UbahPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                LihatPelangganController m = new LihatPelangganController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(UbahPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}
