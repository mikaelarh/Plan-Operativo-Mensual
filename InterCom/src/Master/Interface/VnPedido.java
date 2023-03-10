/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Master.Interface;

import Conexion.conexion;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperExportManager;

/**
 *
 * @author Mikaela Estefania Ramirez Herrera <Estefania_mikaela@hotmail.com>
 */
public class VnPedido extends javax.swing.JFrame {

    /**
     * Creates new form VmPedido
     */
    public VnPedido() {
        initComponents();
        observaciones.setLineWrap(true);
        cargar();
        folio.setText(String.valueOf(GetFolio()));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximizado
        this.toFront();
        this.getContentPane().setBackground(Color.white);
    }
    DefaultTableModel model;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    private static int id;
    private static String Nombre = "";
    private static String Numero = "";
    Date date = new Date();
    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    Calendar c = Calendar.getInstance();
    int annio = c.get(Calendar.YEAR);
    int mes = c.get(Calendar.MONTH) + 1;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        VnPedido.id = id;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        VnPedido.Nombre = Nombre;
    }

    public static String getNumero() {
        return Numero;
    }

    public static void setNumero(String Numero) {
        VnPedido.Numero = Numero;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabCliente = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        modelo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        serie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        producto = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        servicio = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        folio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        garantia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Nuevo Pedido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descripcion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        observaciones.setColumns(20);
        observaciones.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        observaciones.setRows(5);
        jScrollPane1.setViewportView(observaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 620, 60));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 640, -1, -1));

        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscarKeyTyped(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 150, -1));

        TabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono"
            }
        ));
        TabCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabCliente);
        if (TabCliente.getColumnModel().getColumnCount() > 0) {
            TabCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 620, 120));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Observaciones:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        descripcion.setRows(5);
        jScrollPane3.setViewportView(descripcion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 620, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Producto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Marca:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));
        jPanel1.add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 170, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Folio:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 40, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("N?? de Serie (opcional):");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 160, -1));
        jPanel1.add(serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 160, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Buscar Cliente:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, -1, -1));
        jPanel1.add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 160, -1));

        servicio.setColumns(20);
        servicio.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        servicio.setRows(5);
        jScrollPane4.setViewportView(servicio);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 620, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Servicio Solicitado:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Modelo:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));
        jPanel1.add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 180, -1));

        folio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        folio.setText("Folio");
        jPanel1.add(folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Garantia:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        garantia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin Garantia", "1 Mes", "2 Meses", "3 Meses" }));
        jPanel1.add(garantia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 90, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 800, 650));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        jPanel2.add(jPanel1, gridBagConstraints);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (producto.getText().equals("") || marca.getText().equals("") || modelo.getText().equals("") || servicio.getText().equals("") || descripcion.getText().equals("") || observaciones.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta Rellenar Datos");
        } else {
            if (getNombre().equals("")) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado un cliente");
            } else {
                if (JOptionPane.showConfirmDialog(null, "Revise bien su informacion\n"
                        + "antes de enviarla\n"
                        + "??Desea Continuar?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Guardar_Reporte();
                } else {
                    JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void BuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyPressed

    }//GEN-LAST:event_BuscarKeyPressed

    private void TabClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabClienteMouseClicked
        int fil = TabCliente.getSelectedRow();
        if (fil >= 0) {
            setId(Integer.parseInt(TabCliente.getValueAt(fil, 0).toString()));
            setNombre(TabCliente.getValueAt(fil, 1).toString());
            setNumero(TabCliente.getValueAt(fil, 2).toString());
            JOptionPane.showMessageDialog(null, TabCliente.getValueAt(fil, 1).toString() + " seleccionado");
        }
    }//GEN-LAST:event_TabClienteMouseClicked

    private void BuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyTyped
        cargar();
    }//GEN-LAST:event_BuscarKeyTyped

    void cargar() {
        clean();
        String[] registros = new String[5];
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM clientes where Nombre LIKE '" + Buscar.getText() + "%" + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("id_Cliente");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Telefono");
                registros[3] = rs.getString("Direccion");
                model.addRow(registros);
            }
            TabCliente.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void clean() {
        model = ((DefaultTableModel) TabCliente.getModel());
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void Guardar_pedido() {
        try {
            con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `pendientes` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, getIdPedido());
            ps.setInt(2, Integer.parseInt(folio.getText()));
            ps.setString(3, df2.format(date));
            ps.setString(4, descripcion.getText());
            ps.setString(5, observaciones.getText());
            ps.setInt(6, getId());
            ps.setInt(7, 0);
            ps.setString(8, producto.getText());
            ps.setString(9, marca.getText());
            ps.setString(10, modelo.getText());
            ps.setString(11, serie.getText());
            ps.setInt(12, mes);
            ps.setInt(13, annio);
            ps.setString(14, servicio.getText());
            ps.setString(15, garantia.getSelectedItem().toString());
            int res = ps.executeUpdate();
            if (res > 0) {
                setFolio();
            } else {
                JOptionPane.showMessageDialog(null, "Folio duplicado");
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "Revisar el folio");
        }
    }

    private void Guardar_Reporte() {
        try {
            con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `reporte` VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 1);
            ps.setString(2, getNombre());
            ps.setString(3, getNumero());
            ps.setString(4, producto.getText());
            ps.setString(5, modelo.getText());
            ps.setString(6, marca.getText());
            ps.setString(7, serie.getText());
            ps.setString(8, servicio.getText());
            ps.setString(9, descripcion.getText());
            ps.setString(10, observaciones.getText());
            ps.setInt(11, Integer.parseInt(folio.getText()));
            int res = ps.executeUpdate();
            if (res > 0) {
                con.close();
                PrintReport();
            } else {
                JOptionPane.showMessageDialog(null, "Folio duplicado");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void PrintReport() throws Exception {
        JasperPrint jasperPrint;
        try {
            con = conexion.getConnection();
            JasperReport reporte = null;
            File fichero = new File("src\\Recursos");
            String Ruta = "src\\Recursos\\Intercom.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(Ruta);
            Map HM = new HashMap();
            HM.put("path", fichero.getAbsolutePath());
            jasperPrint = JasperFillManager.fillReport(reporte, HM , con);
            JFileChooser archivo = new JFileChooser();
            archivo.setSelectedFile(new File("Hoja de diagnostico"));
            archivo.setFileFilter(new FileNameExtensionFilter("Archivo en formato PDF", "PDF"));
            int opcion = archivo.showSaveDialog(null);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                String ruta = archivo.getSelectedFile().getAbsolutePath() + ".pdf";
                JasperExportManager.exportReportToPdfFile(jasperPrint, ruta);
                con.close();
                Desktop.getDesktop().open(new File(ruta));
                DelReporte();
                JOptionPane.showMessageDialog(null, "Pedido Generado con exito con folio " + folio.getText());
                Guardar_pedido();
            } else {
                JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                DelReporte();
            }
        } catch (JRException | IOException ex) {
            System.out.println(ex);
        }
    }

    private void Clear() {
        descripcion.setText("");
        observaciones.setText("");
        Buscar.setText("");
    }

    private int GetFolio() {
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement("SELECT Folio FROM folio where id =1");
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Folio") + 1;
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    private int getIdPedido() {
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement("SELECT `id_Pedido` FROM `pendientes` ORDER BY `id_Pedido` DESC LIMIT 1");
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_Pedido") + 1;
            }
            con.close();
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 1;
    }

    public void DelReporte() {
        try {
            con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM reporte WHERE Id=1");
            int res = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("error en Actividad" + ex);
        }
    }

    private void setFolio() {
        try {
            con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE folio SET Folio=Folio+1 WHERE Id=1");
            int res = ps.executeUpdate();
            if (res > 0) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Folio duplicado");
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
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
            java.util.logging.Logger.getLogger(VnPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VnPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VnPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VnPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new VnPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTable TabCliente;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel folio;
    private javax.swing.JComboBox<String> garantia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField modelo;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JTextField producto;
    private javax.swing.JTextField serie;
    private javax.swing.JTextArea servicio;
    // End of variables declaration//GEN-END:variables
}
