package models;

public class PecaMotor extends Produtos {
    
    public PecaMotor(String nome, double valor){
        super(nome, valor);
        this.nome = nome;
        this.valor = valor;
    }

    public PecaMotor(int codigo, String nome, double valor, int qtd){
        super(codigo, nome, valor, qtd);
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    public void listarProdutos(){
        
    }
}
