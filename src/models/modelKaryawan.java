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
public class modelKaryawan {
    private Koneksi kon;

    public modelKaryawan() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"Id","Username","Password"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select Id,Username,Password from users where status='users'";
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

    public void save(String Username, String Password) throws SQLException {
//         IdUser 	Nama 	NoKTP 	Alamat 	NoHP 	status 	Username 	Password
        String query = "INSERT INTO users VALUES(NULL,'" + Username + "','" + Password + "','users')";
        kon.execute(query);
    }

    public void update(String id, String Username, String Password) throws SQLException {
        String query = "UPDATE users SET Username='" + Username + "', Password = '"+Password +"' WHERE Id=" + id;
        kon.execute(query);
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM users WHERE id='" + id + "' ";
        kon.execute(query);
    }
}
