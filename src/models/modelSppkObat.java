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
public class modelSppkObat {

    private Koneksi kon;

    public modelSppkObat() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public DefaultComboBoxModel<String> getCBTanaman() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String sql = "select t.jenisTanaman from tanaman t JOIN detailobat do ON t.id=do.id_tanaman GROUP BY t.jenisTanaman";
        ResultSet rs;
        try {
            rs = kon.getResult(sql);
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkObat.class.getName()).log(Level.SEVERE, null, ex);

        }
        return model;
    }

    public DefaultComboBoxModel<String> getCBHama(String tanaman) throws SQLException {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String sql = "select h.nama_hama from tanaman t "
                + "join detailobat do on t.id=do.id_tanaman "
                + "join hama h on h.id=do.id_hama where t.JenisTanaman='" +tanaman+"'";
        ResultSet rs;
        try {
            rs = kon.getResult(sql);
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkObat.class.getName()).log(Level.SEVERE, null, ex);

        }
        return model;
    }
    public DefaultComboBoxModel<String> getCBUsia(String tanaman) throws SQLException {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        String sql = "select do.usia from tanaman t join detailobat do on t.id=do.id_tanaman where t.JenisTanaman='"+tanaman+"'";
        ResultSet rs;
        try {
            rs = kon.getResult(sql);
            while (rs.next()) {
                model.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkObat.class.getName()).log(Level.SEVERE, null, ex);

        }
        return model;
    }
    public String getObat(String tanaman, String hama, String usia) {
        String query = "SELECT o.nama_obat FROM tanaman t "
                + "join detailobat do on t.id=do.id_tanaman "
                + "join hama h on h.id=do.id_hama "
                + "join obat o on o.id_obat=do.id_obat "
                + "where t.jenisTanaman='"+tanaman+"' AND h.nama_hama='"+hama+"' and do.usia='"+usia+"'";
        ResultSet rs;
        String pupuk = null;
        try {
            rs = kon.getResult(query);
            rs.next();
            pupuk = rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(modelSppkObat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pupuk;
    }
}
