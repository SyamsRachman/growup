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
import models.modelHama;
import views.viewHama;

/**
 *
 * @author S
 */
public class HamaController {

    viewHama theView = new viewHama();
    modelHama theModel = new modelHama();

    public HamaController() {
        theView.setVisible(true);
        theView.addBtnBackListener(new btnBackListener());
        theView.addBtnBuatListener(new btnBuatListener());
        theView.addBtnSimpanListener(new btnSimpanListener());
        theView.addBtnEditListener(new btnEditListener());
        theView.addBtnHapusListener(new btnHapusListener());
        try {
            theView.getTbHama().setModel(theModel.getTableModel());
        } catch (SQLException ex) {
            Logger.getLogger(HamaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class btnHapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int baris = theView.getTbHama().getSelectedRow();
            String id = (String) theView.getTbHama().getValueAt(baris, 0);
            try {
                theModel.delete(id);
                theView.getTbHama().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(HamaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class btnSimpanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String id = theView.getTxtID().getText();
                String NamaHama = theView.getTxtNamaHama().getText();
                if (id.isEmpty()) {

                    theModel.save(NamaHama);

                } else {
                    theModel.update(id, NamaHama);

                }
                theView.getBtnSimpan().setEnabled(false);
                theView.getTbHama().setModel(theModel.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(HamaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            theView.getTxtID().setText("");
            theView.getTxtNamaHama().setText("");
            
        }
    }

    private class btnEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            int baris = theView.getTbHama().getSelectedRow();
            String id = (String) theView.getTbHama().getValueAt(baris, 0);
            String NamaHama = (String) theView.getTbHama().getValueAt(baris, 1);
            theView.getTxtID().setText(id);
            theView.getTxtNamaHama().setText(NamaHama);
            theView.getTxtNamaHama().setEditable(true);
            theView.getBtnSimpan().setEnabled(true);

        }
    }

    private class btnBuatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.getTxtNamaHama().setEditable(true);
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
