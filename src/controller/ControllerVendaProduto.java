package controller;

import dao.VendaProdutoDAO;
import models.VendaProduto;

public class ControllerVendaProduto {
    private VendaProdutoDAO vendaProdutoDAO;

    public ControllerVendaProduto() {
        this.vendaProdutoDAO = new VendaProdutoDAO();
    }

    public boolean venderProdutoController(ControllerProduto cp ,VendaProduto vendaProd) {
        return this.vendaProdutoDAO.venderProduto(cp, vendaProd);
    }
}
