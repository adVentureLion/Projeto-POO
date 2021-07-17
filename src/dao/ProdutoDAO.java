package dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import database.ProdutoDB;
import models.Produto;

public class ProdutoDAO extends ProdutoDB implements InterProdutoDAO{
    private Set<Produto> produtos; 
    private Set<Produto> produtosExcluidos; 

    public ProdutoDAO() {
        this.produtos = super.listarProdutos();
        this.produtosExcluidos = super.listarProdutosExcluidos();
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
    public boolean excluirProduto(int codigo) {
        Iterator<Produto> pIterator = this.produtos.iterator();
        boolean excluiu = false;
        while(pIterator.hasNext()) {
            Produto p = pIterator.next();
            if(p.getCodigo() == codigo) {
                this.produtosExcluidos.add(p);               
                excluiu = true;
            }
        }
        this.produtos.removeIf(produto -> produto.getCodigo() == codigo);
        return excluiu;
        
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

    @Override
    public Set<Produto> exibirProdutosDisponiveis() {
        Set<Produto> pDisponiveis = new HashSet<>();
        Iterator<Produto> pIterator = this.produtos.iterator();
        while(pIterator.hasNext()) {
            Produto p  = pIterator.next();
            if(p.getQtd() > 0){
                pDisponiveis.add(p);
            }
        }
        return pDisponiveis;
    }

    @Override
    public Set<Produto> exibirProdutosExcluidos() { 
        return this.produtosExcluidos;
    }

    public void atualizarProdutos() {
        super.atualizarAqurivoProdutos(produtos);
        super.atualizarAqurivoProdutosExcluidos(produtosExcluidos);   
    }
   
    
}
