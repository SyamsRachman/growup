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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author S
 */
public class modelObat {
    private Koneksi kon;

    public modelObat() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id","Nama Obat","Harga"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select Id_obat, nama_obat, harga from obat";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[3];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public void save(String NamaObat, String Harga) throws SQLException {
        String query = "INSERT INTO obat VALUES(NULL,'" + NamaObat + "','" + Harga + "')";
        kon.execute(query);
    }

    public void update(String id, String NamaObat, String Harga) throws SQLException {
        String query = "UPDATE obat SET nama_obat='" + NamaObat + "', Harga = '"+Harga +"' WHERE Id_obat=" + id;
        kon.execute(query);
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM obat WHERE id_obat='" + id + "' ";
        kon.execute(query);
    }
}
