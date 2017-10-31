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
import models.modelPupuk;
import views.viewPupuk;

/**
 *
 * @author S
 */
public class PupukController {

    viewPupuk theView = new viewPupuk();
    modelPupuk theModel = new modelPupuk();

    public PupukController() {
        theView.setVisible(true);
        theView.addBtnBackListener(new btnBackListener());
        theView.addBtnBuatListener(new btnBuatListener());
        theView.addBtnSimpanListener(new btnSimpanListener());
        theView.addBtnEditListener(new btnEditListener());
        theView.addBtnHapusListener(new btnHapusListener());
        try {
            theView.getTbPupuk().setModel(theModel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(PupukController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class btnHapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int baris = theView.getTbPupuk().getSelectedRow();
            String id = (String) theView.getTbPupuk().getValueAt(baris, 0);
            try {
                theModel.delete(id);
                theView.getTbPupuk().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(PupukController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class btnSimpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String id = theView.getTxtID().getText();
                String NamaPupuk = theView.getTxtNamaPupuk().getText();
                String Harga = theView.getTxtHarga().getText();
                if (id.isEmpty()) {

                    theModel.save(NamaPupuk, Harga);

                } else {
                    theModel.update(id, NamaPupuk, Harga);

                }
                theView.getBtnSimpan().setEnabled(false);
                theView.getTbPupuk().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(PupukController.class.getName()).log(Level.SEVERE, null, ex);
            }
            theView.getTxtID().setText("");
            theView.getTxtNamaPupuk().setText("");
            theView.getTxtHarga().setText("");
        }
    }

    private class btnEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            int baris = theView.getTbPupuk().getSelectedRow();
            String id = (String) theView.getTbPupuk().getValueAt(baris, 0);
            String NamaPupuk = (String) theView.getTbPupuk().getValueAt(baris, 1);
            String Harga = (String) theView.getTbPupuk().getValueAt(baris, 2);
            theView.getTxtID().setText(id);
            theView.getTxtNamaPupuk().setText(NamaPupuk);
            theView.getTxtHarga().setText(Harga);
            theView.getTxtNamaPupuk().setEditable(true);
            theView.getTxtHarga().setEditable(true);
            theView.getBtnSimpan().setEnabled(true);

        }
    }

    private class btnBuatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.getTxtNamaPupuk().setEditable(true);
            theView.getTxtHarga().setEditable(true);
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
