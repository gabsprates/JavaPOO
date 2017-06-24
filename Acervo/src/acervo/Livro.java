package acervo;

/**
 *
 * @author gabriel
 */
class Livro {
    private Integer id;
    private Integer userId;
    private String titulo;
    private String autor;
    
    Livro() {
        this.id = -1;
    }


    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    // getters
    public int getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return this.getTitulo()
                + " :: " + this.getAutor()
                + "(" + this.getId() + ")";
    }

}
