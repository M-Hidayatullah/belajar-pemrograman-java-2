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
public class Pelanggan {
    private int id;
    private String nama;
    private String asal;
    private String no_telp;

    public Pelanggan(String nama, String asal, String no_telp) {
        this.nama = nama;
        this.asal = asal;
        this.no_telp = no_telp;
    }

    public Pelanggan(int id, String nama, String asal, String no_telp) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.no_telp = no_telp;
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

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    
          
}
