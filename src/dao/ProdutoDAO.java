package dao;

import java.util.Iterator;
import java.util.Set;
import database.ProdutoDB;
import models.Produto;

public class ProdutoDAO extends ProdutoDB implements InterProdutoDAO{
    private Set<Produto> produtos; 

    public ProdutoDAO() {
        this.produtos = super.listarProdutos();
    }

    @Override
    public boolean adicionarProduto(Produto produto) {
        Iterator<Produto> pIterator = this.produtos.iterator();
        boolean cadastrou = true;

        while(pIterator.hasNext()) {
            Produto p = pIterator.next();
            if(p.getCodigo() == produto.getCodigo())
                cadastrou = false;
            else
                cadastrou = true;
        }
        if(cadastrou)
            this.produtos.add(produto);
        
        return cadastrou;
    }

    @Override
    public boolean adicionarNoEstoque(int codigo, int qtd) {
        Iterator<Produto> pIterator = this.produtos.iterator();
        while(pIterator.hasNext()) {
            Produto p = pIterator.next();
            if(p.getCodigo() == codigo){
                p.setQtd(p.getQtd() + qtd);
                return true;
            }
        }
            return false;
    }           

    @Override
    public void excluirProduto(int codigo) {
        this.produtos.removeIf(produto -> produto.getCodigo() == codigo);

    }

    @Override
    public boolean atualizarDadosProduto(Produto produto) {
        Iterator<Produto> pIterator = this.produtos.iterator();
        while(pIterator.hasNext()) {
            Produto p = pIterator.next();
            if(p.getCodigo() == produto.getCodigo()){
                p.setNome(produto.getNome());
                p.setValor(produto.getValor());
                return true;
            }
        }
            return false;
    }           

    @Override
    public Set<Produto> exibirProdutos() {
        return this.produtos;
    }

   
    
}
