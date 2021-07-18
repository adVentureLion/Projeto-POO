package dao;

import controller.ControllerProduto;
import dao.daoInterfaces.InterVendaProdutoDAO;
import models.VendaProduto;

public class VendaProdutoDAO implements InterVendaProdutoDAO{

    @Override
    public boolean venderProduto(ControllerProduto cp, VendaProduto vendaProd) {
        if(vendaProd.getQuantidade() > vendaProd.getProduto().getQtd()) 
            return false;
        else {
            cp.removerNoEstoque(vendaProd.getProduto().getCodigo(), vendaProd.getQuantidade());
            vendaProd.setValorVendaProduto(vendaProd.getProduto().getValor() * vendaProd.getQuantidade());
            return true;
        }
        
    }
}
