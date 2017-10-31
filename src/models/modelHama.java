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
public class modelHama {
    private Koneksi kon;

    public modelHama() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelHama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id","Nama Hama"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from Hama";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[2];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public void save(String NamaHama) throws SQLException {
        String query = "INSERT INTO Hama VALUES(NULL, '" + NamaHama + "')";
        kon.execute(query);
    }

    public void update(String id, String NamaHama) throws SQLException {
        String query = "UPDATE Hama SET nama_hama='" + NamaHama + "' WHERE Id=" + id;
        kon.execute(query);
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM hama WHERE id='" + id + "' ";
        kon.execute(query);
    }
}
