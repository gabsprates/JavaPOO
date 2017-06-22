package acervo;

import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author gabriel
 */
public class Acervo extends javax.swing.JFrame {
    
    private final Connection conexao;

    /**
     * Creates new form Acervo
     * @throws java.sql.SQLException
     */
    public Acervo() throws SQLException {
        
        this.conexao = new ConnectionFactory().getConnection();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel labelTelaLogin = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelAindaNaoCadastrado = new javax.swing.JLabel();
        cadastre_se = new javax.swing.JButton();
        senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acervo Pessoal de Livros");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fecharPrograma(evt);
            }
        });

        labelTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acervo/imagens/books.png"))); // NOI18N
        labelTelaLogin.setText("Acervo Pessoal de Livros");

        labelLogin.setText("Login");

        labelSenha.setText("Senha");

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fazerLogin(evt);
            }
        });

        labelAindaNaoCadastrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAindaNaoCadastrado.setText("Ainda não é cadastrado?");

        cadastre_se.setText("Cadastre-se aqui");
        cadastre_se.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCadastro(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelAindaNaoCadastrado, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(senha)))
                            .addComponent(jSeparator1)
                            .addComponent(entrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelaLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(cadastre_se, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelTelaLogin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entrar)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAindaNaoCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastre_se)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fazerLogin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fazerLogin
        
        Users usuarios = new Users(this.conexao);
        
        try {

            User userLogin = usuarios.getUserBy(this.login.getText());
            
            if (userLogin == null) {

                throw new Exception("Nenhum usuário com este login");

            } else if (!new String(this.senha.getPassword()).equals(userLogin.getSenha())) {

                throw new Exception("Senha incorreta");

            }

            this.login.setText("");
            this.senha.setText("");
            System.out.println("LOGIN EFETUADO COM SUCESSO!!");

        } catch (SQLException ex) {
            Dialogs.erro(ex.getMessage(), "Erro com o banco de dados");
        } catch (Exception ex) {
            Dialogs.erro(ex.getMessage(), "Erro de login");
        }
        
    }//GEN-LAST:event_fazerLogin

    private void abrirCadastro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCadastro
        
        Cadastro telaCadastro;

        try {

            telaCadastro = new Cadastro(this.conexao);
            telaCadastro.setVisible(true);

        } catch (SQLException ex) {
            
        }
        
    }//GEN-LAST:event_abrirCadastro

    private void fecharPrograma(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharPrograma
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_fecharPrograma

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
            java.util.logging.Logger.getLogger(Acervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            
            try {
                new Acervo().setVisible(true);
            } catch (SQLException ex) {
                Dialogs.erro(ex.getMessage(), "Erro ao executar programa");
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastre_se;
    private javax.swing.JButton entrar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAindaNaoCadastrado;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
