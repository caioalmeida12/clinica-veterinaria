/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import conexaoDB.AnimalDB;
import conexaoDB.FuncionarioDB;
import conexaoDB.ProdutoDB;
import entidades.Animal;
import entidades.Funcionario;
import entidades.Produto;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luanf
 */
public class AnimalView extends javax.swing.JFrame {

    /**
     * Creates new form AnimalView
     */
    public AnimalView() {
        initComponents();
        listarValores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtRaca = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        txtEspecie = new javax.swing.JTextField();
        txtSexo = new javax.swing.JComboBox<>();
        txtNascimento = new javax.swing.JTextField();
        cadastrarAnimal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAnimal = new javax.swing.JTable();
        alterarAnimal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        apagarCampos = new javax.swing.JButton();
        excluirAnimal = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        buscarFiltro = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Raca");

        jLabel3.setText("Cor");

        jLabel4.setText("Especie");

        jLabel5.setText("Sexo");

        jLabel6.setText("Data de Nascimento");

        txtSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", " " }));
        txtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoActionPerformed(evt);
            }
        });

        cadastrarAnimal.setText("Cadastrar");
        cadastrarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAnimalActionPerformed(evt);
            }
        });

        tabelaAnimal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Raca", "Cor", "Sexo", "Especie", "Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAnimalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaAnimal);

        alterarAnimal.setText("Alterar");
        alterarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAnimalActionPerformed(evt);
            }
        });

        jLabel7.setText("Id");

        txtId.setEditable(false);

        apagarCampos.setText("Apagar Campos");
        apagarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarCamposActionPerformed(evt);
            }
        });

        excluirAnimal.setText("Excluir");
        excluirAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirAnimalActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Nome" }));

        buscarFiltro.setText("Buscar");
        buscarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtId))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCor))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRaca))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addComponent(apagarCampos))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cadastrarAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alterarAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(excluirAnimal))
                            .addComponent(txtFiltro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarFiltro)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(apagarCampos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarAnimal)
                    .addComponent(alterarAnimal)
                    .addComponent(excluirAnimal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alterarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarAnimalActionPerformed
        // TODO add your handling code here:
        
        AlterarAnimal();
        listarValores();
    }//GEN-LAST:event_alterarAnimalActionPerformed

    private void tabelaAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAnimalMouseClicked
        // TODO add your handling code here:
        
        CarregarProduto();
    }//GEN-LAST:event_tabelaAnimalMouseClicked

    private void apagarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarCamposActionPerformed
        // TODO add your handling code here:
        
        
        apagaCampos();
    }//GEN-LAST:event_apagarCamposActionPerformed

    private void excluirAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirAnimalActionPerformed
        // TODO add your handling code here:
        
        
        deletarAnimal();
        listarValores();
    }//GEN-LAST:event_excluirAnimalActionPerformed

    private void buscarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFiltroActionPerformed
        // TODO add your handling code here:
        
        
                if (txtFiltro.getText().length() > 0) {
        listarValoresFiltro();
        }else{
            listarValores();
        }
    }//GEN-LAST:event_buscarFiltroActionPerformed

    private void txtSexoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSexoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtSexoActionPerformed

    private void cadastrarAnimalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cadastrarAnimalActionPerformed
        // TODO add your handling code here:

       cadastrarAnimal();
       listarValores();
    }// GEN-LAST:event_cadastrarAnimalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnimalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarAnimal;
    private javax.swing.JButton apagarCampos;
    private javax.swing.JButton buscarFiltro;
    private javax.swing.JButton cadastrarAnimal;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton excluirAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaAnimal;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRaca;
    private javax.swing.JComboBox<String> txtSexo;
    // End of variables declaration//GEN-END:variables

private void listarValores() {

        try {
            AnimalDB animal = new AnimalDB();
            DefaultTableModel model = (DefaultTableModel) tabelaAnimal.getModel();
            model.setNumRows(0);

            

           

            ArrayList<Animal> resultado = (ArrayList<Animal>)animal.selectAnimal();

            for (int num = 0; num < resultado.size(); num++) {

                model.addRow(new Object[] {

                        resultado.get(num).getIdAnimal(),
                        resultado.get(num).getNomeAnimal(),
                        resultado.get(num).getRacaAnimal(),
                        resultado.get(num).getCorAnimal(),
                        resultado.get(num).getSexoAnimal(),
                        resultado.get(num).getEspecieAnimal(),
                        resultado.get(num).getNascimentoAnimal()
                });
            }

        } catch (Exception e) {
            System.out.println("erro");
            throw new RuntimeException(e);

        }
    }



