package dao.daoInterfaces;

import java.util.Set;

import models.Produto;

public interface InterProdutoDAO {
    public boolean adicionarProduto (Produto produto);

    public boolean adicionarNoEstoque (int codigo, int qtd);
    
    public boolean removerNoEstoque (int codigo, int qtd);
    
    public boolean excluirProduto(int codigo);

    public boolean atualizarDadosProduto(Produto produto);

    public Set<Produto> exibirProdutos();
    
    public Set<Produto> exibirProdutosDisponiveis();
    
    public Set<Produto> exibirProdutosExcluidos();
}
