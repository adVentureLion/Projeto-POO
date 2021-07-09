package dao;

import java.util.List;

import database.ProdutoEscritaLeitura;
import models.Produtos;

public class ProdutosDAO extends ProdutoEscritaLeitura implements ProdutosDAOInter{

    @Override
    public void adicionarProduto(Produtos produto) {
        salvarProduto(produto);
    }

    @Override
    public void excluirProduto(Produtos produto) {
        
        
    }

    @Override
    public void autualizarPreço(Produtos produto) {
        
        
    }

    @Override
    public List<Produtos> ListarProdutos() {
        return super.listarProdutos();
    }

   
    
}
