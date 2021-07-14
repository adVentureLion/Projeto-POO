package models;

import java.util.Objects;

public class Produto {
    private String nome;
    private int codigo;
    private double valor;
    private int qtd; 

    public Produto(int codigo, String nome, double valor){
        this.codigo = codigo;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;

        Produto produto = (Produto) obj; 
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.codigo);
    }

    @Override
    public String toString() {
        return this.codigo+";"+
               this.nome+";"+
               this.valor+";"+
               this.qtd;
    }
}
