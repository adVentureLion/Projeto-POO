package models;

import java.io.Serializable;

public class Produtos implements Serializable {
    private String nome;
    private int codigo;
    private double valor;
    private int qtd; 

    public Produtos(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public Produtos(int codigo, String nome, double valor, int qtd){
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

}
