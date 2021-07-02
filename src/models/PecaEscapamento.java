package models;

public class PecaEscapamento extends Produtos{
    public PecaEscapamento(String nome, double valor){
        super(nome, valor);
        this.nome = nome;
        this.valor = valor;
    }

    public PecaEscapamento(int codigo, String nome, double valor, int qtd){
        super(codigo, nome, valor, qtd);
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    public void listarProdutos(){

    }
}
