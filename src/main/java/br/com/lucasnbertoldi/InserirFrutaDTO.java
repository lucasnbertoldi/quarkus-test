package br.com.lucasnbertoldi;

public class InserirFrutaDTO {
    
    private String nome;
    private Integer qtd;

    public String getNome() {
        return nome;
    }
    public Integer getQtd() {
        return qtd;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
