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
import models.modelTanah;
import views.viewTanah;

/**
 *
 * @author S
 */
public class TanahController {

    viewTanah theView = new viewTanah();
    modelTanah theModel = new modelTanah();

    public TanahController() {
        theView.setVisible(true);
        theView.addBtnBackListener(new btnBackListener());
        theView.addBtnBuatListener(new btnBuatListener());
        theView.addBtnSimpanListener(new btnSimpanListener());
        theView.addBtnEditListener(new btnEditListener());
        theView.addBtnHapusListener(new btnHapusListener());
        try {
            theView.getTbTanah().setModel(theModel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(TanahController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class btnHapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int baris = theView.getTbTanah().getSelectedRow();
            String id = (String) theView.getTbTanah().getValueAt(baris, 0);
            try {
                theModel.delete(id);
                theView.getTbTanah().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(TanahController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class btnSimpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String id = theView.getTxtID().getText();
                String JenisTanah = theView.getTxtJenisTanah().getText();
                if (id.isEmpty()) {

                    theModel.save(JenisTanah);

                } else {
                    theModel.update(id, JenisTanah);

                }
                theView.getBtnSimpan().setEnabled(false);
                theView.getTbTanah().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(TanahController.class.getName()).log(Level.SEVERE, null, ex);
            }
            theView.getTxtID().setText("");
            theView.getTxtJenisTanah().setText("");
            
        }
    }

    private class btnEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            int baris = theView.getTbTanah().getSelectedRow();
            String id = (String) theView.getTbTanah().getValueAt(baris, 0);
            String JenisTanaman = (String) theView.getTbTanah().getValueAt(baris, 1);
            theView.getTxtID().setText(id);
            theView.getTxtJenisTanah().setText(JenisTanaman);
            theView.getTxtJenisTanah().setEditable(true);
            theView.getBtnSimpan().setEnabled(true);

        }
    }

    private class btnBuatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.getTxtJenisTanah().setEditable(true);
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
