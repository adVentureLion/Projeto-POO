package dao.daoInterfaces;

import controller.ControllerProduto;
import models.VendaProduto;

public interface InterVendaProdutoDAO {
    
    public boolean venderProduto(ControllerProduto cp, VendaProduto vendaProd);
}
