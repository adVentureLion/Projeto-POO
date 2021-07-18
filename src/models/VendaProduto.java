package models;

public class VendaProduto {
    private Produto produto;
    private int quantidade;
    private double valorVendaProduto;
    
    public VendaProduto(Produto produto, int quantidade) {
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }   
    public Produto getProduto() {
        return produto;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setValorVendaProduto(double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }
    public double getValorVendaProduto() {
        return valorVendaProduto;
    }

    @Override
    public String toString() {
        return this.getProduto().salvarNaVendas();
    }

}
