/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author S
 */
public class viewTanah extends javax.swing.JFrame {

    /**
     * Creates new form viewKaryawan
     */
    public viewTanah() {
        initComponents();
        setLocationRelativeTo(this);
    }

    public void addBtnBuatListener(ActionListener e) {
        this.btnBuat.addActionListener(e);
    }

    public void addBtnEditListener(ActionListener e) {
        this.btnEdit.addActionListener(e);
    }

    public void addBtnHapusListener(ActionListener e) {
        this.btnHapus.addActionListener(e);
    }

    public void addBtnSimpanListener(ActionListener e) {
        this.btnSimpan.addActionListener(e);
    }

    public JTable getTbTanah() {
        return tbTanah;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public JTextField getTxtJenisTanah() {
        return txtJenisTanah;
    }

    public void addBtnBackListener(ActionListener e) {
        this.btnBack.addActionListener(e);
    }

    public JButton getBtnSimpan() {
        return btnSimpan;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTanah = new javax.swing.JTable();
        btnBuat = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtJenisTanah = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("List Tanah");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        tbTanah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbTanah);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 520, 105));

        btnBuat.setText("Buat Data");
        getContentPane().add(btnBuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        btnEdit.setText("Edit");
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        btnHapus.setText("Hapus");
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        txtID.setEditable(false);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 58, -1));

        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("*Auto Ganerate");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 88, -1));

        txtJenisTanah.setEditable(false);
        getContentPane().add(txtJenisTanah, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 164, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis Tanah");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        btnBack.setText("Kembali");
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg hal spk.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewTanah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewTanah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewTanah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewTanah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewTanah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBuat;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tbTanah;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJenisTanah;
    // End of variables declaration//GEN-END:variables
}
