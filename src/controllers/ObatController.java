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
import models.modelObat;
import views.viewObat;

/**
 *
 * @author S
 */
public class ObatController {

    viewObat theView = new viewObat();
    modelObat theModel = new modelObat();

    public ObatController() {
        theView.setVisible(true);
        theView.addBtnBackListener(new btnBackListener());
        theView.addBtnBuatListener(new btnBuatListener());
        theView.addBtnSimpanListener(new btnSimpanListener());
        theView.addBtnEditListener(new btnEditListener());
        theView.addBtnHapusListener(new btnHapusListener());
        try {
            theView.getTbObat().setModel(theModel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class btnHapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int baris = theView.getTbObat().getSelectedRow();
            String id = (String) theView.getTbObat().getValueAt(baris, 0);
            try {
                theModel.delete(id);
                theView.getTbObat().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class btnSimpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String id = theView.getTxtID().getText();
                String NamaObat = theView.getTxtNamaObat().getText();
                String Harga = theView.getTxtHarga().getText();
                if (id.isEmpty()) {

                    theModel.save(NamaObat,Harga);

                } else {
                    theModel.update(id, NamaObat, Harga);

                }
                theView.getBtnSimpan().setEnabled(false);
                theView.getTbObat().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
            }
            theView.getTxtID().setText("");
            theView.getTxtNamaObat().setText("");
            theView.getTxtHarga().setText("");
            
        }
    }

    private class btnEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            int baris = theView.getTbObat().getSelectedRow();
            String id = (String) theView.getTbObat().getValueAt(baris, 0);
            String NamaObat = (String) theView.getTbObat().getValueAt(baris, 1);
            String Harga = (String) theView.getTbObat().getValueAt(baris, 2);
            theView.getTxtID().setText(id);
            theView.getTxtNamaObat().setText(NamaObat);
            theView.getTxtHarga().setText(Harga);
            theView.getTxtNamaObat().setEditable(true);
            theView.getTxtHarga().setEditable(true);
            theView.getBtnSimpan().setEnabled(true);

        }
    }

    private class btnBuatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.getTxtNamaObat().setEditable(true);
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
