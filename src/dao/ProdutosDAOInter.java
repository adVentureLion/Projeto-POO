package dao;

import java.util.List;

import models.Produtos;

public interface ProdutosDAOInter {
    public void adicionarProduto (Produtos produto);
    
    public void excluirProduto(Produtos produto);

    public void autualizarPreço(Produtos produto);

    public List<Produtos> ListarProdutos();
}
