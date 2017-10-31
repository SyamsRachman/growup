/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.modelLogin;
import views.viewLogin;

/**
 *
 * @author S
 */
public class LoginController {

    modelLogin theModel = new modelLogin();
    viewLogin theView = new viewLogin();

    public LoginController() {
        theView.setVisible(true);
        theView.addBtnLoginListener(new LoginListener());
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String Username = theView.getTxtUsername().getText();
            String Password = "";
            char passArray[] = theView.getTxtPassword().getPassword();
            for (int i = 0; i < passArray.length; i++) {
                Password += passArray[i];
            }
            try {
                ResultSet rs = theModel.check(Username, Password);
                rs.last();
                if (rs.getRow() == 1) {
                    String Bagian = rs.getString(4);
                    String Nama = rs.getString(2);
                    theView.dispose();
                    if (Bagian.equalsIgnoreCase("Users")) {
                        HomeUsersController control = new HomeUsersController();
                    } else {
                        HomeAdminController control = new HomeAdminController();
                    }

                } else {
                    theView.salah();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
