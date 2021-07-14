package dao;

import java.util.Iterator;
import java.util.Set;
import database.ClienteDB;
import models.Cliente;

public class ClienteDAO extends ClienteDB implements InterClienteDAO {

    @Override
    public boolean adicionarCliente(Cliente cliente) {
        Set<Cliente> clientes = this.listarClientes();
        Iterator<Cliente> cIterator = clientes.iterator();
        boolean adicionou = true;

        if(clientes.isEmpty()) {
            super.cadastrarCliente(cliente);
            return adicionou;
        }
        else {
            while(cIterator.hasNext()) {
                Cliente c = cIterator.next();
                if(c.getCpf().equals(cliente.getCpf())) {
                    adicionou = false;
                }
                else
                    adicionou = true;
            }
            if(adicionou)
                super.cadastrarCliente(cliente);
        }
        return adicionou;
    }

    @Override
    public void excluirCliente(String nome) {
        Set<Cliente> clientes = super.listarClientes();
        clientes.removeIf(cliente -> cliente.getNome().equals(nome));
        Iterator<Cliente> cIterator = clientes.iterator();
        super.excluirDadosCliente();
        while(cIterator.hasNext()) {
            Cliente c = cIterator.next();
            this.adicionarCliente(c);
        }
    }

    @Override
    public void atualizarDados(Cliente cliente) {

    }

    @Override
    public Set<Cliente> listarClientes() {
        return super.listarClientes();
    }
}
