package View;

import conexaoDB.ConexaoDB;
import entidades.Funcionario;
import entidades.Produto;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FuncionarioView extends javax.swing.JFrame {

        public FuncionarioView() {
                initComponents();
        }

        private void initComponents() {

                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel7 = new javax.swing.JLabel();
                txtNome = new javax.swing.JTextField();
                txtCPF = new javax.swing.JTextField();
                txtEmail = new javax.swing.JTextField();
                txtSalario = new javax.swing.JTextField();
                txtTelefone = new javax.swing.JTextField();
                txtEndereco = new javax.swing.JTextField();
                cadastrarFuncionario = new javax.swing.JButton();
                txtNascimento = new javax.swing.JTextField();
                consultarFuncionario = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                tabelaFuncionario = new javax.swing.JTable();
                id = new javax.swing.JTextField();

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null }
                                },
                                new String[] {
                                                "Title 1", "Title 2", "Title 3", "Title 4"
                                }));
                jScrollPane1.setViewportView(jTable1);

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setText("Nome");

                jLabel2.setText("CPF");

                jLabel3.setText("Email");

                jLabel4.setText("Salario");

                jLabel5.setText("Telefone");

                jLabel6.setText("Endereco");

                jLabel7.setText("Data de nascimento");

                txtNome.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtNomeActionPerformed(evt);
                        }
                });

                txtCPF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtCPFActionPerformed(evt);
                        }
                });

                txtEndereco.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtEnderecoActionPerformed(evt);
                        }
                });

                cadastrarFuncionario.setText("Cadastrar");
                cadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cadastrarFuncionarioActionPerformed(evt);
                        }
                });

                consultarFuncionario.setText("Consultar");
                consultarFuncionario.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                consultarFuncionarioActionPerformed(evt);
                        }
                });

                tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null }
                                },
                                new String[] {
                                                "Id", "Nome", "Email", "Cpf", "Nascimento", "Salario", "Telefone"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane2.setViewportView(tabelaFuncionario);

                id.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                idActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel5)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(txtTelefone,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                138,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(txtSalario,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                90,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel1)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(txtNome,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                310,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(txtCPF,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                212,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(txtEmail,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                221,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                false)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabel7)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addComponent(txtNascimento))
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(jLabel6)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(txtEndereco,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                252,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addComponent(jScrollPane2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                541,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(cadastrarFuncionario)
                                                                                                .addGap(114, 114, 114)
                                                                                                .addComponent(id,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                76,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(consultarFuncionario)))
                                                                .addContainerGap(153, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(txtNome,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(txtCPF,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(9, 9, 9)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(txtEmail,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(txtSalario,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(txtTelefone,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(txtEndereco,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(txtNascimento,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                50,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(cadastrarFuncionario)
                                                                                .addComponent(consultarFuncionario)
                                                                                .addComponent(id,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                338,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomeActionPerformed
        }// GEN-LAST:event_txtNomeActionPerformed

        private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCPFActionPerformed
        }// GEN-LAST:event_txtCPFActionPerformed

        private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtEnderecoActionPerformed
        }// GEN-LAST:event_txtEnderecoActionPerformed

        private void cadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cadastrarFuncionarioActionPerformed
                String nome = txtNome.getText();
                Integer cpf = Integer.valueOf(txtCPF.getText());
                String email = txtEmail.getText();
                float salario = Float.parseFloat(txtSalario.getText());
                Date data = Date.valueOf(txtNascimento.getText());
                String telefone = txtTelefone.getText();
                String endereco = txtEndereco.getText();

                Funcionario funcionario = new Funcionario(nome, cpf, data, email, salario, telefone, endereco);

                ConexaoDB mysql = null;
                mysql = new ConexaoDB();

                try {
                        mysql.insertFuncionario(funcionario);
                } catch (Exception e) {
                        System.out.println("erro no view para inserir funcionario");
                        throw new RuntimeException(e);
                }

        }// GEN-LAST:event_cadastrarFuncionarioActionPerformed

        private void consultarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_consultarFuncionarioActionPerformed

                listarValores();
        }// GEN-LAST:event_consultarFuncionarioActionPerformed

        private void idActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idActionPerformed
        }// GEN-LAST:event_idActionPerformed

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException e) {
                        java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, e);
                } catch (InstantiationException e) {
                        java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, e);
                } catch (IllegalAccessException e) {
                        java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, e);
                } catch (javax.swing.UnsupportedLookAndFeelException e) {
                        java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, e);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new FuncionarioView().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton cadastrarFuncionario;
        private javax.swing.JButton consultarFuncionario;
        private javax.swing.JTextField id;
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
        private javax.swing.JTable tabelaFuncionario;
        private javax.swing.JTextField txtCPF;
        private javax.swing.JTextField txtEmail;
        private javax.swing.JTextField txtEndereco;
        private javax.swing.JTextField txtNascimento;
        private javax.swing.JTextField txtNome;
        private javax.swing.JTextField txtSalario;
        private javax.swing.JTextField txtTelefone;
        // End of variables declaration//GEN-END:variables

        private void listarValores() {

                try {
                        ConexaoDB mysql = new ConexaoDB();
                        DefaultTableModel model = (DefaultTableModel) tabelaFuncionario.getModel();
                        model.setNumRows(0);

                        String filtro;

                        if (!id.getText().isBlank()) {
                                filtro = "WHERE idProduto = " + id.getText();
                        } else {
                                filtro = "";
                        }

                        ArrayList<Funcionario> resultado = (ArrayList<Funcionario>) mysql.selectFuncionario(filtro);

                        for (int num = 0; num < resultado.size(); num++) {

                                model.addRow(new Object[] {

                                                resultado.get(num).getIdFuncionario(),
                                                resultado.get(num).getNomeFuncionario(),
                                                resultado.get(num).getEmailFuncionario(),
                                                resultado.get(num).getCpfFuncionario(),
                                                resultado.get(num).getNascimentoFuncionario(),
                                                resultado.get(num).getSalarioFuncionario(),
                                                resultado.get(num).getTelefoneFuncionario()
                                });
                        }

                } catch (Exception e) {
                        System.out.println("Erro na função listarValores() da classe FuncionarioView -> " + e);
                        throw new RuntimeException(e);

                }
        }
}
