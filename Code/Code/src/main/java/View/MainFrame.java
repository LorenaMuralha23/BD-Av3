package View;

import View.Panels.Home;
import View.Panels.Menu;
import View.Panels.Reservations;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame {

    public static Home jPHome;
    public static Menu jPMenu;
    public static Reservations jPReservations;
        
    public MainFrame() {
        initComponents();
    }

    public void starting() {
        this.setLayout(new BorderLayout());

        jPHome = new Home();
        initNewPanel(jPHome);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initNewPanel(JPanel newJPanel) {
        this.getContentPane().removeAll();
        this.add(newJPanel, BorderLayout.CENTER);
        this.pack();
    }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
