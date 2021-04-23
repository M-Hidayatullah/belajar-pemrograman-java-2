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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M.Hidayatulah
 */
public class LihatPemesananController extends MouseAdapter implements ActionListener, ItemListener {
    LihatPemesananView view;
    Database con;
    int selected;
    Pelanggan t;

    public LihatPemesananController() throws SQLException {
        this.view = new LihatPemesananView();
        view.setController(this);
        view.addAdapter(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
        view.viewAll();
        view.InitCombo();
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        Object s = me.getSource();
        if(s.equals(view.getTabel_all())){
            selected = view.getSelectedPelanggan();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(UbahWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        int select = view.getCombo_view().getSelectedIndex();
        if(select == 0){
            try {
                view.viewAll();
            } catch (SQLException ex) {
                Logger.getLogger(LihatPemesananController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(select == 1){
            try {
                view.viewTransaksi();
            } catch (SQLException ex) {
                Logger.getLogger(LihatPemesananController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
