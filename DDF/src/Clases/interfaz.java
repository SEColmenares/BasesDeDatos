/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.FileReader;
import java.io.BufferedReader;
import java.awt.Container;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jhon_quiceno
 */
public class interfaz extends javax.swing.JFrame {

    /**
     * Creates new form interfaz
     */
    Manejador _manejo;
    Container _cp ;
    public interfaz() {
        initComponents();     
       
//        _manejo.setMarco(getContentPane().getBounds());
        Dibujador _paint = new Dibujador();
        this.sp_diseño.setViewportView(_paint);      
        _manejo = new Manejador(_paint);
        _manejo.setEvento(_eHtext);      
         pack();
    }
    IEventHandler _eHtext = new IEventHandler() {
        @Override
        public void onChange(String imprimir) {
            ta_panel.append("\n"+imprimir);//To change body of generated methods, choose Tools | Templates.
        }
    };
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_panel = new javax.swing.JTextArea();
        tb_diseño = new javax.swing.JToolBar();
        bt_borrar = new javax.swing.JButton();
        bt_leer = new javax.swing.JButton();
        tf_dep = new javax.swing.JTextField();
        bt_recubrimiento = new javax.swing.JButton();
        bt_claves = new javax.swing.JButton();
        tf_claves = new javax.swing.JTextField();
        sp_diseño = new javax.swing.JScrollPane();
        tb_algoritmo = new javax.swing.JToolBar();
        cb_algoritmo = new javax.swing.JComboBox<>();
        bt_aplicar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mb_app = new javax.swing.JMenu();
        mi_abrir = new javax.swing.JMenuItem();
        mi_guardar = new javax.swing.JMenuItem();
        mi_exportar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ta_panel.setEditable(false);
        ta_panel.setBackground(new java.awt.Color(204, 204, 204));
        ta_panel.setColumns(20);
        ta_panel.setRows(5);
        jScrollPane1.setViewportView(ta_panel);

        tb_diseño.setBorder(javax.swing.BorderFactory.createTitledBorder("diseño"));
        tb_diseño.setRollover(true);
        tb_diseño.setMaximumSize(new java.awt.Dimension(144, 28));
        tb_diseño.setMinimumSize(new java.awt.Dimension(144, 28));

