package models;

public class PecaTurbina extends Produtos {
    public PecaTurbina(String nome, double valor){
        super(nome, valor);
        this.nome = nome;
        this.valor = valor;
    }

    public PecaTurbina(int codigo, String nome, double valor, int qtd){
        super(codigo, nome, valor, qtd);
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }
   
    public void listarProdutos(){

    }

}
