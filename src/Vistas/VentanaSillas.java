/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ControladorVentanaSillas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.Silla;

/**
 *
 * @author HP
 */
public class VentanaSillas extends javax.swing.JFrame implements ActionListener {

    JButton[][] botones;
    ControladorVentanaSillas controladorSillas;

    /**
     * Creates new form VentanaSillas
     */
    public VentanaSillas() {
        initComponents();
        setLocationRelativeTo(this);
        botones = new JButton[6][6];
        controladorSillas = new ControladorVentanaSillas();
        cargarBotones();
        validarPosiciones();
        generarTablaPersona();
    }
//    

    public ControladorVentanaSillas getControladorSilla() {
        return controladorSillas;
    }

    private void cargarBotones() {
        int alto = 40;
        int ancho = 70;
        int separado = 20;
        int separado2 = 40;
        int separado3 = 60;
        int texto = 1;
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new JButton();
                if (j >= 3 && j < 6) {
                    //dimensiones   //setBounds(posX, posY, ancho, alto)
                    botones[i][j].setBounds( //es la designacion de los limites de cada boton.
                            (j * ancho + separado2),
                            (i * alto + separado),
                            ancho, alto);

                    botones[i][j].addActionListener(this);
                    botones[i][j].setText(String.valueOf("Silla " + texto));
                    panelSillas.add(botones[i][j]);//Para que los botones aparescan en el panel
                    texto++;
                } else if (j >= 6) {

                    //dimensiones   //setBounds(posX, posY, ancho, alto)
                    botones[i][j].setBounds( //es la designacion de los limites de cada boton.
                            (j * ancho + separado3),
                            (i * alto + separado),
                            ancho, alto);

                    botones[i][j].addActionListener(this);
                    botones[i][j].setText(String.valueOf("Silla " + texto));
                    panelSillas.add(botones[i][j]);//Para que los botones aparescan en el panel
                    texto++;

                } else {

                    //dimensiones   //setBounds(posX, posY, ancho, alto)
                    botones[i][j].setBounds( //es la designacion de los limites de cada boton.
                            (j * ancho + separado),
                            (i * alto + separado),
                            ancho, alto);

                    botones[i][j].addActionListener(this);
                    botones[i][j].setText(String.valueOf("Silla " + texto));
                    panelSillas.add(botones[i][j]);//Para que los botones aparescan en el panel
                    texto++;

                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (ae.getSource().equals(botones[i][j])) {
                    Silla silla = controladorSillas.obtenerSilla(i, j);
                    VentanaGestionPersona ventana = new VentanaGestionPersona(this, silla);
                    ventana.setVisible(true);
                    this.dispose();
                }
            }
        }
    }

    /**
     * Método para validar si una posición está ocupada y cambiar su texto por
     * el isbn del libro que allí está guardado. Además de cambiar su color,
     * blanco para casillas disponibles y verde para casillas ocupadas
     */
    public void validarPosiciones() {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                Silla silla = controladorSillas.obtenerSilla(i, j);
                if (silla.isEstado()) {
                    botones[i][j].setBackground(Color.white);
                } else {
                    botones[i][j].setBackground(Color.green);
                }
            }
        }
        generarTablaPersona();
    }

    private void generarTablaPersona() {

        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Nombre", "Email", "Direccion", "Cedula"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < controladorSillas.getListaPersona().Size(); i++) {
            model.addRow(new Object[]{
                controladorSillas.getListaPersona().obtener(i).getNombre(),
                controladorSillas.getListaPersona().obtener(i).getEmail(),
                controladorSillas.getListaPersona().obtener(i).getDireccion(),
                controladorSillas.getListaPersona().obtener(i).getCedula()
            });
        }
        tablaPersonas.setModel(model);
    }

    ;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSillas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        txtidBuscar = new javax.swing.JTextField();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelSillas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teatro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Extra Bold", 1, 15))); // NOI18N

        tablaPersonas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N
        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Email", "Direccion", "Cedula"
            }
        ));
        jScrollPane1.setViewportView(tablaPersonas);

        btnVer.setText("Ver (buscar)");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSillasLayout = new javax.swing.GroupLayout(panelSillas);
        panelSillas.setLayout(panelSillasLayout);
        panelSillasLayout.setHorizontalGroup(
            panelSillasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSillasLayout.createSequentialGroup()
                .addContainerGap(553, Short.MAX_VALUE)
                .addGroup(panelSillasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSillasLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSillasLayout.createSequentialGroup()
                        .addGroup(panelSillasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(166, 166, 166))))
        );
        panelSillasLayout.setVerticalGroup(
            panelSillasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSillasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVer)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSillas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:

        String cedula = txtidBuscar.getText();
        Persona aux = controladorSillas.buscarPersona(cedula);
        if (aux != null) {
            Silla silla = controladorSillas.buscarSilla(cedula);
            VentanaGestionPersona ventanaGestionar = new VentanaGestionPersona(this, silla);
            ventanaGestionar.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró");
            txtidBuscar.setText("");
        }

        limpiarCamposVer();

    }//GEN-LAST:event_btnVerActionPerformed

    public void limpiarCamposVer() {
        txtidBuscar.setText("");

    }
    
    

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
            java.util.logging.Logger.getLogger(VentanaSillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSillas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSillas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelSillas;
    private javax.swing.JTable tablaPersonas;
    private javax.swing.JTextField txtidBuscar;
    // End of variables declaration//GEN-END:variables

}
