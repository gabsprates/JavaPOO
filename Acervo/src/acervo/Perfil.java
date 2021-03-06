package acervo;

import java.sql.Connection;

/**
 *
 * @author gabriel
 */
public class Perfil extends javax.swing.JFrame {

    private Connection conexao;
    private final User usuario;
    
    /**
     * Creates new form Perfil
     * @param usuario
     */
    public Perfil(User usuario) {
        
        initComponents();
        this.usuario = usuario;
        this.labelNome.setText(usuario.getNome());
        this.labelLogin.setText(usuario.getUser());

    }


    public void setConnection(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelTitleLogin = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelAcoes = new javax.swing.JLabel();
        editarDados = new javax.swing.JButton();
        btnNovoLivro = new javax.swing.JButton();
        buscarLivro = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perfil do Usuário");
        setResizable(false);

        labelNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acervo/imagens/user_24x24.png"))); // NOI18N
        labelNome.setText("Nome Compledo do Usuário");
        labelNome.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        labelTitleLogin.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelTitleLogin.setText("Login:");

        labelAcoes.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelAcoes.setText("Opções:");

        editarDados.setText("Editar meus dados");
        editarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarDados(evt);
            }
        });

        btnNovoLivro.setText("Inserir novo livro");
        btnNovoLivro.setToolTipText("");
        btnNovoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleNovoLivro(evt);
            }
        });

        buscarLivro.setText("Buscar livro");
        buscarLivro.setToolTipText("");
        buscarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLivros(evt);
            }
        });

        sair.setText("Sair do sistema");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharSistema(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(labelTitleLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(editarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovoLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTitleLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sair)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fecharSistema(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharSistema
        
        this.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_fecharSistema

    private void editarDados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarDados
        
        EdicaoUser edicaoUser = new EdicaoUser(this.usuario);
        edicaoUser.setConnection(this.conexao);
        edicaoUser.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_editarDados

    private void handleNovoLivro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleNovoLivro
        
        NovoLivro novoLivro = new NovoLivro(this.usuario);
        novoLivro.setConnection(this.conexao);
        novoLivro.setVisible(true);
        
    }//GEN-LAST:event_handleNovoLivro

    private void buscarLivros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLivros
        
        Livros livros = new Livros(this.conexao);
        livros.setUsuario(this.usuario);
        
        BuscaLivros busca = new BuscaLivros(livros);
        busca.setVisible(true);
        
    }//GEN-LAST:event_buscarLivros


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoLivro;
    private javax.swing.JButton buscarLivro;
    private javax.swing.JButton editarDados;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelAcoes;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTitleLogin;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
