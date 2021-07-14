package controller;

import java.util.Set;

import dao.ProdutoDAO;
import models.Produto;

public class ControleProduto {
    private ProdutoDAO produtoDAO;

    public ControleProduto(){
        this.produtoDAO = new ProdutoDAO();
    }

    public boolean adicionarProdutoController(Produto produto){
       return this.produtoDAO.adicionarProduto(produto);
    }

    public void excluirProduto(int codigo){
        this.produtoDAO.excluirProduto(codigo);
    }

    public Set<Produto> listarProdutosController() {
        return this.produtoDAO.listarProdutos();
    }


}
