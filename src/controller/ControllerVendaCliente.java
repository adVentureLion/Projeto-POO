package controller;

import dao.VendaClienteDAO;
import models.VendaCliente;

public class ControllerVendaCliente {
    private VendaClienteDAO vendaClienteDAO;

    public ControllerVendaCliente() {
        this.vendaClienteDAO =  new VendaClienteDAO();
    }

    public void calcularCompraCliente(VendaCliente vendaCliente) {
        this.vendaClienteDAO.calcularCompraCliente(vendaCliente);
    }
}
