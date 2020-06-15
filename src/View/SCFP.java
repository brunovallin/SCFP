/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;

/**
 *
 * @author rodri
 */
public class SCFP extends javax.swing.JFrame {

    /**
     * Creates new form SCFP
     */
    public SCFP() {
        initComponents();
        comboDescLog.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeVisitanteLog = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rgVisitanteLog = new javax.swing.JTextField();
        comboDescLog = new javax.swing.JComboBox<>();
        botBuscaVisitanteLog = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalheVisitanteLog = new javax.swing.JTextArea();
        nomeMoradorLog = new javax.swing.JTextField();
        blocoMoradorLog = new javax.swing.JTextField();
        numeroApartamentoLog = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        botBuscaMoradorLog = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridLog = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadastroVisitante = new javax.swing.JMenuItem();
        menuCadastroMorador = new javax.swing.JMenuItem();
        menuCadastroFuncionario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Visitante");

        jLabel2.setText("Descrição");

        jLabel3.setText("Morador");

        nomeVisitanteLog.setForeground(new java.awt.Color(204, 204, 204));
        nomeVisitanteLog.setText("Nome");
        nomeVisitanteLog.setName("nomeVisitanteLog"); // NOI18N
        nomeVisitanteLog.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        nomeVisitanteLog.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeVisitanteLogFocusLost(evt);
            }
        });
        nomeVisitanteLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomeVisitanteLogMouseClicked(evt);
            }
        });

        jLabel4.setText("RG");

        rgVisitanteLog.setName("rgVisitanteLog"); // NOI18N

        comboDescLog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Visitante", "Prestador de Serviço" }));
        comboDescLog.setActionCommand("visitanteDescricaolog");
        comboDescLog.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDescLogItemStateChanged(evt);
            }
        });

        botBuscaVisitanteLog.setText("Buscar");
        botBuscaVisitanteLog.setActionCommand("buscarRgVisitante");
        botBuscaVisitanteLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botBuscaVisitanteLogActionPerformed(evt);
            }
        });

        detalheVisitanteLog.setColumns(20);
        detalheVisitanteLog.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        detalheVisitanteLog.setForeground(new java.awt.Color(204, 204, 204));
        detalheVisitanteLog.setRows(5);
        detalheVisitanteLog.setText("Descrição de serviço");
        detalheVisitanteLog.setName("campoDescriçãoServico"); // NOI18N
        detalheVisitanteLog.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                detalheVisitanteLogFocusLost(evt);
            }
        });
        detalheVisitanteLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detalheVisitanteLogMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(detalheVisitanteLog);

        nomeMoradorLog.setForeground(new java.awt.Color(204, 204, 204));
        nomeMoradorLog.setText("Nome");
        nomeMoradorLog.setName("nomeMoradorLog"); // NOI18N
        nomeMoradorLog.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeMoradorLogFocusLost(evt);
            }
        });
        nomeMoradorLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomeMoradorLogMouseClicked(evt);
            }
        });

        blocoMoradorLog.setForeground(new java.awt.Color(204, 204, 204));
        blocoMoradorLog.setText("Bloco");
        blocoMoradorLog.setName("blocoMoradorLog"); // NOI18N
        blocoMoradorLog.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                blocoMoradorLogFocusLost(evt);
            }
        });
        blocoMoradorLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blocoMoradorLogMouseClicked(evt);
            }
        });

        numeroApartamentoLog.setForeground(new java.awt.Color(204, 204, 204));
        numeroApartamentoLog.setText("Nº Apartamento");
        numeroApartamentoLog.setName("numeroApartamentoLog"); // NOI18N
        numeroApartamentoLog.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numeroApartamentoLogFocusLost(evt);
            }
        });
        numeroApartamentoLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numeroApartamentoLogMouseClicked(evt);
            }
        });

        jButton2.setText("Ok");
        jButton2.setActionCommand("okLog");

        botBuscaMoradorLog.setText("Buscar Morador");
        botBuscaMoradorLog.setActionCommand("buscarMoradorLog");

        gridLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Visitante", "Descrição", "Data de Entrada", "Morador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        gridLog.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        gridLog.setName("gridLog"); // NOI18N
        jScrollPane2.setViewportView(gridLog);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botBuscaMoradorLog)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(nomeVisitanteLog, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(numeroApartamentoLog)
                                                .addComponent(blocoMoradorLog)
                                                .addComponent(nomeMoradorLog)))))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDescLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rgVisitanteLog, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botBuscaVisitanteLog))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeVisitanteLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rgVisitanteLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botBuscaVisitanteLog))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboDescLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nomeMoradorLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(blocoMoradorLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroApartamentoLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botBuscaMoradorLog)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Cadastros");

        menuCadastroVisitante.setText("Visitante");
        menuCadastroVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroVisitanteActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastroVisitante);
        menuCadastroVisitante.getAccessibleContext().setAccessibleParent(menuCadastroVisitante);

        menuCadastroMorador.setText("Morador");
        menuCadastroMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroMoradorActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastroMorador);

        menuCadastroFuncionario.setText("Funcionario");
        menuCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastroFuncionario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroVisitanteActionPerformed
        new CadastroVisitante().setVisible(true);
    }//GEN-LAST:event_menuCadastroVisitanteActionPerformed

    private void menuCadastroMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroMoradorActionPerformed
        new CadastroMorador().setVisible(true);
    }//GEN-LAST:event_menuCadastroMoradorActionPerformed

    private void menuCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroFuncionarioActionPerformed
        new CadastroFuncionario().setVisible(true);
    }//GEN-LAST:event_menuCadastroFuncionarioActionPerformed

    private void botBuscaVisitanteLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botBuscaVisitanteLogActionPerformed
        
    }//GEN-LAST:event_botBuscaVisitanteLogActionPerformed

    private void comboDescLogItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDescLogItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDescLogItemStateChanged

    private void nomeVisitanteLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomeVisitanteLogMouseClicked
        if("Nome".equals(nomeVisitanteLog.getText())){
            nomeVisitanteLog.setText("");
            nomeVisitanteLog.setForeground(Color.black);
        }
    }//GEN-LAST:event_nomeVisitanteLogMouseClicked

    private void nomeVisitanteLogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeVisitanteLogFocusLost
        if(nomeVisitanteLog.getText().equals("")){
            nomeVisitanteLog.setText("Nome");
            nomeVisitanteLog.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_nomeVisitanteLogFocusLost

    private void nomeMoradorLogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeMoradorLogFocusLost
        if(nomeMoradorLog.getText().equals("")){
            nomeMoradorLog.setText("Nome");
            nomeMoradorLog.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_nomeMoradorLogFocusLost

    private void nomeMoradorLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomeMoradorLogMouseClicked
        if(nomeMoradorLog.getText().equals("Nome")){
            nomeMoradorLog.setText("");
            nomeMoradorLog.setForeground(Color.black);
        }
    }//GEN-LAST:event_nomeMoradorLogMouseClicked

    private void blocoMoradorLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blocoMoradorLogMouseClicked
        if(blocoMoradorLog.getText().equals("Bloco")){
            blocoMoradorLog.setText("");
            blocoMoradorLog.setForeground(Color.black);
        }
    }//GEN-LAST:event_blocoMoradorLogMouseClicked

    private void blocoMoradorLogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_blocoMoradorLogFocusLost
        if(blocoMoradorLog.getText().equals("")){
            blocoMoradorLog.setText("Bloco");
            blocoMoradorLog.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_blocoMoradorLogFocusLost

    private void numeroApartamentoLogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroApartamentoLogFocusLost
        if(numeroApartamentoLog.getText().equals("")){
            numeroApartamentoLog.setText("Nº Apartamento");
            numeroApartamentoLog.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_numeroApartamentoLogFocusLost

    private void numeroApartamentoLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroApartamentoLogMouseClicked
        if(numeroApartamentoLog.getText().equals("Nº Apartamento")){
            numeroApartamentoLog.setText("");
            numeroApartamentoLog.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_numeroApartamentoLogMouseClicked

    private void detalheVisitanteLogFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detalheVisitanteLogFocusLost
        if(detalheVisitanteLog.getText().equals("")){
            detalheVisitanteLog.setText("Descrição de serviço");
            detalheVisitanteLog.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_detalheVisitanteLogFocusLost

    private void detalheVisitanteLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detalheVisitanteLogMouseClicked
        if(detalheVisitanteLog.getText().equals("Descrição de serviço")){
            detalheVisitanteLog.setText("");
            detalheVisitanteLog.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_detalheVisitanteLogMouseClicked

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
            java.util.logging.Logger.getLogger(SCFP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SCFP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SCFP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SCFP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SCFP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField blocoMoradorLog;
    private javax.swing.JButton botBuscaMoradorLog;
    private javax.swing.JButton botBuscaVisitanteLog;
    private javax.swing.JComboBox<String> comboDescLog;
    private javax.swing.JTextArea detalheVisitanteLog;
    private javax.swing.JTable gridLog;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem menuCadastroFuncionario;
    private javax.swing.JMenuItem menuCadastroMorador;
    private javax.swing.JMenuItem menuCadastroVisitante;
    private javax.swing.JTextField nomeMoradorLog;
    private javax.swing.JTextField nomeVisitanteLog;
    private javax.swing.JTextField numeroApartamentoLog;
    private javax.swing.JTextField rgVisitanteLog;
    // End of variables declaration//GEN-END:variables
}
