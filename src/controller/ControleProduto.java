package controller;

import java.util.Set;

import dao.ProdutoDAO;
import models.Produto;

public class ControleProduto {
    private ProdutoDAO produtoDAO;

    public void iniciarProdutos() {
        this.produtoDAO = new ProdutoDAO();
    }
    
    public boolean adicionarProdutoController(Produto produto){
       return this.produtoDAO.adicionarProduto(produto);
    }

    public boolean adicionarNoEstoque(int codigo, int qtd) {
        return this.produtoDAO.adicionarNoEstoque(codigo, qtd);
    }
    
    public boolean excluirProduto(int codigo){
        return this.produtoDAO.excluirProduto(codigo);
    }

    public void atualizarDadosProduto(Produto produto) {
        this.produtoDAO.atualizarDadosProduto(produto);
    }
    
    public Set<Produto> listarProdutosController() {
        return this.produtoDAO.exibirProdutos();
    }

    public Set<Produto> listarProdutosDisponiveisController() {
        return this.produtoDAO.exibirProdutosDisponiveis();
    }
    
    public Set<Produto> listarProdutosExcluidosController() {
        return this.produtoDAO.exibirProdutosExcluidos();
    }
    
    public void atualizarProdutosController() {
        this.produtoDAO.atualizarProdutos();  
    }
    

}
