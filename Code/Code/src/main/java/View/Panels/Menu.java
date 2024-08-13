package View.Panels;

import View.MainFrame;
import static com.mycompany.code.jdbc.DBConnection.mainFrame;

public class Menu extends javax.swing.JPanel {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbReservation = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbMenu = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbReservation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReservationMouseClicked(evt);
            }
        });
        add(lbReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 110, 16));

        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomeMouseClicked(evt);
            }
        });
        add(lbHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 60, 69, 16));

        lbMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 60, 113, 16));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Backgrounds/bg_menu.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void lbReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReservationMouseClicked
        MainFrame.jPReservations = new Reservations();
        mainFrame.initNewPanel(MainFrame.jPReservations);
    }//GEN-LAST:event_lbReservationMouseClicked

    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked
        MainFrame.jPHome = new Home();
        mainFrame.initNewPanel(MainFrame.jPHome);
    }//GEN-LAST:event_lbHomeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbReservation;
    // End of variables declaration//GEN-END:variables
}
