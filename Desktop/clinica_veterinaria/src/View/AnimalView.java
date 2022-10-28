package View;

import conexaoDB.ConexaoDB;
import java.sql.Date;

public class AnimalView extends javax.swing.JFrame {

        public AnimalView() {
                initComponents();
        }

        private void initComponents() {

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

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(cadastrarAnimal)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel6)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(txtNascimento,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                110,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addComponent(jLabel5))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(txtSexo,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(txtEspecie,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                126,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabel3)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(txtCor))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabel2)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(txtRaca))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel1)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addComponent(txtNome,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                115,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(159, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
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
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(txtRaca,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(txtCor,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(txtEspecie,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(txtSexo,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(txtNascimento,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                55,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(cadastrarAnimal)
                                                                .addGap(54, 54, 54)));

                pack();
        }

        private void txtSexoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSexoActionPerformed
        }// GEN-LAST:event_txtSexoActionPerformed

        private void cadastrarAnimalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cadastrarAnimalActionPerformed

                String nome = txtNome.getText();
                String raca = txtRaca.getText();
                String especie = txtEspecie.getText();
                String sexo = (String) txtSexo.getSelectedItem();

                String cor = txtCor.getText();
                Date data = Date.valueOf(txtNascimento.getText());

                entidades.Animal animal = new entidades.Animal(nome, raca, data, especie, sexo, cor);

                ConexaoDB mysql = null;
                mysql = new ConexaoDB();

                try {
                        mysql.insertAnimal(animal);
                } catch (Exception e) {
                        System.out.println(
                                        "Erro na função cadastrarAnimalActionPerformed() na classe AnimalView -> " + e);
                        throw new RuntimeException(e);
                }
        }// GEN-LAST:event_cadastrarAnimalActionPerformed

        public static void main(String args[]) {
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException e) {
                        java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        e);
                } catch (InstantiationException e) {
                        java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        e);
                } catch (IllegalAccessException e) {
                        java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        e);
                } catch (javax.swing.UnsupportedLookAndFeelException e) {
                        java.util.logging.Logger.getLogger(AnimalView.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        e);
                }

                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new AnimalView().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton cadastrarAnimal;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JTextField txtCor;
        private javax.swing.JTextField txtEspecie;
        private javax.swing.JTextField txtNascimento;
        private javax.swing.JTextField txtNome;
        private javax.swing.JTextField txtRaca;
        private javax.swing.JComboBox<String> txtSexo;
        // End of variables declaration//GEN-END:variables
}
