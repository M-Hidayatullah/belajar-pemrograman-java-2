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
public class UbahKendaraanController implements ActionListener{
    Kendaraan model;
    UbahKendaraanView view;
    Database con;

    public UbahKendaraanController() throws SQLException {
        this.view = new UbahKendaraanView();
        view.setController(this);
        view.setVisible(true);
        view.InitCombo();
        con = new Database();
        con.connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubh_kend())){
            
            try {
                model = new Kendaraan(view.getTxt_plat().getText(), view.getTxt_jenis().getText(), view.getTxt_status());
                con.updateKendaraan(model);
                JOptionPane.showMessageDialog(view, "Data Kendaraan sudah diubah!");
                LihatKendaraanController v = new LihatKendaraanController();
                this.view.setVisible(false); 
            } catch (SQLException ex) {
                Logger.getLogger(UbahKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(UbahKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}
