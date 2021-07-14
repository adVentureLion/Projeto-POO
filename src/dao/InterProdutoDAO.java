package dao;

import java.util.Set;

import models.Produto;

public interface InterProdutoDAO {
    public boolean adicionarProduto (Produto produto);
    
    public void excluirProduto(int codigo);

    public void autualizarPreço(Produto produto);

    public Set<Produto> listarProdutos();
}
