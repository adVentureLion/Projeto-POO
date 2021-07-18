package controller;

import dao.VendaClienteDAO;
import models.Venda;

public class ControllerVendaCliente {
    private VendaClienteDAO vendaClienteDAO;

    public ControllerVendaCliente() {
        this.vendaClienteDAO =  new VendaClienteDAO();
    }

    public void calcularCompraCliente(Venda vendaCliente) {
        this.vendaClienteDAO.calcularCompraCliente(vendaCliente);
    }
}
