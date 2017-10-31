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

/**
 *
 * @author S
 */
public class modelLogin {

    Koneksi kon;

    public modelLogin() {
        try {
            this.kon = new Koneksi("root", "", "trpl4");
        } catch (SQLException ex) {
            Logger.getLogger(modelLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet check(String Username, String Password) throws SQLException {
        String query = "SELECT * FROM Users WHERE username='" + Username + "' AND password='" + Password + "'";
        ResultSet Result = kon.getResult(query);
        return Result;
    }

}
