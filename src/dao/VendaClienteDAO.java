package dao;

import java.util.List;

import dao.daoInterfaces.InterVendaClienteDAO;
import models.Venda;
import models.VendaProduto;

public class VendaClienteDAO implements InterVendaClienteDAO {
    @Override
    public void calcularCompraCliente(Venda vendaCli) {
        List<VendaProduto> vendaProd = vendaCli.getVendaProd();
        for (VendaProduto produtoSelecionado : vendaProd) {
            vendaCli.setValorDaVenda(produtoSelecionado.getValorVendaProduto() + vendaCli.getValorDaVenda());
        }
    }
}
