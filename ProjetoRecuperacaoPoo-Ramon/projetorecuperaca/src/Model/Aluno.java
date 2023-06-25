package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Aluno {

    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal nota3;
    private BigDecimal nota4;
    private BigDecimal media;
    private boolean aprovacao;

    public Aluno(String nome, String email, String telefone,
                 LocalDate dataNascimento, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3, BigDecimal nota4, BigDecimal media, boolean aprovacao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.media = media;
        this.aprovacao = aprovacao;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public BigDecimal getNota4() {
        return nota4;
    }

    public void setNota4(BigDecimal nota4) {
        this.nota4 = nota4;
    }

    public BigDecimal getMedia() {
        return media;
    }

    public void setMedia(BigDecimal media) {
        this.media = media;
    }

    public boolean isAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", nota4=" + nota4 +
                ", media=" + media +
                ", aprovacao=" + aprovacao +
                '}';
    }
}