private void listarValoresFiltro() {

        try {
            AnimalDB animal = new AnimalDB();
            DefaultTableModel model = (DefaultTableModel) tabelaAnimal.getModel();
            model.setNumRows(0);
            
            
            String filtro = null;
            
            int valorCombo = combo.getSelectedIndex();
            
            if(valorCombo == 0 ){
                
                filtro = "Where idAnimal= "+txtFiltro.getText();
            }else{
                
                filtro = "Where nomeAnimal LIKE '%"+txtFiltro.getText()+"%'";
            }

            

            ArrayList<Animal> resultado = (ArrayList<Animal>)animal.selectAnimal(filtro);

            for (int num = 0; num < resultado.size(); num++) {

                model.addRow(new Object[] {

                        resultado.get(num).getIdAnimal(),
                        resultado.get(num).getNomeAnimal(),
                        resultado.get(num).getRacaAnimal(),
                        resultado.get(num).getCorAnimal(),
                        resultado.get(num).getSexoAnimal(),
                        resultado.get(num).getEspecieAnimal(),
                        resultado.get(num).getNascimentoAnimal()
                });
            }

        } catch (Exception e) {
            System.out.println("erro");
            throw new RuntimeException(e);

        }
    }




public void cadastrarAnimal(){
    
    String nome = txtNome.getText();
        String raca = txtRaca.getText();
        String especie = txtEspecie.getText();
        String sexo = (String) txtSexo.getSelectedItem();

        String cor = txtCor.getText();
        Date data = Date.valueOf(txtNascimento.getText());

        Animal animal = new Animal(nome, raca, data, especie, sexo, cor);

        AnimalDB mysql = new AnimalDB();

        try {
            mysql.insertAnimal(animal);
        } catch (Exception ex) {
            System.out.println("erro no view para inserir animal");
            throw new RuntimeException(ex);
        }
}

 private void AlterarAnimal() {

        

       int id = Integer.parseInt(txtId.getText());
     String nome = txtNome.getText();
        String raca = txtRaca.getText();
        String especie = txtEspecie.getText();
        String sexo = (String) txtSexo.getSelectedItem();
        String cor = txtCor.getText();
        Date data = Date.valueOf(txtNascimento.getText());
        
        Animal animal = new Animal(id, nome, raca, data, especie, sexo, cor);
        
        AnimalDB mysql = new AnimalDB();

        
        try {
            mysql.updateAnimal(animal);
        } catch (Exception ex) {
            System.out.println("erro no view para alterar animal");
            throw new RuntimeException(ex);
        }

    }
 
 
  private void CarregarProduto() {

        int setar = tabelaAnimal.getSelectedRow();

        txtId.setText(tabelaAnimal.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaAnimal.getModel().getValueAt(setar, 1).toString());
        txtRaca.setText(tabelaAnimal.getModel().getValueAt(setar, 2).toString());
        txtCor.setText(tabelaAnimal.getModel().getValueAt(setar, 3).toString());
        txtSexo.setSelectedItem(tabelaAnimal.getModel().getValueAt(setar, 4).toString());
        txtEspecie.setText(tabelaAnimal.getModel().getValueAt(setar, 5).toString());
        txtNascimento.setText(tabelaAnimal.getModel().getValueAt(setar, 6).toString());

    }
  
   private void apagaCampos(){
      
      txtId.setText("");
        txtNome.setText("");
        txtRaca.setText("");
        txtCor.setText("");
        txtSexo.setSelectedItem(0);
        txtEspecie.setText("");
        txtNascimento.setText("");
      
      
  }
   
   
    private void deletarAnimal() {

       

        int idAnimal = Integer.parseInt(txtId.getText());

        Animal animal = new Animal(idAnimal);

        AnimalDB mysql = new AnimalDB();

        try {
            mysql.deleteAnimal(idAnimal);
        } catch (Exception ex) {
            System.out.println("erro no view para excluir produto");
            throw new RuntimeException(ex);
        }

    }
    
    

}
