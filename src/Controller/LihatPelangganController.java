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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author M.Hidayatullah
 */
public class LihatPelangganController extends MouseAdapter implements ActionListener {
    LihatPelangganView view;
    Database con;
    int selected;
    Pelanggan t;

    public LihatPelangganController() throws SQLException {
        this.view = new LihatPelangganView();
        view.setController(this);
        view.addAdapter(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
        view.viewAll(con.loadAllPelanggan());
        view.getBtn_ubah().setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        Object s = me.getSource();
        if(s.equals(view.getTable_wisata())){
            selected = view.getSelectedPelanggan();
           
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubah())){
            try {
                t = con.loadAllPelanggan().get(selected);
                UbahPelangganController c = new UbahPelangganController();
                c.view.view(t);
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(LihatPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(source.equals(view.getBtn_hps())){
            try {
                int id = con.loadAllPelanggan().get(selected).getId();
                con.hapusPelanggan(id);
                JOptionPane.showMessageDialog(view, "Data pelanggan sudah dihapus!");
                this.view.setVisible(false);
                LihatPelangganController v = new LihatPelangganController();
            } catch (SQLException ex) {
                Logger.getLogger(LihatPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(LihatPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
