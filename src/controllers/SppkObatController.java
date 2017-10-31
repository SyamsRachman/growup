/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.modelSppkObat;
import views.viewSppkObat;

/**
 *
 * @author S
 */
public class SppkObatController {
    
    viewSppkObat theView = new viewSppkObat();
    modelSppkObat theModel = new modelSppkObat();

    public SppkObatController() {
        theView.setVisible(true);
        theView.getCbJenisTanaman().setModel(theModel.getCBTanaman());
        theView.addCbJenisTanamanListener(new cdJenisTanamanListener());
        theView.addBtnSubmitListener(new btnSubmitListener());
        theView.addBtnBackListener(new btnBackListener());
    }

    private class btnBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            HomeUsersController control = new HomeUsersController();
        }
    }

    private class btnSubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
         String tanaman = (String) theView.getCbJenisTanaman().getSelectedItem();
         String hama = (String) theView.getCbHama().getSelectedItem();
         String usia = (String) theView.getCbUsia().getSelectedItem();
         String obat = theModel.getObat(tanaman, hama, usia);
         theView.ShowObat(obat);
        }
    }

    private class cdJenisTanamanListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            try {
                String tanaman = (String) theView.getCbJenisTanaman().getSelectedItem();
                theView.getCbHama().setModel(theModel.getCBHama(tanaman));
                theView.getCbUsia().setModel(theModel.getCBUsia(tanaman));
            } catch (SQLException ex) {
                Logger.getLogger(SppkObatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
