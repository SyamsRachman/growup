/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.modelSppkPupuk;
import views.viewSppkPupuk;

/**
 *
 * @author S
 */
public class SppkPupukController {
    viewSppkPupuk theView = new viewSppkPupuk();
    modelSppkPupuk theModel = new modelSppkPupuk();

    public SppkPupukController() {
    theView.setVisible(true);
    theView.addBtnCariListener(new btnCariListener());
    theView.getCbTanaman().setModel(theModel.getCBTanaman());
    theView.addCbTanamanListener(new cbTanamanListener());
    theView.addBtnBackListener(new btnBackListener());
    }

    private class btnBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            HomeUsersController control = new HomeUsersController();
        }
    }

    private class cbTanamanListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            String tanaman = (String) theView.getCbTanaman().getSelectedItem();
            try {
                theView.getCbUsia().setModel(theModel.getCBUmur(tanaman));
                theView.getCbTanah().setModel(theModel.getCBTanah(tanaman));
            } catch (SQLException ex) {
                Logger.getLogger(SppkPupukController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    private class btnCariListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
         String tanaman = (String) theView.getCbTanaman().getSelectedItem();
         String usia = (String) theView.getCbUsia().getSelectedItem();
         String tanah = (String) theView.getCbTanah().getSelectedItem();
         
         String pupuk = theModel.getPupuk(tanaman, usia, tanah);
         theView.ShowPupuk(pupuk);
        }
    }
    
}
