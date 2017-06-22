package acervo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author gabriel
 */
public class Cadastro extends javax.swing.JFrame {

    Connection conexao;
    
    /**
     * Creates new form Cadastro
     * @param conexao
     * @throws java.sql.SQLException
     */
    public Cadastro(Connection conexao) throws SQLException {
        
        this.conexao = conexao;
        initComponents();

    }

    
    private void fecharCadastro() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.dispose();
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTelaCadastro = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        cadastroNome = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JLabel();
        cadastroUsuario = new javax.swing.JTextField();
        labelUsuario1 = new javax.swing.JLabel();
        cadastroSenha = new javax.swing.JTextField();
        cadastroSalvar = new javax.swing.JButton();
        cadastroCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Novo Usuário");
        setResizable(false);

        labelTelaCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acervo/imagens/user.png"))); // NOI18N
        labelTelaCadastro.setText("Cadastro de Novo Usuário");

        labelNome.setText("Nome:");

        labelUsuario.setText("Usuário:");

        cadastroUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validaTamanhoString(evt);
            }
        });

        labelUsuario1.setText("Senha:");

        cadastroSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validaTamanhoString(evt);
            }
        });

        cadastroSalvar.setText("Salvar");
        cadastroSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar(evt);
            }
        });

        cadastroCancelar.setText("Cancelar");
        cadastroCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleFecharCadastro(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastroCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastroSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTelaCadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadastroNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadastroUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsuario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadastroSenha, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelTelaCadastro)
                .addGap(18, 18, 18)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelUsuario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroSalvar)
                    .addComponent(cadastroCancelar))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void handleFecharCadastro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleFecharCadastro
        this.fecharCadastro();
    }//GEN-LAST:event_handleFecharCadastro

    private void salvar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar

        String nome = this.cadastroNome.getText();
        String senha = this.cadastroSenha.getText();
        String username = this.cadastroUsuario.getText();
        
        try {

            User novoUser = new User();
            novoUser.setNome(nome);
            novoUser.setSenha(senha);
            novoUser.setUser(username);

            Users usuarios = new Users(this.conexao);
            usuarios.inserir(novoUser);
            
            Dialogs.sucesso("Usuário inserido com sucesso!", "Sucesso");
            
            this.fecharCadastro();

        } catch (SQLException ex) {

            String msg = "Erro :: " + ex.getMessage();
            Dialogs.erro(msg, "Erro no cadastro");

        }
        
    }//GEN-LAST:event_salvar

    private void validaTamanhoString(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validaTamanhoString

        JTextField campo = (JTextField) evt.getComponent();
        
        if (campo.getText().length() > 10) {

            Dialogs.erro("Este campo não pode conter mais de 10 caracteres.", "Erro");
            campo.setText(campo.getText().substring(0, 10));

        }
        
    }//GEN-LAST:event_validaTamanhoString



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastroCancelar;
    private javax.swing.JTextField cadastroNome;
    private javax.swing.JButton cadastroSalvar;
    private javax.swing.JTextField cadastroSenha;
    private javax.swing.JTextField cadastroUsuario;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTelaCadastro;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelUsuario1;
    // End of variables declaration//GEN-END:variables
}
