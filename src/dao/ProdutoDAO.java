package dao;

import java.util.List;

import database.ProdutoDB;
import models.Produto;

public class ProdutoDAO extends ProdutoDB implements InterProdutoDAO{

    @Override
    public void adicionarProduto(Produto produto) {
        super.adicionarProduto(produto);
    }

    @Override
    public void excluirProduto(Produto produto) {
        
        
    }

    @Override
    public void autualizarPreço(Produto produto) {
        
        
    }

    @Override
    public List<Produto> listarProdutos() {
        return super.listarProdutos();
    }

   
    
}
