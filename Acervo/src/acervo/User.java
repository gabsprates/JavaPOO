package acervo;

/**
 *
 * @author gabriel
 */
class User {
    private Integer id;
    private String nome;
    private String user;
    private String senha;
    
    User() {
        this.id = null;
    }


    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
    // getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return this.getNome()
                + " :: " + this.getUser()
                + "(" + this.getId() + ")";
    }
    
    
    public boolean validaSenha(String senha){
        return this.senha.equals(senha);
    }

}
