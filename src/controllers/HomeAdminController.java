/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.viewHomeAdmin;

/**
 *
 * @author S
 */
public class HomeAdminController {

    viewHomeAdmin theView = new viewHomeAdmin();

    public HomeAdminController() {
        theView.setVisible(true);
        theView.addBtnKaryawanListener(new btnKaryawanListener());
        theView.addBtnKeluarListener(new btnKeluarListener());
        theView.addBtnListPupukListener(new btnListPupuk());
        theView.addBtnListObatListener(new btnListObatListener());
        theView.addBtnListTanamanListener(new btnListTanaman());
        theView.addBtnListTanahListener(new btnListTanahListener());
        theView.addBtnListHamaListener(new btnHamaListener());
        theView.addBtnDetailPupukListener(new btnDetailPupukListener());
        theView.addBtnDetailObatListener(new btnDetailObatListener());
    }

    private class btnDetailPupukListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            DetailPupukController control = new DetailPupukController();
        }

    }

    private class btnDetailObatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            DetailObatController control = new DetailObatController();
        }

    }

    private class btnHamaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            HamaController control = new HamaController();
        }
    }

    private class btnListTanahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           theView.dispose();
           TanahController control = new TanahController();
        }
    }

    private class btnListTanaman implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            TanamanController control = new TanamanController();
        }
    }

    private class btnListObatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            ObatController control = new ObatController();
        }
    }

    private class btnListPupuk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            PupukController control = new PupukController();
        }
    }

    private class btnKeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            LoginController control = new LoginController();
        }
    }

    private class btnKaryawanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            KaryawanController control = new KaryawanController();
        }
    }

    

}
