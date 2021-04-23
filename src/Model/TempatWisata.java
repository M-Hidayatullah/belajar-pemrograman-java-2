/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author M.Hidayatullah
 */
public class TempatWisata {
    private int id;
    private String nama;
    private String kab;
    private int biaya;

    public TempatWisata(String nama, String kab, int biaya) {
        this.nama = nama;
        this.kab = kab;
        this.biaya = biaya;
    }
    
    public TempatWisata(String nama, String kab, int biaya, int id) {
        this.nama = nama;
        this.kab = kab;
        this.biaya = biaya;
        this.id = id;
    }

    public TempatWisata() {
        
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }
    
}
