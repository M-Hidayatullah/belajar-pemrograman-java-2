/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author M.Hidayatullah
 */
public class Pemesanan {
    private int id_pel;
    private int id_wisata;
    private int id_ptgs;
    private String plat;
    private int biaya;
    private Date tanggal;
    private int no_pesan;

    public Pemesanan(int id_pel, int id_wisata, int id_ptgs, String plat, int biaya, Date tanggal) {
        this.id_pel = id_pel;
        this.id_wisata = id_wisata;
        this.id_ptgs = id_ptgs;
        this.plat = plat;
        this.biaya = biaya;
        this.tanggal = tanggal;
    }

    public int getId_pel() {
        return id_pel;
    }

    public void setId_pel(int id_pel) {
        this.id_pel = id_pel;
    }

    public int getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(int id_wisata) {
        this.id_wisata = id_wisata;
    }

    public int getId_ptgs() {
        return id_ptgs;
    }

    public void setId_ptgs(int id_ptgs) {
        this.id_ptgs = id_ptgs;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getNo_pesan() {
        return no_pesan;
    }

    public void setNo_pesan(int no_pesan) {
        this.no_pesan = no_pesan;
    }
    
    
}
