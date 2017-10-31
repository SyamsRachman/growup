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
public class modelTanah {
    private Koneksi kon;

    public modelTanah() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelTanah.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id","Jenis Tanah"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from Tanah";
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

    public void save(String JenisTanah) throws SQLException {
        String query = "INSERT INTO Tanah VALUES(NULL, '" + JenisTanah + "')";
        kon.execute(query);
    }

    public void update(String id, String JenisTanah) throws SQLException {
        String query = "UPDATE Tanah SET JenisTanah='" + JenisTanah + "' WHERE Id=" + id;
        kon.execute(query);
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM tanah WHERE id='" + id + "' ";
        kon.execute(query);
    }
}
