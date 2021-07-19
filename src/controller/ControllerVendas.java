package controller;

import java.util.List;

import dao.VendasDAO;
import models.VendaCliente;


public class ControllerVendas {
    private VendasDAO vendasDAO;

    public void iniciarVendas() {
        this.vendasDAO = new VendasDAO();  
    }

    public void adicionarVendasController(VendaCliente vendasCliente){
        this.vendasDAO.adicionarVendas(vendasCliente);
    }

    public List<VendaCliente> listarVendasController() {
        return this.vendasDAO.exibirVendasFeitas();
    }
    
    public void atualizarAqurivoVendasController() {
        this.vendasDAO.atualizarAqurivoVendas();
    }
}
