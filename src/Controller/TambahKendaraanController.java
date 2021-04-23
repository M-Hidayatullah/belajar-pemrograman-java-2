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
public class TambahKendaraanController implements ActionListener{
    Kendaraan model;
    TambahKendaraanView view;
    Database con;

    public TambahKendaraanController() throws SQLException {
        this.view = new TambahKendaraanView();
        view.setController(this);
        view.setVisible(true);
        view.InitCombo();
        con = new Database();
        con.connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_tmbh_kend())){
            String plat = view.getTxt_plat().getText();
            String jenis = view.getTxt_jenis().getText();
            String status = view.getTxt_status();
            model = new Kendaraan(plat, jenis, status);
            try {
                con.saveKendaraan(model);
                JOptionPane.showMessageDialog(view, "Data Kendaraan ditambahkan!");
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TambahKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TambahKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
