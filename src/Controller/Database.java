/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author M.Hidayatullah
 */
public class Database {
    String dbuser = "root";
    String dbpassword = "";
    String server = "jdbc:mysql://localhost:3306/travel";
    Statement statement;
    Connection connection;
    private static Petugas loginpetugas;

    public Statement getStatement() {
        return statement;
    }

    public Petugas getLoginpetugas() {
        return loginpetugas;
    }

    public void setLoginpetugas(int id, String nama, String user, String pass) {
        this.loginpetugas = new Petugas(id, nama, user, pass);
    }
    
    public void connect() throws SQLException{
        connection = DriverManager.getConnection(server, dbuser, dbpassword);
        statement = connection.createStatement();
    }
    
    public void saveWisata(TempatWisata tw) throws SQLException{
        String query = "INSERT INTO wisata (kabupaten, biaya, nama_tempat) VALUES ('"+tw.getKab()+"', '"+tw.getBiaya()+"', '"+tw.getNama()+"')";
        statement.execute(query);
        int id = Statement.RETURN_GENERATED_KEYS;
        tw.setId(id);
    }
    
    public ArrayList<TempatWisata> loadAllWisata() throws SQLException{
        ArrayList<TempatWisata> list = new ArrayList<TempatWisata>();
        String query = "SELECT * FROM wisata";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            TempatWisata t = new TempatWisata(rs.getString(4), rs.getString(2), rs.getInt(3), rs.getInt(1));
            list.add(t);
        }
        return list;
    }
    
    public void updateWisata(TempatWisata tw) throws SQLException{
        String query = "UPDATE wisata SET nama_tempat = '"+tw.getNama()+"', kabupaten = '"+tw.getKab()+"', biaya = "+tw.getBiaya()+" WHERE id_wisata = "+tw.getId();
        statement.execute(query);
    }
    
    public void hapusWisata(int id) throws SQLException{
        String query = "Delete from wisata where id_wisata = "+id;
        statement.execute(query);
    }
    
    public void savePelanggan(Pelanggan p) throws SQLException{
        String query = "INSERT INTO pelanggan (nama_pel, no_telp, asal) VALUES ('"+p.getNama()+"', '"+p.getNo_telp()+"', '"+p.getAsal()+"')";
        statement.execute(query);
        int id = Statement.RETURN_GENERATED_KEYS;
        p.setId(id);
    }
    
    public ArrayList<Pelanggan> loadAllPelanggan() throws SQLException{
        ArrayList<Pelanggan> list = new ArrayList<Pelanggan>();
        String query = "SELECT * FROM pelanggan";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Pelanggan t = new Pelanggan(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
            list.add(t);
        }
        return list;
    }
    
    public void updatePelanggan(Pelanggan tw) throws SQLException{
        String query = "UPDATE pelanggan SET nama_pel = '"+tw.getNama()+"', no_telp = '"+tw.getNo_telp()+"', asal = '"+tw.getAsal()+"' WHERE id_pel = "+tw.getId();
        statement.execute(query);
    }
    
    public void hapusPelanggan(int id) throws SQLException{
        String query = "Delete from pelanggan where id_pel = "+id;
        statement.execute(query);
    }
    
    public void saveKendaraan(Kendaraan k) throws SQLException{
        String query = "INSERT INTO kendaraan VALUES ('"+k.getPlat()+"', '"+k.getJenis()+"', '"+k.getStatus()+"')";
        statement.execute(query);
    }
    
    public ArrayList<Kendaraan> loadAllKendaraan() throws SQLException{
        ArrayList<Kendaraan> list = new ArrayList<Kendaraan>();
        String query = "SELECT * FROM kendaraan";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Kendaraan t = new Kendaraan(rs.getString(1), rs.getString(2), rs.getString(3));
            list.add(t);
        }
        return list;
    }
    
    public void updateKendaraan(Kendaraan tw) throws SQLException{
        String query = "UPDATE kendaraan SET  jenis = '"+tw.getJenis()+"', status = '"+tw.getStatus()+"' WHERE plat = '"+tw.getPlat()+"'";
        statement.execute(query);
    }
    
    public void hapusKendaraan(String plat) throws SQLException{
        String query = "Delete from kendaraan where plat = '"+plat+"'";
        statement.execute(query);
    }
    
    public void savePemesanan(Pemesanan pem) throws SQLException{
        String query = "INSERT INTO pesan VALUES ("+ pem.getId_pel()+", "+pem.getId_wisata()+", "+pem.getId_ptgs()+", '"+pem.getPlat()+"', "+pem.getBiaya()+", '"+ new java.sql.Date(pem.getTanggal().getTime())+ "', null)";
        statement.execute(query);
        int id = Statement.RETURN_GENERATED_KEYS;
        pem.setNo_pesan(id);
    }
    
    public ArrayList<Pemesanan> loadAllPemesanan() throws SQLException{
        ArrayList<Pemesanan> list = new ArrayList<Pemesanan>();
        String query = "SELECT * FROM pesan";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            Pemesanan pem = new Pemesanan(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDate(6));
            list.add(pem);
        }
        return list;
    }
    
    public void hapusPemesanan(String plat) throws SQLException{
        String query = "Delete from kendaraan where plat = '"+plat+"'";
        statement.execute(query);
    }
}
