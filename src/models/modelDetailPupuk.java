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
public class modelDetailPupuk {
    private Koneksi kon;

    public modelDetailPupuk() {
        try {
            kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelDetailPupuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getTableModel() throws SQLException {
        Object[] header = {"id","nama_pupuk","jenisTanaman","usia","jenisTanah"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);

        String sql = "select dp.id, p.nama_pupuk, tan.jenisTanaman, dp.usia t.jenisTanah from tanah t "
                + "join tanahpupuk tp on t.id=tp.id_tanah "
                + "join pupuk p on tp.id_pupuk=p.id "
                + "join detailpupuk dp on p.id=dp.id_pupuk " 
                + "join tanaman tan on dp.id_tanaman=tan.id";
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        ResultSet rs = kon.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[5];
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
