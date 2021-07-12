package dao;

import java.util.List;

import models.Produto;

public interface InterProdutoDAO {
    public void adicionarProduto (Produto produto);
    
    public void excluirProduto(Produto produto);

    public void autualizarPreço(Produto produto);

    public List<Produto> listarProdutos();
}
