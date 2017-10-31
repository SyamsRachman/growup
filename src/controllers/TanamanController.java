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
import models.modelTanaman;
import views.viewTanaman;

/**
 *
 * @author S
 */
public class TanamanController {

    viewTanaman theView = new viewTanaman();
    modelTanaman theModel = new modelTanaman();

    public TanamanController() {
        theView.setVisible(true);
        theView.addBtnBackListener(new btnBackListener());
        theView.addBtnBuatListener(new btnBuatListener());
        theView.addBtnSimpanListener(new btnSimpanListener());
        theView.addBtnEditListener(new btnEditListener());
        theView.addBtnHapusListener(new btnHapusListener());
        try {
            theView.getTbTanaman().setModel(theModel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(TanamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class btnHapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int baris = theView.getTbTanaman().getSelectedRow();
            String id = (String) theView.getTbTanaman().getValueAt(baris, 0);
            try {
                theModel.delete(id);
                theView.getTbTanaman().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(TanamanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class btnSimpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String id = theView.getTxtID().getText();
                String JenisTanaman = theView.getTxtJenisTanaman().getText();
                if (id.isEmpty()) {

                    theModel.save(JenisTanaman);

                } else {
                    theModel.update(id, JenisTanaman);

                }
                theView.getBtnSimpan().setEnabled(false);
                theView.getTbTanaman().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(TanamanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            theView.getTxtID().setText("");
            theView.getTxtJenisTanaman().setText("");
            
        }
    }

    private class btnEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            int baris = theView.getTbTanaman().getSelectedRow();
            String id = (String) theView.getTbTanaman().getValueAt(baris, 0);
            String JenisTanaman = (String) theView.getTbTanaman().getValueAt(baris, 1);
            theView.getTxtID().setText(id);
            theView.getTxtJenisTanaman().setText(JenisTanaman);
            theView.getTxtJenisTanaman().setEditable(true);
            theView.getBtnSimpan().setEnabled(true);

        }
    }

    private class btnBuatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.getTxtJenisTanaman().setEditable(true);
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
