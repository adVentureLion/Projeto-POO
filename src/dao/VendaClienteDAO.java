package dao;

import java.util.List;

import dao.daoInterfaces.InterVendaClienteDAO;
import models.VendaCliente;
import models.VendaProduto;

public class VendaClienteDAO implements InterVendaClienteDAO {
    @Override
    public void calcularCompraCliente(VendaCliente vendaCli) {
        List<VendaProduto> vendaProd = vendaCli.getVendaProd();
        for (VendaProduto produtoSelecionado : vendaProd) {
            vendaCli.setValorDaVenda(produtoSelecionado.getValorVendaProduto() + vendaCli.getValorDaVenda());
        }
    }
}