        bt_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/borrar.png"))); // NOI18N
        bt_borrar.setToolTipText("borrar");
        bt_borrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_borrarActionPerformed(evt);
            }
        });
        tb_diseño.add(bt_borrar);

        bt_leer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_leer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        bt_leer.setText("A->B");
        bt_leer.setToolTipText("agregar dependencia");
        bt_leer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_leer.setMaximumSize(new java.awt.Dimension(53, 24));
        bt_leer.setMinimumSize(new java.awt.Dimension(55, 24));
        bt_leer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_leerActionPerformed(evt);
            }
        });
        tb_diseño.add(bt_leer);
        bt_leer.getAccessibleContext().setAccessibleName("botonLeerDependencia");

        tf_dep.setMaximumSize(new java.awt.Dimension(60, 24));
        tf_dep.setMinimumSize(new java.awt.Dimension(60, 24));
        tf_dep.setPreferredSize(new java.awt.Dimension(60, 24));
        tb_diseño.add(tf_dep);
        tf_dep.getAccessibleContext().setAccessibleName("textBoxIngresarDependencia");

        bt_recubrimiento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_recubrimiento.setText("R-M");
        bt_recubrimiento.setToolTipText("calcular recubrimiento minimo");
        bt_recubrimiento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_recubrimiento.setMaximumSize(new java.awt.Dimension(32, 24));
        bt_recubrimiento.setMinimumSize(new java.awt.Dimension(32, 24));
        bt_recubrimiento.setPreferredSize(new java.awt.Dimension(32, 24));
        bt_recubrimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_recubrimientoActionPerformed(evt);
            }
        });
        tb_diseño.add(bt_recubrimiento);

        bt_claves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/llave.png"))); // NOI18N
        bt_claves.setToolTipText("calcular llaves candidatas");
        bt_claves.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_claves.setPreferredSize(new java.awt.Dimension(23, 24));
        bt_claves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clavesActionPerformed(evt);
            }
        });
        tb_diseño.add(bt_claves);

        tf_claves.setEditable(false);
        tf_claves.setMaximumSize(new java.awt.Dimension(100, 24));
        tf_claves.setMinimumSize(new java.awt.Dimension(100, 24));
        tf_claves.setPreferredSize(new java.awt.Dimension(100, 24));
        tb_diseño.add(tf_claves);
        tf_claves.getAccessibleContext().setAccessibleName("textBoxClaveCandidata");

        sp_diseño.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tb_algoritmo.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmo"));
        tb_algoritmo.setRollover(true);

        cb_algoritmo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Forma Normal", "3 Forma Normal", "Forma Normal BC", "Proyección" }));
        cb_algoritmo.setMaximumSize(new java.awt.Dimension(150, 24));
        cb_algoritmo.setMinimumSize(new java.awt.Dimension(150, 24));
        cb_algoritmo.setPreferredSize(new java.awt.Dimension(150, 24));
        cb_algoritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_algoritmoActionPerformed(evt);
            }
        });
        tb_algoritmo.add(cb_algoritmo);

        bt_aplicar.setText("Aplicar");
        bt_aplicar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_aplicar.setFocusable(false);
        bt_aplicar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_aplicar.setMaximumSize(new java.awt.Dimension(45, 24));
        bt_aplicar.setMinimumSize(new java.awt.Dimension(45, 24));
        bt_aplicar.setPreferredSize(new java.awt.Dimension(45, 24));
        bt_aplicar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aplicarActionPerformed(evt);
            }
        });
        tb_algoritmo.add(bt_aplicar);

        mb_app.setText("Archivo");

        mi_abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N
        mi_abrir.setText("abrir");
        mi_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_abrirActionPerformed(evt);
            }
        });
        mb_app.add(mi_abrir);

        mi_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        mi_guardar.setText("guardar");
        mi_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_guardarActionPerformed(evt);
            }
        });
        mb_app.add(mi_guardar);

        mi_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/SQL-.png"))); // NOI18N
        mi_exportar.setText("Exportar SQL ....");
        mi_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_exportarActionPerformed(evt);
            }
        });
        mb_app.add(mi_exportar);

        jMenuBar1.add(mb_app);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
            .addComponent(sp_diseño)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tb_diseño, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tb_algoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tb_diseño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tb_algoritmo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_diseño, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_borrarActionPerformed
            // TODO add your handling code here:   
            _manejo.clear();
              pack();
              repaint();
            ta_panel.setText(null);
    }//GEN-LAST:event_bt_borrarActionPerformed

    private void bt_leerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_leerActionPerformed
        // TODO add your handling code here:
        // se van a separar las dependencias por ;, se utiliza la flecha -> como "implicador"
        String texto = tf_dep.getText();
        LectorDependecias lector = new  LectorDependecias();
        List<Dependencias> dependencias = lector.LeerDependencias(texto);

        _manejo.CargarDependencias(dependencias);
        _manejo.Apintar();
        pack();
        repaint();
                ta_panel.setText(null);
      ta_panel.append(_manejo.getDependenciasToString());
      ta_panel.append(System.getProperty("line.separator")); 
    }//GEN-LAST:event_bt_leerActionPerformed

    private void bt_recubrimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_recubrimientoActionPerformed
        // TODO add your handling code here:
        _manejo.recubrimiento();
        ta_panel.setText(null);
        ta_panel.append(_manejo.getDependenciasToString());
        ta_panel.append(System.getProperty("line.separator"));
          pack();
        repaint();// Esto para el salto de línea 
        
    }//GEN-LAST:event_bt_recubrimientoActionPerformed

    private void bt_clavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_clavesActionPerformed
        // TODO add your handling code here:
        tf_claves.setText("");
        List<String> clavesCandidatas = _manejo.CalcularClavesCandidatas();
        tf_claves.setText(String.join(",", clavesCandidatas));
    }//GEN-LAST:event_bt_clavesActionPerformed

    private void mi_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_abrirActionPerformed
        // TODO add your handling code here:
           FileReader f=null ;
        BufferedReader b =null;
    try
   {
   JFileChooser fileChooser = new JFileChooser();
//   FileNameExtensionFilter filter = new FileNameExtensionFilter("csv");
//   fileChooser.setFileFilter(filter);
     String cadena;
     String Json="";
     int result = fileChooser.showOpenDialog(this);
     if (result == JFileChooser.APPROVE_OPTION) {
     File fichero = fileChooser.getSelectedFile();
      f = new FileReader(fichero);
      b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
          Json+=cadena;
      }   
//      _manejo.Exportar();
      _manejo.Cargar(Json);
      _manejo.Apintar();
      ta_panel.setText(null);
      ta_panel.append(_manejo.getDependenciasToString());
      ta_panel.append(System.getProperty("line.separator"));
        pack();
        repaint();// Esto para el salto de línea 

   }
   }
    catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
     }
        finally {

			try {

				if (b != null)
					b.close();

				if (f != null)
					f.close();

			} catch (IOException ex) {

				ex.printStackTrace();

		}
          }
    }//GEN-LAST:event_mi_abrirActionPerformed

    private void mi_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_guardarActionPerformed
        // TODO add your handling code here:
          String aexpo= _manejo.Exportar();
        try
 {
  String nombre="";
  JFileChooser file=new JFileChooser();
  file.showSaveDialog(this);
  File guarda =file.getSelectedFile();
 
  if(guarda !=null)
  {
   /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
    FileWriter  save=new FileWriter(guarda+".JSON");
    save.write(aexpo);
    save.close();
    }
 }
  catch(IOException ex)
  {
   JOptionPane.showMessageDialog(null,
        "Su archivo no se ha guardado",
           "Advertencia",JOptionPane.WARNING_MESSAGE);
  }
    }//GEN-LAST:event_mi_guardarActionPerformed

    private void bt_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aplicarActionPerformed
        // TODO add your handling code here:
        try{
            switch(cb_algoritmo.getSelectedItem().toString()){
                
            case "2 Forma Normal":_manejo.calcular2FN();
                     break;
            case "3 Forma Normal":_manejo.calcular3FN();
                     break;
            case "Forma Normal BC":;
                     break;
            default: 
                     break ;                           
            }
            
            
            
            
            
        }
       catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
     }
    }//GEN-LAST:event_bt_aplicarActionPerformed

    private void mi_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_exportarActionPerformed
        // para crear el script se crea una clase que se encarga de eso y se le pasa todo lo de info.
            FileWriter fw = null;
            StringBuilder contenidoScript = new StringBuilder(); 
            CreadorScripts creador = new CreadorScripts(_manejo.getInfo());
            contenidoScript = creador.CrearContenidoScripts();
            creador.CrearScript(contenidoScript);           
    }//GEN-LAST:event_mi_exportarActionPerformed

    private void cb_algoritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_algoritmoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_algoritmoActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aplicar;
    private javax.swing.JButton bt_borrar;
    private javax.swing.JButton bt_claves;
    private javax.swing.JButton bt_leer;
    private javax.swing.JButton bt_recubrimiento;
    private javax.swing.JComboBox<String> cb_algoritmo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mb_app;
    private javax.swing.JMenuItem mi_abrir;
    private javax.swing.JMenuItem mi_exportar;
    private javax.swing.JMenuItem mi_guardar;
    private javax.swing.JScrollPane sp_diseño;
    private javax.swing.JTextArea ta_panel;
    private javax.swing.JToolBar tb_algoritmo;
    private javax.swing.JToolBar tb_diseño;
    private javax.swing.JTextField tf_claves;
    private javax.swing.JTextField tf_dep;
    // End of variables declaration//GEN-END:variables
}
