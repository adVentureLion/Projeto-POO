package controller;

import java.util.List;

import dao.ProdutoDAO;
import models.Produto;

public class ControleProduto {
    private ProdutoDAO produtoDAO;

    public ControleProduto(){
        this.produtoDAO = new ProdutoDAO();
    }

    public void adicionarProdutoController(Produto produto){
        this.produtoDAO.adicionarProduto(produto);
    }

    public List<Produto> listarProdutosController() {
        return this.produtoDAO.listarProdutos();
    }


}
