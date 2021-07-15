package dao;

import java.util.Set;

import models.Produto;

public interface InterProdutoDAO {
    public boolean adicionarProduto (Produto produto);

    public boolean adicionarNoEstoque (int codigo, int qtd);
    
    public void excluirProduto(int codigo);

    public boolean atualizarDadosProduto(Produto produto);

    public Set<Produto> exibirProdutos();
}
