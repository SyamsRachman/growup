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
public class modelTanaman {
    private Koneksi kon;

    public modelTanaman() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelTanaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id","Nama Tanaman"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select * from Tanaman";
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

    public void save(String JenisTanaman) throws SQLException {
        String query = "INSERT INTO Tanaman VALUES(NULL, '" + JenisTanaman + "')";
        kon.execute(query);
    }

    public void update(String id, String JenisTanaman) throws SQLException {
        String query = "UPDATE Tanaman SET JenisTanaman='" + JenisTanaman + "' WHERE Id=" + id;
        kon.execute(query);
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM tanaman WHERE id='" + id + "' ";
        kon.execute(query);
    }
}
