/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.modelDetailObat;
import views.viewDetailObat;

/**
 *
 * @author S
 */
public class DetailObatController {

    viewDetailObat theView = new viewDetailObat();
    modelDetailObat theModel = new modelDetailObat();

    public DetailObatController() {
        theView.setVisible(true);
        theView.addBtnBackListener(new btnBackListener());
        try {
            theView.getTbDetailObat().setModel(theModel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(DetailObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private class btnBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            HomeAdminController control = new HomeAdminController();
        }
    }

}
