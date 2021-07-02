package models;

public abstract class Produtos {
    protected String nome;
    protected int codigo;
    protected double valor;
    protected int qtd; 

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

    public void adicionarNoEstoque(int cod, int qtd){

    }

    public void subtrairDoEstoque(int qtd){
        setQtd(getQtd() - qtd);
    }
    
    public void listarProdutos(){

    }
}
