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
public class modelDetailObat {
    private Koneksi kon;

    public modelDetailObat() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelDetailObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"id","nama_obat","nama_hama","jenisTanaman"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "SELECT do.id, o.nama_obat,h.nama_hama, t.jenisTanaman from tanaman t "
                + "join detailobat do on t.id=do.id_tanaman "
                + "join obat o on do.id_obat=o.id_obat "
                + "join hama h on do.id=h.id";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[4];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tableModel.addRow(kolom);
        }
        return tableModel;
    }

    public void save(String NamaPupuk, String Harga) throws SQLException {
//         IdUser 	Nama 	NoKTP 	Alamat 	NoHP 	status 	Username 	Password
        String query = "INSERT INTO pupuk VALUES(NULL,'" + NamaPupuk + "','" + Harga + "')";
        kon.execute(query);
    }

    public void update(String id, String NamaPupuk, String Harga) throws SQLException {
        String query = "UPDATE pupuk SET nama_pupuk='" + NamaPupuk + "', Harga = '"+Harga +"' WHERE Id=" + id;
        kon.execute(query);
    }

    public void delete(String id) throws SQLException {
        String query = "DELETE FROM pupuk WHERE id='" + id + "' ";
        kon.execute(query);
    }
}
