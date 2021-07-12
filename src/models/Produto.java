package models;


public class Produto {
    private String nome;
    private int codigo;
    private double valor;
    private int qtd; 

    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public Produto(int codigo, String nome, double valor, int qtd){
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public double getValor() {
        return valor;
    }

    public String toStringW() {
        return this.codigo+";"+
               this.nome+";"+
               this.valor+";"+
               this.qtd;
    }
    
    public String toString() {
        return this.codigo+";"+
               this.nome+";"+
               this.valor+";"+
               this.qtd;
    }
}
