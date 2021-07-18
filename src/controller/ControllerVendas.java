package controller;

import java.util.List;

import dao.VendasDAO;
import models.VendaCliente;
import models.Vendas;

public class ControllerVendas {
    private VendasDAO vendasDAO;

    public void iniciarVendas() {
        this.vendasDAO = new VendasDAO();  
    }

    public void atualizarVendasController(List<VendaCliente> vendasCliente){
        this.vendasDAO.atualizarVendas(vendasCliente);
    }

    public List<Vendas> listarVendasController() {
        return this.vendasDAO.exibirVendasFeitas();
    }
}
