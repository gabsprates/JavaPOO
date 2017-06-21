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
    
    User(String nome, String user, String senha) {
        this.id = null;
        this.nome = nome;
        this.user = user;
        this.senha = senha;
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
 
}
