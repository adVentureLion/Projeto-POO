package dao;

import java.util.List;

import dao.daoInterfaces.InterVendasDAO;
import database.VendasDB;
import models.VendaCliente;
import models.Vendas;

public class VendasDAO extends VendasDB implements InterVendasDAO {
    List<Vendas> vendas;

    public VendasDAO() {
        this.vendas = super.listarVendas();
    }

    public void atualizarVendas(List<VendaCliente> vendasCliente) {
        super.atualizarAqurivoVendas(vendasCliente);
    }

    @Override
    public List<Vendas> exibirVendasFeitas() {
        return this.vendas;
    }
}
