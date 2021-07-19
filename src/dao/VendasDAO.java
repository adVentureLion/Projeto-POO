package dao;

import java.util.List;

import dao.daoInterfaces.InterVendasDAO;
import database.VendasDB;
import models.VendaCliente;

public class VendasDAO extends VendasDB implements InterVendasDAO {
    List<VendaCliente> vendasClientes;

    public VendasDAO() {
        this.vendasClientes = super.listarVendas();
    }

    public void adicionarVendas(VendaCliente vendaCliente) {
        this.vendasClientes.add(vendaCliente);
    }

    @Override
    public List<VendaCliente> exibirVendasFeitas() {
        return this.vendasClientes;
    }

    public void atualizarAqurivoVendas() {
        super.atualizarAqurivoVendas(vendasClientes);
    }
}
