package View;

import conexaoDB.ConexaoDB;
import entidades.Produto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProdutoView extends javax.swing.JFrame {

    public ProdutoView() {
        initComponents();
        listarValores();

    }

    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        cadastrarProduto = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        consultarProduto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        updateProduto = new javax.swing.JButton();
        txtIdA = new javax.swing.JTextField();
        txtNomeA = new javax.swing.JTextField();
        txtPrecoA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        deleteProduto = new javax.swing.JButton();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastrarProduto.setText("Cadastrar");
        cadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProdutoActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "Id", "Nome", "Preco"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);
        if (tabelaProduto.getColumnModel().getColumnCount() > 0) {
            tabelaProduto.getColumnModel().getColumn(0).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(1).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(2).setResizable(false);
        }

        consultarProduto.setText("Consultar");
        consultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarProdutoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Preco");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        updateProduto.setText("Alterar");
        updateProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProdutoActionPerformed(evt);
            }
        });

        txtIdA.setEditable(false);
        txtIdA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAActionPerformed(evt);
            }
        });

        txtNomeA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAActionPerformed(evt);
            }
        });

        jLabel4.setText("Id");

        jLabel5.setText("Nome");

        jLabel6.setText("Preco");

        deleteProduto.setText("Excluir");
        deleteProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProdutoActionPerformed(evt);
            }
        });

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(jLabel2))
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(txtPreco,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                168,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(txtNome,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                168,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(cadastrarProduto,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(23, 23, 23)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(consultarProduto)
                                                                                        .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                375,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(0, 40, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator5,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 495,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(updateProduto)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel4))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(txtPrecoA,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                168,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtNomeA,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                168,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtIdA,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                126,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(deleteProduto)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84,
                                        Short.MAX_VALUE)
                                .addComponent(cadastrarProduto)
                                .addGap(62, 62, 62)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(consultarProduto)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 489,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtIdA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNomeA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPrecoA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(97, 97, 97)
                                .addComponent(updateProduto)
                                .addGap(29, 29, 29)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(deleteProduto)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomeActionPerformed
    }

    private void cadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cadastrarProdutoActionPerformed

        inserirProduto();
        listarValores();

    }

    private void consultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_consultarProdutoActionPerformed

        listarValores();
    }

    private void updateProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateProdutoActionPerformed

        updateProduto();
        listarValores();
    }

    private void txtNomeAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNomeAActionPerformed

    }

    private void deleteProdutoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteProdutoActionPerformed

        deleteProduto();
        listarValores();

    }

    private void txtIdAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIdAActionPerformed

    }

    private void idActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idActionPerformed

    }

    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tabelaProdutoMouseClicked

        CarregarProduto();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    e);
        } catch (InstantiationException e) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    e);
        } catch (IllegalAccessException e) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    e);
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    e);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoView().setVisible(true);
            }
        });
    }

    private javax.swing.JButton updateProduto;
    private javax.swing.JButton cadastrarProduto;
    private javax.swing.JButton consultarProduto;
    private javax.swing.JButton deleteProduto;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtIdA;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeA;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtPrecoA;

    private void inserirProduto() {

        String nome = txtNome.getText();
        Double preco = Double.valueOf(txtPreco.getText());
        Produto pd = new Produto(nome, preco);
        ConexaoDB mysql = null;
        mysql = new ConexaoDB();

        try {
            mysql.insertProduto(pd);
        } catch (Exception e) {
            System.out.println("Erro na função inserirProduto() da classe ProdutoView -> " + e);
            throw new RuntimeException(e);
        }

    }

    private void listarValores() {

        try {

            ConexaoDB mysql = new ConexaoDB();
            DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
            model.setNumRows(0);

            String filtro = id.getText();
            System.out.println(filtro);

            ArrayList<Produto> resultado = (ArrayList<Produto>) mysql.selectProduto(filtro);

            for (int num = 0; num < resultado.size(); num++) {

                model.addRow(new Object[] {

                        resultado.get(num).getIdProduto(),
                        resultado.get(num).getNomeProduto(),
                        resultado.get(num).getPrecoProduto()
                });
            }

        } catch (Exception e) {
            System.out.println("Erro na função listarValores() da classe ProdutoView -> " + e);
            throw new RuntimeException(e);

        }
    }

    private void CarregarProduto() {

        int setar = tabelaProduto.getSelectedRow();

        txtIdA.setText(tabelaProduto.getModel().getValueAt(setar, 0).toString());
        txtNomeA.setText(tabelaProduto.getModel().getValueAt(setar, 1).toString());
        txtPrecoA.setText(tabelaProduto.getModel().getValueAt(setar, 2).toString());

    }

    private void updateProduto() {

        int idProduto;
        String nomeProduto;
        double precoProduto;

        idProduto = Integer.parseInt(txtIdA.getText());
        nomeProduto = txtNomeA.getText();
        precoProduto = Double.valueOf(txtPrecoA.getText());

        Produto produto = new Produto(idProduto, nomeProduto, precoProduto);

        ConexaoDB mysql = null;
        mysql = new ConexaoDB();

        try {
            mysql.updateProduto(produto);
        } catch (Exception e) {
            System.out.println("Erro na função updateProduto() da classe ProdutoView ->" + e);
            throw new RuntimeException(e);
        }

    }

    private void deleteProduto() {

        int idProduto;

        idProduto = Integer.parseInt(txtIdA.getText());

        Produto produto = new Produto(idProduto);

        ConexaoDB mysql = null;
        mysql = new ConexaoDB();

        try {
            mysql.deleteProduto(produto);
        } catch (Exception e) {
            System.out.println("Erro na função deleteProduto() da classe ProdutoView -> " + e);
            throw new RuntimeException(e);
        }

    }

}
