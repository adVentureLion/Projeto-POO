package dao;

import java.util.Iterator;
import java.util.Set;
import database.ProdutoDB;
import models.Produto;

public class ProdutoDAO extends ProdutoDB implements InterProdutoDAO{

    @Override
    public boolean adicionarProduto(Produto produto) {
        Set<Produto> produtos = super.listarProdutos();
        Iterator<Produto> pIterator = produtos.iterator();
        boolean cadastrou = true;

        if(produtos.isEmpty()) {
            super.cadastrarProduto(produto);
           return cadastrou = true;
        }
        if (!produtos.isEmpty()) {
            while(pIterator.hasNext()) {
                Produto p = pIterator.next();
                if(p.getCodigo() == produto.getCodigo())
                    cadastrou = false;
                else
                    cadastrou = true;
            }
            if(cadastrou)
                super.cadastrarProduto(produto);
        }  
        return cadastrou;
    }

    @Override
    public void excluirProduto(int codigo) {
        Set<Produto> produtos = super.listarProdutos();
        produtos.removeIf(produto -> produto.getCodigo() == codigo);
        Iterator<Produto> pIterator = produtos.iterator();
        super.excluirDadosProdutos();
        while(pIterator.hasNext()) {
            Produto p = pIterator.next();
            this.adicionarProduto(p);
        }      
    }

    @Override
    public void autualizarPreço(Produto produto) {
        
        
    }

    @Override
    public Set<Produto> listarProdutos() {
        return super.listarProdutos();
    }

   
    
}
