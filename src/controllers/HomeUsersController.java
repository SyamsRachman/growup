/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.viewHomeUsers;

/**
 *
 * @author S
 */
public class HomeUsersController {

    viewHomeUsers theView = new viewHomeUsers();

    public HomeUsersController() {
        theView.setVisible(true);
        theView.addBtnPupukListener(new btnPupukListener());
        theView.addBtnKeluarListener(new btnKeluarListener());
        theView.addBtnObatListener(new btnObatListener());
    }

    private class btnObatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            SppkObatController control = new SppkObatController();
        }
    }

    private class btnKeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            theView.dispose();
            LoginController control = new LoginController();
        }

    }

    private class btnPupukListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           theView.dispose();
           SppkPupukController control = new SppkPupukController();
        }
    }

}
