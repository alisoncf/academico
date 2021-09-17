package model;

public class Professor {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Area area;
    
    public Professor() {
    }
  



    public Professor(int id, String nome, String email, String cpf, String telefone, Area area) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.area = area;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
