package View.Panels;

import Entities.Client;
import Entities.Reservation;
import Entities.Table;
import View.MainFrame;
import com.mycompany.code.jdbc.DAOs;
import com.mycompany.code.jdbc.DBConnection;
import static com.mycompany.code.jdbc.DBConnection.mainFrame;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Reservations extends javax.swing.JPanel {

    public MaskFormatter dateMask, phoneMask;
    private final String EMAIL_REGEX = "^(?!.*\\.\\.)[A-Za-z0-9_]+(?:\\.[A-Za-z0-9_]+)*@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*$";
    private DefaultComboBoxModel<String> hoursModel;
    private DefaultComboBoxModel<String> tablesModel;
    private DefaultComboBoxModel<String> numPeopleModel;
    private LocalDate date;

    public Reservations() {
        assignMaskFormat();
        initComponents();
        initComboBoxes();
    }

    public void assignMaskFormat() {
        try {
            this.dateMask = new MaskFormatter("##/##/####");
            this.phoneMask = new MaskFormatter("(##)#####-####");

        } catch (ParseException ex) {
            Logger.getLogger(Reservations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public boolean isAValidDate(LocalDate dateChecked) {
        boolean isValid = false;

        if (dateChecked.isAfter(LocalDate.now()) || dateChecked.equals(LocalDate.now())) {
            isValid = true;
        }

        return isValid;
    }

    public void clearForm() {
        tfClient.setText("");
        tfEmail.setText("");
        ftfPhone.setText("");
        ftfDate.setText("");
    }

    public void initComboBoxes() {

        try {
            DAOs daoObj = new DAOs(DBConnection.connection);
            ArrayList<Table> tables = daoObj.getTables();

            tablesModel = new DefaultComboBoxModel();

            for (Table table : tables) {
                tablesModel.addElement(String.valueOf(table.getNumber()));
            }

            cbTable.setModel(tablesModel);
        } catch (SQLException ex) {
            Logger.getLogger(Reservations.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] numPeoples = {"1", "2", "3", "4", "5", "6", "7", "8"};

        numPeopleModel = new DefaultComboBoxModel(numPeoples);
        cbNumPeople.setModel(numPeopleModel);

        String[] hours = {"8h00", "9h30", "11h00", "12h30", "14h00",
            "15h30", "17h00", "18h30", "20h00", "21h30"};

        hoursModel = new DefaultComboBoxModel(hours);
        cbTime.setModel(hoursModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbReservation = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbMenu = new javax.swing.JLabel();
        lbConfirm = new javax.swing.JLabel();
        lbClean = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        lbDay = new javax.swing.JLabel();
        lbTable = new javax.swing.JLabel();
        lbNumPeople = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        lbClient = new javax.swing.JLabel();
        lbCancel = new javax.swing.JLabel();
        ftfPhone = new javax.swing.JFormattedTextField(phoneMask);
        ftfDate = new javax.swing.JFormattedTextField(dateMask);
        tfEmail = new javax.swing.JTextField();
        cbTable = new javax.swing.JComboBox<>();
        cbNumPeople = new javax.swing.JComboBox<>();
        cbTime = new javax.swing.JComboBox<>();
        tfClient = new javax.swing.JTextField();
        lbBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbReservation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lbReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 110, 16));

        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomeMouseClicked(evt);
            }
        });
        add(lbHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 60, 69, 16));

        lbMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuMouseClicked(evt);
            }
        });
        add(lbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 60, 113, 16));

        lbConfirm.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbConfirm.setForeground(new java.awt.Color(255, 255, 255));
        lbConfirm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_confirm.png"))); // NOI18N
        lbConfirm.setText("CONFIRMAR");
        lbConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbConfirmMouseClicked(evt);
            }
        });
        add(lbConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 491, 322, 65));

        lbClean.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbClean.setForeground(new java.awt.Color(255, 255, 255));
        lbClean.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_clean.png"))); // NOI18N
        lbClean.setText("LIMPAR");
        lbClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCleanMouseClicked(evt);
            }
        });
        add(lbClean, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 321, 322, 65));

        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_clock.png"))); // NOI18N
        add(lbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 406, -1, 39));

        lbDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_date.png"))); // NOI18N
        add(lbDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 406, -1, 39));

        lbTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_table.png"))); // NOI18N
        add(lbTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 484, -1, 39));

        lbNumPeople.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumPeople.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_people.png"))); // NOI18N
        add(lbNumPeople, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 485, -1, 39));

        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_email.png"))); // NOI18N
        add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, 36));

        lbPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_phone.png"))); // NOI18N
        add(lbPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 327, -1, 39));

        lbClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_name.png"))); // NOI18N
        add(lbClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, 39));

        lbCancel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbCancel.setForeground(new java.awt.Color(255, 255, 255));
        lbCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Icons/ic_cancel.png"))); // NOI18N
        lbCancel.setText("CANCELAR");
        lbCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCancelMouseClicked(evt);
            }
        });
        add(lbCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 406, 322, 65));

        ftfPhone.setBackground(new java.awt.Color(153, 153, 153));
        ftfPhone.setBorder(null);
        ftfPhone.setForeground(new java.awt.Color(0, 0, 0));
        add(ftfPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 327, 570, 38));

        ftfDate.setBackground(new java.awt.Color(153, 153, 153));
        ftfDate.setBorder(null);
        ftfDate.setForeground(new java.awt.Color(0, 0, 0));
        add(ftfDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 406, 220, 38));

        tfEmail.setBackground(new java.awt.Color(153, 153, 153));
        tfEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(0, 0, 0));
        tfEmail.setBorder(null);
        add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 570, 38));

        cbTable.setBackground(new java.awt.Color(153, 153, 153));
        cbTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTable.setForeground(new java.awt.Color(0, 0, 0));
        cbTable.setBorder(null);
        add(cbTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 485, 220, 38));

        cbNumPeople.setBackground(new java.awt.Color(153, 153, 153));
        cbNumPeople.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbNumPeople.setForeground(new java.awt.Color(0, 0, 0));
        cbNumPeople.setBorder(null);
        add(cbNumPeople, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 485, 220, 38));

        cbTime.setBackground(new java.awt.Color(153, 153, 153));
        cbTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTime.setForeground(new java.awt.Color(0, 0, 0));
        cbTime.setBorder(null);
        add(cbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 406, 220, 38));

        tfClient.setBackground(new java.awt.Color(153, 153, 153));
        tfClient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfClient.setForeground(new java.awt.Color(0, 0, 0));
        tfClient.setBorder(null);
        add(tfClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 171, 570, 38));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Backgrounds/bg_reservation.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked
        MainFrame.jPHome = new Home();
        mainFrame.initNewPanel(MainFrame.jPHome);
    }//GEN-LAST:event_lbHomeMouseClicked

    private void lbMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuMouseClicked
        MainFrame.jPMenu = new Menu();
        mainFrame.initNewPanel(MainFrame.jPMenu);
    }//GEN-LAST:event_lbMenuMouseClicked

    private void lbConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConfirmMouseClicked
        String msg = "";
        String nameTxt = tfClient.getText();
        String emailTxt = tfEmail.getText();
        String phoneTxt = ftfPhone.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateTxt = ftfDate.getText();

        String timeTxt = (String) cbTime.getSelectedItem();
        String tableTxt = (String) cbTable.getSelectedItem();
        System.out.println(tableTxt);
        String numPeopleTxt = (String) cbNumPeople.getSelectedItem();

        if (!nameTxt.equals("") && !emailTxt.equals("") && !phoneTxt.equals("") && !dateTxt.equals("")
                && !timeTxt.equals("") && !tableTxt.equals("") && !numPeopleTxt.equals("")) {

            try {
                DAOs daoObj = new DAOs(DBConnection.connection);
                Client client = new Client(nameTxt, emailTxt, phoneTxt);
                
                int idClient = daoObj.createNewClient(client);
                client.setId(idClient);

                this.date = LocalDate.parse(dateTxt, formatter);

                if (isAValidDate(this.date) && isValidEmail(emailTxt)) {

                    String[] parts = timeTxt.split("h");
                    int hour = Integer.parseInt(parts[0]);
                    int minutes = Integer.parseInt(parts[1]);

                    int tableNum = Integer.parseInt(tableTxt);

                    Table table = null;
                    ArrayList<Table> tables = daoObj.getTables();

                    for (Table t : tables) {
                        if (t.getNumber() == tableNum) {
                            table = t;
                            break;
                        }
                    }
                    
                    int numPeople = Integer.parseInt(numPeopleTxt);

                    if (numPeople > table.getCapactity()) {
                        msg = """
                            O número de pessoas selecionado excede a capacidade da mesa!
                            Por favor, selecione uma mesa maior ou diminua o número de pessoas.
                            """;
                        JOptionPane.showMessageDialog(null, msg, "Capacidade Excedida", JOptionPane.WARNING_MESSAGE);

                    } else {
                        LocalDate localDate = LocalDate.parse(this.date.toString());
                        System.out.println(localDate);
                        
                        Date sqlDate = Date.valueOf(localDate);
                        System.out.println(sqlDate);

                        Reservation reservation = new Reservation(sqlDate, hour, minutes, client, table, numPeople);
                        reservation.setClientId(client);
                        reservation.setTableId(table);
                        System.out.println(reservation.getTableId());
                        int success = daoObj.insertReservation(reservation);

                        if (success == 1) {
                            msg = """
                                Reserva cadastrada com sucesso!
                                """;
                            JOptionPane.showMessageDialog(null, msg, "Reserva concluída com sucesso", JOptionPane.INFORMATION_MESSAGE);
                        }

                        if (success == 0) {
                            msg = """
                                Infelizmente já possuimos uma reserva da mesa para o horário selecionado.
                                Tente novamente em outro horário, ou, em outra mesa se preferir.
                                """;
                            JOptionPane.showMessageDialog(null, msg, "Falha ao realizar a reserva", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        clearForm();

                    }

                }

                if (!isAValidDate(this.date)) {
                    msg = """
                    É necessário uma data válida para o cadastro da reserva!
                    """;
                    JOptionPane.showMessageDialog(null, msg, "Data Inválida", JOptionPane.WARNING_MESSAGE);
                }

                if (!isValidEmail(emailTxt)) {
                    msg = """
                    É necessário um email válido para o cadastro da reserva!
                    """;
                    JOptionPane.showMessageDialog(null, msg, "Data Inválida", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Reservations.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            msg = """
                É necessário preencher todos os campos para o cadastro da reserva!
                """;
            JOptionPane.showMessageDialog(null, msg, "Dados incompletos", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_lbConfirmMouseClicked

    private void lbCleanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCleanMouseClicked
        clearForm();
    }//GEN-LAST:event_lbCleanMouseClicked

    private void lbCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelMouseClicked
        String msg = "";
        String nameTxt = tfClient.getText();
        String emailTxt = tfEmail.getText();
        String phoneTxt = ftfPhone.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateTxt = ftfDate.getText();

        String timeTxt = (String) cbTime.getSelectedItem();
        String tableTxt = (String) cbTable.getSelectedItem();
        System.out.println(tableTxt);
        String numPeopleTxt = (String) cbNumPeople.getSelectedItem();

        if (!nameTxt.equals("") && !emailTxt.equals("") && !phoneTxt.equals("") && !dateTxt.equals("")
                && !timeTxt.equals("") && !tableTxt.equals("") && !numPeopleTxt.equals("")) {

            try {
                DAOs daoObj = new DAOs(DBConnection.connection);
                Client client = daoObj.getClientByInfo(nameTxt, emailTxt, phoneTxt);

                this.date = LocalDate.parse(dateTxt, formatter);

                if (isAValidDate(this.date) && isValidEmail(emailTxt)) {

                    String[] parts = timeTxt.split("h");
                    int hour = Integer.parseInt(parts[0]);
                    int minutes = Integer.parseInt(parts[1]);

                    int tableNum = Integer.parseInt(tableTxt);

                    Table table = null;
                    ArrayList<Table> tables = daoObj.getTables();

                    for (Table t : tables) {
                        if (t.getNumber() == tableNum) {
                            table = t;
                            break;
                        }
                    }
                    
                    int numPeople = Integer.parseInt(numPeopleTxt);

                    if (numPeople > table.getCapactity()) {
                        msg = """
                            O número de pessoas selecionado excede a capacidade da mesa!
                            Por favor, selecione uma mesa maior ou diminua o número de pessoas.
                            """;
                        JOptionPane.showMessageDialog(null, msg, "Capacidade Excedida", JOptionPane.WARNING_MESSAGE);

                    } else {
                        LocalDate localDate = LocalDate.parse(this.date.toString());
                        System.out.println(localDate);
                        
                        Date sqlDate = Date.valueOf(localDate);
                        System.out.println(sqlDate);

                        Reservation reservation = new Reservation(sqlDate, hour, minutes, client, table, numPeople);
                        reservation.setTableId(table);
                        reservation.setClientId(client);
                        int success = daoObj.cancelReservation(reservation);

                        if (success == 1) {
                            msg = """
                                Reserva removida com sucesso!
                                """;
                            JOptionPane.showMessageDialog(null, msg, "Reserva removida com sucesso", JOptionPane.INFORMATION_MESSAGE);
                        }

                        if (success == 0) {
                            msg = """
                                Não encontramos a reserva. Revise os dados e tente novamente.
                                """;
                            JOptionPane.showMessageDialog(null, msg, "Falha ao encontrar a reserva", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        clearForm();
                    }

                }

                if (!isAValidDate(this.date)) {
                    msg = """
                    É necessário uma data válida para o cadastro da reserva!
                    """;
                    JOptionPane.showMessageDialog(null, msg, "Data Inválida", JOptionPane.WARNING_MESSAGE);
                }

                if (!isValidEmail(emailTxt)) {
                    msg = """
                    É necessário um email válido para o cadastro da reserva!
                    """;
                    JOptionPane.showMessageDialog(null, msg, "Data Inválida", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Reservations.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            msg = """
                É necessário preencher todos os campos para o cadastro da reserva!
                """;
            JOptionPane.showMessageDialog(null, msg, "Dados incompletos", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lbCancelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbNumPeople;
    private javax.swing.JComboBox<String> cbTable;
    private javax.swing.JComboBox<String> cbTime;
    private javax.swing.JFormattedTextField ftfDate;
    private javax.swing.JFormattedTextField ftfPhone;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbClean;
    private javax.swing.JLabel lbClient;
    private javax.swing.JLabel lbConfirm;
    private javax.swing.JLabel lbDay;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbNumPeople;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbReservation;
    private javax.swing.JLabel lbTable;
    private javax.swing.JLabel lbTime;
    private javax.swing.JTextField tfClient;
    private javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
}
