/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author S
 */
public class modelSppkPupuk {

    private Koneksi kon;

    public modelSppkPupuk() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkPupuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultComboBoxModel<String> getCBTanaman() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String sql = "select jenisTanaman from tanaman t "
                + "join detailpupuk dp on t.id=dp.id_tanaman ";
        ResultSet rs;
        try {
            rs = kon.getResult(sql);
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkPupuk.class.getName()).log(Level.SEVERE, null, ex);

        }
        return model;
    }

    public DefaultComboBoxModel<String> getCBUmur(String tanaman) throws SQLException {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String sql = "SELECT dp.usia from detailpupuk dp "
                + "join tanaman t on dp.id_tanaman=t.id where t.jenisTanaman='"+tanaman+"'";
        ResultSet rs;
        try {
            rs = kon.getResult(sql);
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkPupuk.class.getName()).log(Level.SEVERE, null, ex);

        }
        return model;
    }
    public DefaultComboBoxModel<String> getCBTanah(String tanaman) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String sql = "select t.jenisTanah from tanah t join tanahpupuk tp on t.id=tp.id_tanah "
                + "join pupuk p on tp.id_pupuk=p.id "
                + "join detailpupuk dp on p.id=dp.id_pupuk "
                + "join tanaman tan on tan.id=dp.id_tanaman "
                + "where tan.jenisTanaman = '"+tanaman+"'";
        ResultSet rs;
        try {
            rs = kon.getResult(sql);
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkPupuk.class.getName()).log(Level.SEVERE, null, ex);

        }
        return model;
    }
    public String getPupuk(String tanaman, String usia, String tanah) {
        String query = "select p.nama_pupuk from tanah t "
                + "join tanahpupuk tp on t.id=tp.id_tanah "
                + "join pupuk p on tp.id_pupuk=p.id "
                + "join detailpupuk dp on p.id=dp.id_pupuk " 
                + "join tanaman tan on dp.id_tanaman=tan.id "
                + "where tan.JenisTanaman='"+tanaman+"' and dp.usia='"+usia+"' and t.JenisTanah='"+tanah+"'";
        ResultSet rs;
        String pupuk = null;
        try {
            rs = kon.getResult(query);
            rs.next();
            pupuk = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkPupuk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pupuk;
    }
}
