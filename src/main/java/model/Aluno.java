package model;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String nascimento;
    public Aluno() {
    }
    public Aluno(String nome, String email, String nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public Aluno(int id, String nome, String email, String nascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
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
    public String getNascimento() {
        return nascimento;
    }
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
