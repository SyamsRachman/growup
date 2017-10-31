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
import models.modelKaryawan;
import views.viewKaryawan;

/**
 *
 * @author S
 */
public class KaryawanController {

    viewKaryawan theView = new viewKaryawan();
    modelKaryawan theModel = new modelKaryawan();

    public KaryawanController() {
        theView.setVisible(true);
        theView.addBtnBackListener(new btnBackListener());
        theView.addBtnBuatListener(new btnBuatListener());
        theView.addBtnSimpanListener(new btnSimpanListener());
        theView.addBtnEditListener(new btnEditListener());
        theView.addBtnHapusListener(new btnHapusListener());
        try {
            theView.getTbKaryawan().setModel(theModel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class btnHapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int baris = theView.getTbKaryawan().getSelectedRow();
            String id = (String) theView.getTbKaryawan().getValueAt(baris, 0);
            try {
                theModel.delete(id);
                theView.getTbKaryawan().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class btnSimpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String id = theView.getTxtID().getText();
                String Username = theView.getTxtUsername().getText();
                String Password = theView.getTxtPassword().getText();
                if (id.isEmpty()) {

                    theModel.save(Username, Password);

                } else {
                    theModel.update(id, Username, Password);

                }
                theView.getBtnSimpan().setEnabled(false);
                theView.getTbKaryawan().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            theView.getTxtID().setText("");
            theView.getTxtUsername().setText("");
            theView.getTxtPassword().setText("");
            
        }
    }

    private class btnEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            int baris = theView.getTbKaryawan().getSelectedRow();
            String id = (String) theView.getTbKaryawan().getValueAt(baris, 0);
            String Username = (String) theView.getTbKaryawan().getValueAt(baris, 1);
            String Password = (String) theView.getTbKaryawan().getValueAt(baris, 2);
            theView.getTxtID().setText(id);
            theView.getTxtUsername().setText(Username);
            theView.getTxtPassword().setText(Password);
            theView.getTxtUsername().setEditable(true);
            theView.getTxtPassword().setEditable(true);
            theView.getBtnSimpan().setEnabled(true);

        }
    }

    private class btnBuatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.getTxtUsername().setEditable(true);
            theView.getTxtPassword().setEditable(true);
            theView.getBtnSimpan().setEnabled(true);
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
