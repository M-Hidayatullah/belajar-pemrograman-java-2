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
public class UbahWisataController implements ActionListener{
    TempatWisata model;
    UbahWisataView view;
    Database con;

    public UbahWisataController() throws SQLException {
        this.view = new UbahWisataView();
        this.model = new TempatWisata();
        view.setController(this);
        view.setVisible(true);
        view.InitCombo();
        con = new Database();
        con.connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubh_wisata())){
            
            try {
                model.setBiaya(Integer.parseInt(view.getTxt_biaya().getText()));
                model.setKab(view.getTxt_kab());
                model.setNama(view.getTxt_nama().getText());
                model.setId(Integer.parseInt(view.getTxt_id().getText()));
                System.out.println("ID YANG DIUBAH "+model.getId());
                con.updateWisata(model);
                JOptionPane.showMessageDialog(view, "Data wisata sudah diubah!");
                LihatWisataController v = new LihatWisataController();
                this.view.setVisible(false); 
            } catch (SQLException ex) {
                Logger.getLogger(UbahWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                LihatWisataController m = new LihatWisataController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(UbahWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}
