package controller;

import java.util.List;

import dao.ProdutosDAO;
import models.Produtos;

public class ControleProduto {
    private ProdutosDAO produtoDAO;

    public ControleProduto(){
        this.produtoDAO = new ProdutosDAO();
    }

    public void salvarProdutoController(Produtos produto){
        this.produtoDAO.salvarProduto(produto);
    }

    public List<Produtos> listarProdutosController() {
        return this.produtoDAO.listarProdutos();
    }


}
